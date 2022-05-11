DROP TABLE IF EXISTS ers_reimbursement_status;
DROP TABLE IF EXISTS ers_reimbursement_type;
DROP TABLE IF EXISTS ers_user_roles;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_reimbursement;

CREATE TABLE ers_reimbursement_status(
	reimb_status_id serial CONSTRAINT reimb_status_pk PRIMARY KEY,
	reimb_type_id int
);

CREATE TABLE ers_reimbursement_type (
  reimb_type_id serial CONSTRAINT reimb_type_pk PRIMARY KEY, 
  reimb_type VARCHAR(10) NOT NULL
);

CREATE TABLE ers_user_roles(
	ers_user_role_id serial CONSTRAINT user_role_pk PRIMARY KEY,
	user_role int UNIQUE NOT NULL
);

CREATE TABLE ers_users(
	ers_user_id serial CONSTRAINT user_pk PRIMARY KEY,
	ers_username varchar(50) UNIQUE NOT NULL,
	ers_password varchar(50) NOT NULL,
	user_first_name varchar(100) NOT NULL,
	user_last_name varchar(100) NOT NULL,
	user_email varchar(150) UNIQUE NOT NULL,
	user_role_id int NOT NULL,
	
	CONSTRAINT user_roles_fk
	FOREIGN KEY (user_role_id)
	REFERENCES ers_user_roles
);

CREATE TABLE ers_reimbursements(
	reimb_id serial CONSTRAINT reimb_pk PRIMARY KEY,
	reimb_amount decimal(10,2) NOT NULL,
	reimb_submitted date NOT NULL,
	reimb_resolved date,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author int NOT NULL,
	reimb_resolver int,
	reimb_status_id int NOT NULL,
	reimb_type_id int NOT NULL,

CONSTRAINT ers_user_fk_auth -- name from physical model chart
FOREIGN KEY (reimb_author) -- name of column in current tbale
REFERENCES ers_users(ers_user_id), -- name of table (and column) in foreign table

CONSTRAINT ers_user_fk_resolver -- name from physical model chart
FOREIGN KEY (reimb_resolver) -- name of column in current tbale
REFERENCES ers_users(ers_user_id), -- name of table (and column) in foreign table

CONSTRAINT ers_reimb_status_fk -- name from physical model chart
FOREIGN KEY (reimb_status_id) -- name of column in current tbale
REFERENCES ers_reimbursement_status(reimb_status_id), -- name of table (and column) in foreign table

CONSTRAINT ers_reimb_type_fk -- name from physical model chart
FOREIGN KEY (reimb_type_id) -- name of column in current table
REFERENCES ers_reimbursement_type(reimb_type_id) -- name of table (and column) in foreign table

);

