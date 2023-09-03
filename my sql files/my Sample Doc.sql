create table doctor_schedule(doc_id numeric PRIMARY KEY, dcsc_schedule varchar(7), dcsc_mrng_slot varchar(3), dcsc_evng_slot varchar(3), dcsc_slot_duration numeric);

insert into doctor_schedule values
(101, 'X123X5X', 'YES', 'YES', 30),
(102, 'X1X3X5X', 'NO', 'YES', 15),
(103, 'X123X5X', 'YES', 'YES', 10),
(105, 'X123X5X', 'YES', 'YES', 20),
(106, 'X123XX6', 'YES', 'NO', 15),
(107, 'XX23X5X', 'NO', 'YES', 15),
(108, 'X123XXX', 'YES', 'YES', 20),
(109, 'X1X3X5X', 'YES', 'NO', 15),
(110, 'X12XX5X', 'YES', 'YES', 30);

select * from doctor_schedule;
delete from doctor_schedule;


create table appointment_slot_calendar(slot_id serial primary key, slot_doc_id numeric, slot_date date, slot_from time, slot_to time, slot_status text DEFAULT 'Available');

select * from appointment_slot_calendar;
delete from appointment_slot_calendar;


CREATE or REPLACE FUNCTION update_slots_availablity()
returns trigger as $$
DECLARE
	i integer;
	j integer;
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
	d_sch := NEW.dcsc_schedule;
	
	IF NEW.dcsc_mrng_slot = 'YES' THEN
		FOR j IN 1..30 LOOP
			s_from := '09:00'::time;
			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
			dt := now()::date + j;
			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
				FOR i IN 1..slot LOOP
					
					INSERT INTO appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
					s_from := s_to;
					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
				END LOOP;
			END IF;		
		END LOOP;	
	END IF;
	--------------------------------------------
	IF NEW.dcsc_evng_slot = 'YES' THEN
		FOR j IN 1..30 LOOP
			s_from := '14:00'::time;
			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
			
			dt := now()::date + j;
			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
				FOR i IN 1..slot LOOP
					
					INSERT INTO appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
					s_from := s_to;
					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
				END LOOP;
			END IF;		
		END LOOP;
	END IF;
	
	RETURN NEW;
END;
$$ language plpgsql;

CREATE TRIGGER doctor_schedule_update_slots
AFTER INSERT on doctor_schedule
for each row
execute function update_slots_availablity();

DROP TRIGGER IF EXISTS doctor_schedule_update_slots ON doctor_schedule;


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