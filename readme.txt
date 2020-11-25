Download the project
import into IDE as Maven project. 
Make sure you have java and mvn installed.
  export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_261.jdk/Contents/Home
  export PATH=/opt/apache-maven-3.6.3/bin:$PATH

common application.properties that can be configured 
https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html#security-properties


If want to deploy as a war on a different container - change the packaging to war in the pom.xml
If want to run as a jar  - just mvn clean install and run as a java -jar file thats created in the target directory


Tests:
 check the postman request ins src/main/resources/postman-requests
 for standalone. 
  first create the topics using these requests and 
  you can create the course for those topics .
  
    
  