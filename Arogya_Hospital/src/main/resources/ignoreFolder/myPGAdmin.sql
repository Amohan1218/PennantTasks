select * from doctorSchedule_bhaskar
-- ------------------ms_doctor_schedule--------------------------------------
CREATE TABLE ms_doctor_schedule
(doct_id integer, 
 doct_sindex smallint, 
 dcsc_schedule text,
 dcsc_avl_from time,
 dcsc_avl_to time,
 dcsc_app_slot int, 
 dcsc_range int
);
ALTER TABLE ms_doctor_schedule ADD CONSTRAINT cpk_ms_doc_schd PRIMARY KEY (doct_id, doct_sindex);

select * from ms_doctor_schedule;
delete from ms_doctor_schedule;
drop table ms_doctor_schedule;

insert into ms_doctor_schedule values
(101,1,'135','09:00:00','12:00:00',15,25),
(101,2,'246','14:00:00','17:00:00',15,25),
(102,1,'135','10:00:00','13:00:00',30,20),
(102,2,'246','15:00:00','18:00:00',30,20),
(103,1,'146','08:00:00','11:00:00',15,30),
(103,2,'127','09:00:00','12:00:00',15,30),
(104,1,'135','14:00:00','17:00:00',15,20),
(104,2,'246','10:00:00','13:00:00',15,20),
(105,1,'257','15:00:00','18:00:00',30,30),
(105,2,'346','08:00:00','11:00:00',30,30),
(106,1,'12345','11:00:00','13:00:00',15,20),
(107,1,'147','16:00:00','19:00:00',15,30),
(108,1,'267','09:00:00','12:00:00',15,20),
(109,1,'3467','14:30:00','17:30:00',30,20),
(110,1,'67','14:30:00','17:30:00',15,30);

-- ------------------ms_appointment_slot_calendar--------------------------------
create table ms_appointment_slot_calendar(slot_id serial primary key, slot_doc_id numeric, slot_date date, slot_from time, slot_to time, slot_status text DEFAULT 'Available');

delete from ms_appointment_slot_calendar;
select * from ms_appointment_slot_calendar where slot_doc_id = 101;

-- Function for get Slots for week

CREATE OR REPLACE FUNCTION get_Slots(docId integer, weekDay integer)	
RETURNS integer AS $$
DECLARE
    slot_duration integer;
    r_count integer;
    no_of_slots integer := 0 ;
    
    doc_avl_from time without time zone;
    doc_avl_to time without time zone;
BEGIN
    -- Doctor Slot Duration for 1 - Slot
    SELECT dcsc_app_slot INTO slot_duration FROM ms_doctor_schedule WHERE doct_id = docId and doct_sindex = 1;
    
    -- No. of records on based 
    SELECT COUNT(*) INTO r_count FROM ms_doctor_schedule WHERE doct_id = docId and dcsc_schedule LIKE '%' || weekDay || '%';
    
    FOR i IN 1..r_count LOOP
        
        SELECT dcsc_avl_from, dcsc_avl_to 
        INTO doc_avl_from, doc_avl_to
        FROM ms_doctor_schedule
        WHERE doct_id = docId and dcsc_schedule LIKE '%' || weekDay || '%' LIMIT 1 OFFSET (i - 1);

		no_of_slots := no_of_slots + (EXTRACT(HOUR FROM doc_avl_to - doc_avl_from)*60 + 
        	   EXTRACT(MINUTE FROM doc_avl_to - doc_avl_from)) / slot_duration;
    END LOOP;
    
    RETURN no_of_slots;
END;
$$ LANGUAGE plpgsql;

SELECT get_Slots(102, 3);


-- Function for get Slots for already generated

CREATE OR REPLACE FUNCTION get_Generated_Slots(docId integer, fromDate date)	
RETURNS integer AS $$
DECLARE
	s_count integer := 0;
BEGIN
	SELECT COUNT(*) INTO s_count FROM ms_appointment_slot_calendar 
    WHERE slot_doc_id = docId AND slot_date = fromDate;
    
    RETURN s_count;
END;
$$ LANGUAGE plpgsql;

DROP FUNCTION get_Generated_Slots(integer, date);

SELECT get_Generated_Slots(101, '2023-09-04')


-- Procedure for Generating Slots for given doctor
CREATE OR REPLACE generate_slots_for_doctor(docId integer) AS $$
DECLARE
BEGIN
	
END;
$$ LANGUAGE PLPGSQL;

CALL generate_slots_for_doctor(101);


-- Trigger for insert on ms_doctor_schedule
CREATE OR REPLACE FUNCTION ms_generate_slots()
RETURNS TRIGGER AS $$
DECLARE
	i integer;
	j integer;
	
	doctor_id numeric;
    d_sch varchar(7);
    doc_avl_from time;
    doc_avl_to time;
    doc_slot_duration integer;
    d_range integer;
    s_time numeric;
    s_from time;
	s_to time;
    dt date;
	dcsc_match varchar(4);
    slots integer;
    
BEGIN
    doctor_id := NEW.doct_id; -- Taking Doctor as an input
    d_sch := NEW.dcsc_schedule;
    doc_avl_from := NEW.dcsc_avl_from;
    doc_avl_to := NEW.dcsc_avl_to;
    doc_slot_duration := NEW.dcsc_app_slot;
    d_range := NEW.dcsc_range;
	
    s_time := EXTRACT(HOUR FROM doc_avl_to - doc_avl_from)*60 + EXTRACT(MINUTE FROM doc_avl_to - doc_avl_from);
	
    FOR j IN 1..d_range LOOP
        s_from := doc_avl_from::time;
        s_to := s_from + (doc_slot_duration || ' minutes')::INTERVAL;
        
        dt := now()::date + j;
        dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';

        IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
        d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN

            slots := CAST(s_time / doc_slot_duration as INTEGER); 
            FOR i IN 1..slots LOOP

                INSERT INTO ms_appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
                s_from := s_to;
                s_to := s_from + (doc_slot_duration || ' minutes')::INTERVAL;
            END LOOP;
        END IF;		
    END LOOP;	

	RETURN NEW;
END;
$$ language plpgsql;

CREATE TRIGGER ms_doc_schd_generate_slots
AFTER INSERT on ms_doctor_schedule
FOR EACH ROW
EXECUTE FUNCTION ms_generate_slots();

DROP TRIGGER IF EXISTS ms_doc_schd_generate_slots ON ms_doctor_schedule;


--------------------------------------------------------------------------------------------
-- ******Rough work******* --

select slot_date from appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = 106 group by slot_date;
select * from appointment_slot_calendar;


select dcsc_range from ms_doctor_schedule where doc_id = 101
select slot_date from ms_appointment_slot_calendar where slot_status = 'Available' and slot_doc_id = 101 group by slot_date


------------------------------------------------------------------------------------------------

-- create table ms_doctor_schedule(
-- doc_id numeric PRIMARY KEY, 
-- dcsc_schedule varchar(7), 
-- dcsc_mrng_slot varchar(3), 
-- dcsc_evng_slot varchar(3), 
-- dcsc_slot_duration numeric, 
-- dcsc_range numeric);

-- insert into ms_doctor_schedule values
-- (101, 'X1X34X6', 'YES', 'YES', 30, 16),
-- (102, '01XX45X', 'YES', 'NO', 20, 35),
-- (103, 'X1X3X5X', 'NO', 'YES', 10, 45),
-- (104, '0X2XX5X', 'YES', 'NO', 30, 10),
-- (105, 'X1X3XX6', 'YES', 'YES', 15, 45),
-- (106, 'X12XX5X', 'NO', 'YES', 30, 15),
-- (107, '01X3XX6', 'NO', 'YES', 10, 55),
-- (108, 'XX2XX5X', 'YES', 'NO', 30, 10),
-- (109, 'X1X3X5X', 'YES', 'YES', 20, 25),
-- (110, '01XX45X', 'NO', 'YES', 30, 13);


-- CREATE OR REPLACE FUNCTION ms_generate_slots()
-- RETURNS TRIGGER AS $$
-- DECLARE
-- 	i integer;
-- 	j integer;
--     d_range integer;
-- 	dt date;
-- 	d_sch varchar(7);
-- 	dcsc_match varchar(4);
-- 	s_from time;
-- 	s_to time;
-- 	mrng_time numeric; 
-- 	slot integer;
-- 	evng_time numeric;
-- 	doctor_id numeric;
-- BEGIN
-- 	mrng_time := EXTRACT(HOUR FROM '12:30'::time)*60 + EXTRACT(MINUTE FROM '12:30'::time) - 
-- 				 EXTRACT(HOUR FROM '09:00'::time)*60 + EXTRACT(MINUTE FROM '09:00'::time);
-- 	evng_time := EXTRACT(HOUR FROM '18:00'::time)*60 + EXTRACT(MINUTE FROM '18:00'::time) - 
-- 				 EXTRACT(HOUR FROM '14:00'::time)*60 + EXTRACT(MINUTE FROM '14:00'::time);
-- 	doctor_id := NEW.doc_id; -- Taking Doctor as an input
--     d_range := NEW.dcsc_range;
-- 	d_sch := NEW.dcsc_schedule;
	
-- 	IF NEW.dcsc_mrng_slot = 'YES' THEN
-- 		FOR j IN 1..d_range LOOP
-- 			s_from := '09:00'::time;
-- 			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
-- 			dt := now()::date + j;
-- 			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
-- 			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
-- 			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
-- 				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
-- 				FOR i IN 1..slot LOOP
					
-- 					INSERT INTO ms_appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
-- 					s_from := s_to;
-- 					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
-- 				END LOOP;
-- 			END IF;		
-- 		END LOOP;	
-- 	END IF;
-- 	--------------------------------------------
-- 	IF NEW.dcsc_evng_slot = 'YES' THEN
-- 		FOR j IN 1..d_range LOOP
-- 			s_from := '14:00'::time;
-- 			s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
			
-- 			dt := now()::date + j;
-- 			dcsc_match := '%' || CAST(EXTRACT(DOW from dt::date) AS VARCHAR) || '%';
			
-- 			IF d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR 
-- 			d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match OR d_sch LIKE dcsc_match THEN
				
-- 				slot := CAST(mrng_time / NEW.dcsc_slot_duration as INTEGER); 
-- 				FOR i IN 1..slot LOOP
					
-- 					INSERT INTO ms_appointment_slot_calendar(slot_doc_id, slot_date, slot_from, slot_to) VALUES(doctor_id, dt, s_from, s_to);
-- 					s_from := s_to;
-- 					s_to := s_from + (NEW.dcsc_slot_duration || ' minutes')::INTERVAL;
				
-- 				END LOOP;
-- 			END IF;		
-- 		END LOOP;
-- 	END IF;
	
-- 	RETURN NEW;
-- END;
-- $$ language plpgsql;

-- CREATE TRIGGER ms_doc_schd_generate_slots
-- AFTER INSERT on ms_doctor_schedule
-- FOR EACH ROW
-- EXECUTE FUNCTION ms_generate_slots();

-- DROP TRIGGER IF EXISTS ms_doc_schd_generate_slots ON ms_doctor_schedule;