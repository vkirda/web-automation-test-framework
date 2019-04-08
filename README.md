# web-automation-test-framework
Selenium+Testng+Java test framework with demo test

### Prerequisites.

In order test to work - need to instal JAVA and Maven.<br/>
Verify is Java instaled: at windows CMD type *java -version*;<br/>
Verify is Maven instaled: type *mvn -v*.

### How to run it successfully.

#### Step 1.
Clone repository.

#### Step 2.
Open *DemoTestng.xml* file and change line that looks like this: `<parameter name="downloadDirLocation" value="There should go your download location/directory" />`.<br/>
If you don't change - test still would run, but eventually will break on assertion.

#### Step 3.
Open CMD and change directory to where *DemoTestng.xml* file is located.<br/>
In my case *cd C:\Users\Vilmis\Desktop\Nauja JAVA\web-automation-test-framework*.<br/>
Then type *mvn clean test -Dsurefire.suiteXmlFiles=DemoTestng.xml* and test should run.
