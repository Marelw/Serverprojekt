This project aims to manage students, specifically by register their names, courses and year group.
The client asks for information - the server delivers that information.


HOW TO:

prerequisites: dbderby, WildFly

dbderby:
create database:

in a terminal at \db-derby\bin, run the command, NetworkServerControl.bat -p 50000 start
in a terminal at \db-derby\bin, run the command, ij.bat

run the command, connect 'jdbc:derby://localhost:50000/StudentManagement; create=true' ;

create a table in the terminal:

CREATE table Student (
    id INT PRIMARY KEY,
    firstName VARCHAR(30),
    surname VARCHAR(30),
    course VARCHAR(30),
    yearGroup int
);

add students:

insert into Student values (idNumberHere, 'firstName', 'surname', 'course', yearGroupHere);



WildFly:

In the folder, \wildfly-23.0.0.Final\standalone\configuration, open standalone.xml.
paste the following in the datasources tag <datasources>paste here</datasources>:

<datasource jndi-name="java:/EmployeeDatabase" pool-name="EmployeeDatabase"
		enabled="true" use-java-context="true">
	<connection-url>jdbc:derby://localhost:50000/EmployeeManagement
		</connection-url>
	<driver>derbyclient.jar</driver>
	<security>
		<user-name>APP</user-name>
		<password>APP</password>
	</security>
</datasource>


Open a terminal. Navigate to the directory /wildfly/bin, run the command standalone.bat
Open a browser and run localhost:9990, log in


In the Deployments section, press the plus mark and choose upload deployment
press "choose a file or drag it here", navigate to your \dbderby\lib, choose the file derbyclient.jar, choose next and finish



Download the zip-file, extract it to your workspace
In build.xml, edit the path to your wildfly application, e.g.

<!-- select a line that points to the path of your server deployment folder

    WINDOWS VERSION:
    <property name="server-dist" value="C:\Progra~1\wildfly\wildfly-10.0.0.Final\standalone\deployments"/>

    MAC/LINUX VERSION:
    <property name="server-dist" value="/opt/wildfly/wildfly/wildfly-10.0.0.Final/standalone/deployments"/>
    -->

<property name="server-dist" value="absolute path to wildfly\standalone\deployments goes here"/>



right click the build.xml, run as, ant build.
If successful, a StudentManagement.war file has been created in the deployment section of WildFly.