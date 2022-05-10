drop table if exists ers_users;
drop table if exists ers_reimbursement_type;


create table ers_users(
	ers_user_id serial constraint ers_user_pk primary key,
	ers_username varchar(50) unique not null,
	ers_password varchar(50) not null,
	user_first_name varchar(100) not null,
	user_last_name varchar(100) not null,
	user_email varchar(150) unique not null,
	user_role_id int not null
	
	--constraint user_roles_fk
	--foreign key (user_role_id)
	--references ers_user_roles
	
);

CREATE TABLE ers_reimbursement_type (
  reimb_type_id SERIAL CONSTRAINT reimb_type_pk PRIMARY KEY, 
  reimb_type VARCHAR(10) NOT NULL
);