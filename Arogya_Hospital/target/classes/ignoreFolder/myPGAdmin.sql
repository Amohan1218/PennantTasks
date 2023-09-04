create table ms_doctor_schedule(doc_id numeric PRIMARY KEY, dcsc_schedule varchar(7), dcsc_mrng_slot varchar(3), dcsc_evng_slot varchar(3), dcsc_slot_duration numeric, dcsc_range numeric);

insert into ms_doctor_schedule values
(101, 'X1X34X6', 'YES', 'YES', 30, 16),
(102, '01XX45X', 'YES', 'NO', 20, 35),
(103, 'X1X3X5X', 'NO', 'YES', 10, 45),
(104, '0X2XX5X', 'YES', 'NO', 30, 10),
(105, 'X1X3XX6', 'YES', 'YES', 15, 45),
(106, 'X12XX5X', 'NO', 'YES', 30, 15),
(107, '01X3XX6', 'NO', 'YES', 10, 55),
(108, 'XX2XX5X', 'YES', 'NO', 30, 10),
(109, 'X1X3X5X', 'YES', 'YES', 20, 25),
(110, '01XX45X', 'NO', 'YES', 30, 13);

select * from ms_doctor_schedule;
delete from ms_doctor_schedule;


select dcsc_range from ms_doctor_schedule where doc_id = 101
select slot_date from ms_appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = 101 group by slot_date
-------------------------------------------------------------------------------------------------
create table ms_appointment_slot_calendar(slot_id serial primary key, slot_doc_id numeric, slot_date date, slot_from time, slot_to time, slot_status text DEFAULT 'Available');

select * from ms_appointment_slot_calendar;
delete from ms_appointment_slot_calendar;


CREATE OR REPLACE FUNCTION ms_generate_slots()
RETURNS TRIGGER AS $$
DECLARE
	i integer;
	j integer;
    d_range integer;
	dt date;
	d_sch varchar(7);
	dcsc_match varchar(4);
	s_from time;
	s_to time;
	mrng_time numeric; 
	slot integer;
	evng_time numeric;
	doctor_id numeric;
BEGIN
	mrng_time := EXTRACT(HOUR FROM '12:30'::time)*60 + EXTRACT(MINUTE FROM '12:30'::time) - 
				 EXTRACT(HOUR FROM '09:00'::time)*60 + EXTRACT(MINUTE FROM '09:00'::time);
	evng_time := EXTRACT(HOUR FROM '18:00'::time)*60 + EXTRACT(MINUTE FROM '18:00'::time) - 
				 EXTRACT(HOUR FROM '14:00'::time)*60 + EXTRACT(MINUTE FROM '14:00'::time);
	doctor_id := NEW.doc_id;
    d_range := NEW.dcsc_range;
	d_sch := NEW.dcsc_schedule;
	
	IF NEW.dcsc_mrng_slot = 'YES' THEN
		FOR j IN 1..d_range LOOP
			s_from := '09:00'::time;
			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
			dt := now()::date + j;
			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
				FOR i IN 1..slot LOOP
					
					INSERT INTO ms_appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
					s_from := s_to;
					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
				END LOOP;
			END IF;		
		END LOOP;	
	END IF;
	--------------------------------------------
	IF NEW.dcsc_evng_slot = 'YES' THEN
		FOR j IN 1..d_range LOOP
			s_from := '14:00'::time;
			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
			
			dt := now()::date + j;
			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
				FOR i IN 1..slot LOOP
					
					INSERT INTO ms_appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
					s_from := s_to;
					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
				END LOOP;
			END IF;		
		END LOOP;
	END IF;
	
	RETURN NEW;
END;
$$ language plpgsql;

CREATE TRIGGER ms_doc_schd_generate_slots
AFTER INSERT on ms_doctor_schedule
FOR EACH ROW
EXECUTE FUNCTION ms_generate_slots();

DROP TRIGGER IF EXISTS ms_doc_schd_generate_slots ON ms_doctor_schedule;


select slot_date from appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = 106 group by slot_date;
select * from appointment_slot_calendar;














-- create table sample1(id serial PRIMARY KEY, dcsc date);
-- create table sample2(name varchar(20));

-- create or replace function add_dates() returns trigger as $$
-- declare
-- 	dt date;
-- BEGIN
-- 	dt := now()::date;
-- 	if new.name = 'chinnu' then
-- 		for i IN 1..3 LOOP
-- 		dt := dt + 1;
-- 		insert into sample1(dcsc) values(dt);
-- 	end loop;
-- 	end if;
-- 	return NEW;
-- END;
-- $$ language plpgsql;

-- create trigger t1
-- after insert on sample2
-- for each row
-- execute function add_dates();

-- DROP TRIGGER IF EXISTS t1 ON sample2;

-- insert into sample2 values('chinnu');
-- select * from sample1;