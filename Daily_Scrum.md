# _Villain_ Scrum Meeting Notes <hr></hr>
### **Table of Contents:**

- [Daily Meeting Format](#daily-meeting-format)
- [Tentative Project Schedule/Deadlines](#tentative-project-scheduledeadlines)
- [Meeting Notes Template (@Levi)](#meeting-notes-template)
- Meeting Summaries
  - [Scrum 2: 5/10/22](#scrum-2-051022)
  - [Scrum 3: 5/13/22](#scrum-3-051122) 
  - [Scrum 4: 5/14/22](#scrum-4-051222)




<br>

<hr>

### **Daily Meeting Format:**

> ##### _NOTE_: This format is adjustable. Feel free to share your suggestions so that we can make this meeting as efficient as possible!
<br>

0. **GitHub/Git troubleshooting** 
    - Make sure all of your progress has been pushed to GitHub.
    - Handle any issues you may have regarding that. 

1. **What were you able to get done yesterday?**
    - should be brief, since we already track out changes via GitHub
    - update the team on where you are in terms of the project
  
2. **Were there any issues/problems you ran into since our last meeting?**

3. **Agenda:**
    - Message into the Discord groupchat or DM Levi for anything you want to discuss as a team ahead of time OR
    - Remember to bring it up at the start of during this section of the meeting. 

4. **What do we want to accomplish by our next meeting?**
    - _*Levi will assign Issues and create milestones to each team member according to this list._

<br>




</br>
<hr>

### **_Tentative_ Project Schedule/Deadlines:**

| Date| Schedule/Deadlines     |     
|--  |------------------------------------------      |
| 10 | _Services start_| 
| 11| _Controller start_| 
| 12 | 
| 13 | | 
| 14 | _Debugging/Troubleshooting_       |
| 15 | _(**Ideally**) P1 Coding Finalized)_ |      
| 16 |  |  |
| 17 | _JuCaLe Presentation Practice_ |  
| 18 | _(**D-DAY**) P1 DEADLINE: Villain Presentation_  | 


<br>



</br>


<hr> 

### **Meeting Notes Template:**

### **SCRUM 4: 05/12/22**

1. **Progress Check** 
    
    - Julian: 
        - [ ] 
        - [ ] 
    <br> </br>
        
    - Calvin: 
        - [ ] 
        - [ ] 
    <br> </br>
    
    - Levi:
        - [ ] 
        - [ ] 
    <br> </br>

2. **Issues** 
    - [ ] 
    - [ ] 
 <br> </br>
3. **Team Milestones/Tasks** 
- _Reminders:_
    - [ ] 
    - [ ] 
 <br> </br>
- _Topics to understand and implement:_
    - [ ] 
    - [ ] 
    - [ ] 
 <br> </br>
- _Tasks_
    - Julian: 
        - [ ] 
        - [ ] 
 <br> </br>
    - Calvin: 
        - [ ] 
        - [ ] 
        <br> </br>
    - Levi: 
        - [ ] 
        - [ ] 

[Table of Contents](#table-of-contents)
<br>



</br>


<hr> 

### **SCRUM 2: 05/10/22**
> ##### _**Levi:** This first meeting summary will be a bit short... I'll take better notes for the future._
<br>

**Issues resolved:**
- [x] Connecting AWS to DBeaver
- [x] Git/GitHub sync

<br>

**Team Decisions:**
- [x] Using Hibernate 

<br>

**Scrum 2 Milestone/Tasks:**
- [ ] Reviewing Hibernate
- [ ] Completing assigned Model & Repository Layers 
- [ ] Starting on Services layer
- [ ] Unit Testing 
- [ ] Remember to review each others' code and push your work to your respective branch!

<br>

**Review**: The Service Layer calls what we specified in the Data Layer and adds business logic to it. This is where you would consider input validation, etc. 
- This layer will in turn be called on by the Controller layer. 

<br>



</br>


<hr>

### **SCRUM 3: 05/11/22**


1. Progress Check: <br>

    1. Where are we in  regard to Hibernate? 
    2. Where are win in out understanding of servlets and our controller layer? 
    
    Levi:
    - [x] Finished UserRoles (Model and Repository layers)
    - [x] Finished User table improvements 
        - messed up SQL code. Need to go back and fix. 

    Calvin: 
    - [x] Wrapped up and finished all SQL code for all tables 
        - made edits and pushed ERD to dev branch 
    - [x] Updated Git ignore file 
    - [x] Edited POM files to prep for testing
    - [x] Completed Reimbursement Table (Models, Respository, and Service Layer)
    - [x] General debugging 
    - [x] Updated logger 


    Julian: 
    - [x] Status table: models, repository, and services layer
    - [x] fixed issues with lightbulb for methods 

    
2. Issues: 
    - N/A
3. Agenda: 
    - [x] Daily_Scrum Document Preview 
    - [x] ERS_REIMBURSEMENT_STATUS TABLE 
        - _States_: Pending, Approved, Denied, Rejection (for correction) 
        - Only method we need in Repository layer: FIND --> findById
    - [x] Where are we in regard to Hibernate? 
        - need to review and understand more
4. Team Milestone/Tasks: 

    **Reminders:** 
    - [ ] Finish EC2 In-Class Challenge and send screen shots to Azhya 
    - [ ] _**Review commits on a timely basis**_ (Deadline: Before start of next meeting)


    **Topics to understand and implement:** 
    - [ ] Hibernate
    - [ ] Servlets 
    - [ ] Controllers 
        - generating the SERIAL ID on VSCODE
        - changing Tomcat installation directory via VS Code 
        - Will open it up in STS and transfer to VSCode 
    - [ ] Unit Testing

    Levi: 
    - [ ] Adjust SQL code according to updated tables
    - [ ] Update my service layer for my tables 
    - [x] Development + Create Branches when creating updates for team. / Give option to create branch when team member views Issue. 
    - [x] Create meeting agenda for next day-> adjust Progress Check with issues from previous day
    - [ ] (Optional): Create document for important team resouces 
    - [ ] Create a template for meeting notes

    Calvin: 
    - [ ] REIMBURSEMENT table
        - controller 
        - unit testing 
    - [ ] Figuring out how to use Controllers in VS Code
    

    Julian: 
    - [ ] Adjust ERS_REIMBURSEMENT_STATUS 
        - Repository DAO -> findById method ONLY 
        - Repository DAOImpl
        - Services

[Table of Contents](#table-of-contents)


<br>



</br>


<hr>

### **SCRUM 4: 05/12/22**

1. **Progress Check** 
    
    Calvin: 
    - [ ] REIMBURSEMENT table
        - controller 
        - unit testing 
    - [ ] Figuring out how to use Controllers in VS Code

    Julian: 
    - [ ] Adjust ERS_REIMBURSEMENT_STATUS 
        - Repository DAO -> findById method ONLY 
        - Repository DAOImpl
        - Services

    Levi: 
    - [ ] Adjust SQL code according to updated tables
    - [ ] Update my service layer for my tables 
    - [ ] Development + Create Branches when creating updates for team. 
    - [ ] Create meeting agenda for next day-> adjust Progress Check with issues from previous day
    - [ ] (Optional): Create document for important team resouces 
    
    
2. **Issues** 

3. **Team Milestones/Tasks** 
- _Reminders:_
    - [ ] 
    - [ ] 
- _Topics to understand and implement:_
    - [ ] 
    - [ ] 
    - [ ] 
- _Tasks_
    - Julian: 
        - [ ] 
        - [ ] 
    - Calvin: 
        - [ ] 
        - [ ] 
    - Levi: 
        - [ ] 
        - [ ] 





[Table of Contents](#table-of-contents)