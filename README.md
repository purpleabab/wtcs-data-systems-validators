# WTCS Data System Validators
### Problem Statement
 Wisconsin Technical College System Office is the administrative and coordinating state agency that implements statewide policies and standards established by the WTCS Board and administers state funding provided for technical college programs and services.It monitors and reports on federal requirements related to technical college operations and administers funding received under the federal Carl Perkins and Adult Education and Family Literacy Acts.
 Currently there are 16 technical colleges that report data to WTCS via textfile upload on Portal. Unfortunately there had been occurences when file would fail to upload due to invalid data type. In that case colleges would have to contact  WTCS Office to find out what was the issue and how to fix it.
 This application will provide a solution to this problem. It will validate all data types during upload and will let the file go through or will stop it from downoading with the statement of location and type of an error. The validator will check for string, numeric and alphanumeric types.

### Project Technologies/Techniques
*Web servise

*Logging

*Unit Testing

    *JUnit tests to achieve 80% code coverage
