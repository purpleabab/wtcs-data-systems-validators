# WTCS Data Systems Validators

Our files that need validated are plain test, made up of lines of records.
Each record has several fields; there is no special delimitation and the fields
are defined only by the character positions on the line. We want to make sure
that fields in records are of the correct data type before we try to use them
in a more strongly typed context (e.g. a database system).

### Construction Plan: Build components ground-up and test:

* Validators
* Records which specify Fields and how they should use Validators
* Record Validation Engine which uses Validators on Records
* File submission/acquisition: basic (POST to the web service, read the data)
* File Validation Engine which creates Records from the file
  and hands them to the Record Validation Engine
* File submission: complete: return basic true/false File Validation Engine results
* _stretch 1:_ Expanded error results: failure record (line) numbers
* _stretch 2:_ Expanded error results: record-field level failure detail

#### Week 1 (Oct 19 - Oct 26)

* Class, Oct 19: Paula talks about it being the first week of projects. Yay.
* We'll build a validator for our data files at work!
* Paula approves the concept.

#### Week 2 (Oct 26 - Nov 2)

* Oct 27: Basic validators from regular expressions, set up as objects inheriting from
  a base which we'll instantiate one of and re-use, rather than making lots of objects
  every time check a bunch of fields on lines by using String.matches().
* Monday, Oct 31: At work. Pretty comprehensive tests for validators jointly built.
  Simple, non-generic S9Record created, set up with some hard-coded values, and
  test for validation created. First major work on the project, all together.
* Nov 1-2: Breaking the concept of "Record" up into a generic object that we could
  use for all kinds of line-based records.
* Class, Nov 2: Reviewed where we were going, and re-verified that things were okay.

#### Week 3 (Nov 2 - Nov 9)

* Nov 4-5: Research file acquisition from a JAX-RS-handled POST; implement getting POSTed
  file as _multipart/form-data_ in JAX-RS application using JBoss RESTeasy implementation.
* Nov 6: Nataliya delivers initial PowerPoint, fills in formal Problem on GitHub.
* Monday, Nov 7: At work.
* Nov 8: A bunch of documentation. Karen gets some tests and things
  working with extended file validation.
* Nov 11: JUnit tests

##### Week 4 (Nov 9 - Nov 16)

* Nov 14: deployment to Digital Ocean; creating user documentation; incorporating code review feedback;
  writing more tests to achieve higher coverage.
* Class, Nov 16: Presentations