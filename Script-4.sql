DROP TABLE IF EXISTS ers_reimbursements;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_reimbursement_type;
DROP TABLE IF EXISTS ers_reimbursement_status;
DROP TABLE IF EXISTS ers_user_roles;




CREATE TABLE ers_reimbursement_status(
	status_id serial CONSTRAINT reimb_status_pk PRIMARY KEY,
	reimb_type_id int
);

CREATE TABLE ers_reimbursement_type (
  type_id serial CONSTRAINT reimb_type_pk PRIMARY KEY, 
  reimb_type VARCHAR(10) NOT NULL
);

CREATE TABLE ers_user_roles(
	user_role_id serial CONSTRAINT user_role_pk PRIMARY KEY,
	user_role varchar(10) UNIQUE NOT NULL
);

CREATE TABLE ers_users(
	user_id serial CONSTRAINT user_pk PRIMARY KEY,
	username varchar(50) UNIQUE NOT NULL,
	password varchar(50) NOT NULL,
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
	amount decimal(10,2) NOT NULL,
	submitted date NOT NULL,
	resolved date,
	description varchar(250),
	receipt bytea,
	author_id int NOT NULL,
	resolver_id int,
	status_id int NOT NULL,
	type_id int NOT NULL,

CONSTRAINT user_fk_auth -- name from physical model chart
FOREIGN KEY (author) -- name of column in current tbale
REFERENCES ers_users(user_id), -- name of table (and column) in foreign table

CONSTRAINT user_fk_resolver -- name from physical model chart
FOREIGN KEY (resolver) -- name of column in current tbale
REFERENCES ers_users(user_id), -- name of table (and column) in foreign table

CONSTRAINT reimb_status_fk -- name from physical model chart
FOREIGN KEY (status_id) -- name of column in current tbale
REFERENCES ers_reimbursement_status(status_id), -- name of table (and column) in foreign table

CONSTRAINT ers_reimb_type_fk -- name from physical model chart
FOREIGN KEY (type_id) -- name of column in current table
REFERENCES ers_reimbursement_type(type_id) -- name of table (and column) in foreign table

);

