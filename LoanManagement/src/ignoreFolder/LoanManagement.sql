CREATE TABLE ms_auser(
	auser_id serial PRIMARY KEY, 
    auser_username varchar(20) UNIQUE NOT NULL, 
    auser_password varchar(50) NOT NULL
);
SELECT * FROM ms_auser;

INSERT INTO ms_auser (auser_username, auser_password)
VALUES ('manju', 'Amohansai123'), ('manoj', 'Amohansai123');




CREATE TABLE ms_customers(
	cust_id serial PRIMARY KEY,
    cust_firstname varchar(50),
    cust_lastname varchar(50),
    cust_dob date, 
    cust_panno varchar(10),
    cust_mobile bigint NOT NULL CHECK (cust_mobile >= 1000000000 AND cust_mobile <= 9999999999),
    cust_address varchar(255),
    cust_gname varchar(50),
    cust_luudate date,
    cust_luser int, 
    FOREIGN KEY (cust_luser) REFERENCES ms_auser(auser_id)
);

INSERT INTO ms_customers (cust_firstname, cust_lastname, cust_dob, cust_panno, cust_mobile, cust_address, cust_gname, cust_luudate, cust_luser)
VALUES ('John', 'Doe', '1990-01-15', 'ABC123XYZ', 1234567890, '123 Main St', 'Guardian Name', '2023-08-30', 1);

INSERT INTO ms_customers (cust_firstname, cust_lastname, cust_dob, cust_panno, cust_mobile, cust_address, cust_gname, cust_luudate, cust_luser)
VALUES ('Sai', 'Mohan', '2003-01-15', 'ABC123XYZ', 1234567890, '123 Main St', 'Guardian Name', '2023-09-30', 1);
SELECT * FROM ms_customers;


CREATE TABLE ms_loantypes(
	lnty_id serial PRIMARY KEY,
    lnty_name varchar(50),
    lnty_desc varchar(255)
);
INSERT INTO ms_loantypes (lnty_name, lnty_desc)
VALUES ('Personal Loan', 'Short-term unsecured loan for personal expenses');
SELECT * FROM ms_loantypes;


Create table ms_loanApplicants(
	lnap_id serial PRIMARY KEY,
    lnap_cust_id int,
    lnap_apdate date, 
    lnap_lnty_id smallint,
    lnap_amount numeric, 
    lnap_emi_range_from numeric, 
    lnap_emp_range_to numeric, 
    lnap_nom_requested int,
    lnap_cibil_score numeric, --updated by company
    lnap_status varchar(4), -- INPR/APRV/RJCD
    lnap_conclusion_remarks varchar(255),
    lnap_processed_user int,
    lnap_processed_date date,
    FOREIGN KEY (lnap_processed_user) REFERENCES ms_auser(auser_id),
    FOREIGN KEY (lnap_lnty_id) REFERENCES ms_loantypes(lnty_id),
    FOREIGN KEY (lnap_cust_id) REFERENCES ms_customers(cust_id)
);
-- Insert record 1
INSERT INTO ms_loanApplicants (lnap_cust_id, lnap_apdate, lnap_lnty_id, lnap_amount, lnap_emi_range_from, lnap_emp_range_to, lnap_nom_requested, lnap_cibil_score, lnap_status, lnap_conclusion_remarks, lnap_processed_user, lnap_processed_date)
VALUES (1, '2023-08-31', 1, 5000.00, 1000.00, 2000.00, 2, 750, 'APRV', 'Loan approved', 1, '2023-08-31');

-- Insert record 2
INSERT INTO ms_loanApplicants (lnap_cust_id, lnap_apdate, lnap_lnty_id, lnap_amount, lnap_emi_range_from, lnap_emp_range_to, lnap_nom_requested, lnap_cibil_score, lnap_status, lnap_conclusion_remarks, lnap_processed_user, lnap_processed_date)
VALUES (2, '2023-08-31', 1, 7500.00, 1500.00, 3000.00, 3, 800, 'APRV', 'Loan approved', 1, '2023-08-31');

SELECT * FROM ms_loanApplicants;


CREATE TABLE loanApplicantsNominees(
	lnap_id int,
    lnap_nominee varchar(50),
    lanp_relation varchar(50),
    FOREIGN KEY (lnap_id) REFERENCES ms_loanApplicants(lnap_id)
);
SELECT * FROM loanApplicantsNominees;

