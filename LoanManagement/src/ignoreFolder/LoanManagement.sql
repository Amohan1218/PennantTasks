CREATE TABLE ms_auser(
	auser_id serial PRIMARY KEY, 
    auser_username varchar(20) UNIQUE NOT NULL, 
    auser_password varchar(50) NOT NULL
);
SELECT * FROM ms_auser;

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
SELECT * FROM ms_customers;

CREATE TABLE ms_loantypes(
	lnty_id serial PRIMARY KEY,
    lnty_name varchar(50),
    lnty_desc varchar(255)
);
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
SELECT * FROM ms_loanApplicants;

CREATE TABLE loanApplicantsNominees(
	lnap_id int,
    lnap_nominee varchar(50),
    lanp_relation varchar(50),
    FOREIGN KEY (lnap_id) REFERENCES ms_loanApplicants(lnap_id)
);
SELECT * FROM loanApplicantsNominees;

Select * from ms_loanApplicants

