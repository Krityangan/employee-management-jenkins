FROM openjdk:8
EXPOSE 8080
ADD target/Employeeresource-management-Employee1.0.0.jar Employeeresource-management-Employee1.0.0.jar
ENTRYPOINT ["java","-jar","/Employeeresource-management-Employee1.0.0.jar"]