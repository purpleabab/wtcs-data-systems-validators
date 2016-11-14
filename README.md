# WTCS Data System Validators
### Problem Statement
 Wisconsin Technical College System Office is the administrative and coordinating state agency that implements statewide policies and standards established by the WTCS Board and administers state funding provided for technical college programs and services.It monitors and reports on federal requirements related to technical college operations and administers funding received under the federal Carl Perkins and Adult Education and Family Literacy Acts.
 Currently there are 16 technical colleges that report data to WTCS via text file upload on Portal. Unfortunately there have been occurrences when the file would fail to upload due to invalid data type. In that case colleges would have to contact  WTCS Office to find out what was the issue and how to fix it.
 This application will provide a solution to this problem. It will validate all data types during the file upload. If the file fails to upload,  the users will receive the statement with the information about the error type and its position on the record, so they will be able to fix the problem themselves. The validator will check for string, numeric and alphanumeric types form S9 records in Client System.

### Project Technologies/Techniques
*Web service

    *Data Validator
*Logging

    * Log4j
*Unit Testing

    *JUnit tests to achieve 90% code coverage of classes and 70% code coverage of methods and lines
