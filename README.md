Mattermost Selenium 
==========================

TODO - how to use guide


Selenium IDE Setup:

`Options` > `Options ...`` > `Format`

Select `Java / JUnit 4 / WebDriver`

Set the following properties

Variable for Selenium instance:
```
driver
```

Package:
```java
com.mattermost.selenium.tests
```

Header:
```java
package ${packageName};

import com.mattermost.selenium.DriverBase;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

import java.util.regex.Pattern;

public class ${className}IT extends DriverBase {

    @Test
    public void ${methodName}() throws Exception {

```

Footer:
```
    }
}
```

Indent:
```
4 spaces
```