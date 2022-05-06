# ERS_Villain_P1
Employee Reimbursment System (ERS) using Custom ORM


## User Stories:

[ ] An Employee can login
[ ] An Employee can view the Employee Homepage
[ ] An Employee can logout
[ ] An Employee can submit a reimbursement request
[ ] An Employee can view their pending reimbursement requests
[ ] An Employee can view their resolved reimbursement requests
[ ] An Employee can view their information
[ ] An Employee can update their information

### Stretch Goals:

[ ] An Employee can upload an image of his/her receipt as part of the reimbursement request
[ ] An Employee receives an email when one of their reimbursement requests is resolved

## Manager User Stories

[ ] A Manager can login
[ ] A Manager can view the Manager Homepage
[ ] A Manager can logout
[ ] A Manager can approve/deny pending reimbursement requests
[ ] A Manager can view all pending requests from all employees
[ ] A Manager can view all resolved requests from all employees and see which manager resolved it
[ ] A Manager can view all Employees
[ ] A Manager can view reimbursement requests from a single Employee

### Stretch Goals:

[ ] A Manager can view images of the receipts from reimbursement requests

## Technical Requirements

[ ] The back-end system shall use your custom ORM to connect to an AWS RDS Postgres database.
[ ] JDBC logic is abstracted away by the custom ORM
[ ] Programmatic persistence of entities (basic CRUD support) using custom ORM
[ ] File-based or programmatic configuration of entities
[ ] 60% line coverage of all service layer classes
[ ] Generated Jacoco reports that display coverage metrics
[ ] Usage of the java.util.Stream API within your project
[ ] Custom ORM source code should be included within the web application as a Maven dependency
[ ] The application shall use Postman to test endpoints that call your server-side components.
[ ] The application shall follow proper layered architecture
[ ] The application shall implement log4j for appropriate logging.

### Stretch Goals:

[ ] Custom ORM supports basic transaction management (begin, commit, savepoint, rollback)
[ ] Custom ORM supports connection pooling
[ ] Session-based caching to minimize calls to the database for already retrieved data
[ ] Deployment of web application to AWS EC2 (use of AWS Elastic Beanstalk is permitted)
[ ] Continuous integration pipelines that builds some main branch each project (the ORM and the web app, separately)
[ ] Passwords shall be encrypted in Java and securely stored in the database.

## Init Instructions

[x] Create a new private repository within this organization for your custom ORM (naming convention: ers_orm_name_p1; with orm_name being replaced by the name of your custom library)
[x] Make sure to add your trainer and team members as contributors to the repo
[ ] Create another new private repostory within this organization for your ERS web application (naming convention: ers_webapp_orm_name_p1; with orm_name being replaced by the name of your custom library)
[ ] Make sure to add your trainer and team members as contributors to the repo

