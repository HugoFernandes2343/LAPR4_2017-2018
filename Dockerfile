FROM tomcat:8.0.20-jre8

COPY ./nsheets/target/nsheets-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/nsheets.war
