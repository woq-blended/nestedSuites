## Problem Context

We are migrating a project from sbt to mill and have come across a 
problem migrating our integration test suite which uses scalatest 
as its testing framework. 

Our integration test suite makes use of nested suites, which has been 
a successful pattern when we used maven or sbt in the past. 

The main suite creates a couple of docker containers and initializes 
connections to various services within those containers. Furthermore, 
the main spec executes some elaborate preconditions to make sure 
everuthing is wired up correctly before the actual can be run. 

The nested suites expect a context parameter in their constructor
carrying the connections amongst other things. The nested suites 
then perform the actual tests of business cases. 

After migrating to mill for our container assembly and integration test 
project we have noticed, that the test cases within the nested suites 
are not executed by mill. 

## Test Case

We have create this minimal example to demonstrate the behavior. 

### Noting the problem 

The problem can be seen by executing 

```
mill nested.test.test
```

The outcome is something like 
```
[57/57] nested.test.test 
NestedSuitesSpec:
A nested suite should
- execute a given test
ANestedSuite:
The nested suites should
```
The tes case within `ANestedSuite` is never executed. 

### Execution in sbt 

If you have sbt installed, you the tests can be executed with 

```
sbt test
```
The outcome is something like 
```
[info] Loading global plugins from /home/andreas/.sbt/1.0/plugins
[info] Loading project definition from /home/andreas/projects/blended/nestedSuites/project
[info] Loading settings for project nestedsuites from build.sbt ...
[info] Set current project to nestedsuites (in build file:/home/andreas/projects/blended/nestedSuites/)
[info] NestedSuitesSpec:
[info] A nested suite should
[info] - execute a given test
[info] ANestedSuite:
[info] The nested suites should
[info] - also be exectuted
[info] Run completed in 233 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 2, aborted 0
[info] Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
[info] All tests passed.
[success] Total time: 1 s, completed May 12, 2020 5:38:09 PM
```
The test within `ANestedSuite` is executed correctly. 

### Execution with scalatests stand alone Runner 

The tests can also be executed with 

```
mill nested.test.itest
```
Here the outcome is something like 

```
[52/52] nested.test.itest 
Discovery starting.
Discovery completed in 50 milliseconds.
Run starting. Expected test count is: 2
NestedSuitesSpec:
ANestedSuite:
The nested suites should
- also be executed
A nested suite should
- execute a given test
Run completed in 107 milliseconds.
Total number of tests run: 2
Suites: completed 3, aborted 0
Tests: succeeded 2, failed 0, canceled 0, ignored 0, pending 0
All tests passed.
```
The test within `ANestedSuite` is also executed. 