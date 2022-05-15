# CreditCardSystem
Spring boot and React application for Credit card System. It should allow you to add new credit card accounts and view them as a list.
The Project contains both Spring boot RESTFull API as backend service as well as the React for Frontend. It have integrated with in memory H2 DB.

Prerequisite
Maven
JDK 1.8+
React 17.0.1



**Build and Run Backend application**
      _GOTO >_ **~/absolute-path-to-directory/CreditCardSystem**  
      and try below command in terminal
      
      > **```mvn spring-boot:run```** it will run application as spring boot application on port 8082

      or
      > **```mvn clean install```** it will build application and create **jar** file under target directory 

      Run jar file from below path with given command
      > **```java -jar ~/path-to-CreditCardSystem/target/CreditCardSystem-0.0.1-SNAPSHOT.jar```**

**Build and Run Frontend application**
      _GOTO >_ **~/absolute-path-to-directory/CreditCardSystem/CCAPP_FRONTEND
      and enter below command in terminal
      > **```npm install```** it will install the node modules, once it completed successfully then run following command to start the application.
      
      > **```npm start```**  it will start the frontend application on port 3000.
