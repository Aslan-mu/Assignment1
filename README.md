# Mobile Assignment 1
# Project Detail
In this project, we choose to create a mobile app to present the team members. The team member database is a MySql RDS hosted in AWS. And we use JDBC.jar to connect android app with MySQL server.


We spend some time figuring out the proper Java version related to android compiler version that we installed. Android studio supports all Java7 features and parts of Java8 features but the latest Jconnector is a part of Java8.

After some research, we realized that direct connection to database is not safe and time consuming. Will figure out a better solution in the future.

# Run
Run DBHelper.java in the Mobile_assignment_1/app/src/main/java/com/example/baimu/assignment1/ DBHelper.java.(Not run the app) Then you can see all members in the database: That means the connection works well for java environment. 
