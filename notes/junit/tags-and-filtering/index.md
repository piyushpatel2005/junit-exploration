# Tags and Filtering Tests

JUnit 5 provides a way to filter tests based on tags. This is useful when you want to run only a subset of tests 
based on certain criteria. For example, you may want to run only the fast tests or only the slow tests. You can 
achieve this by tagging your tests and then filtering them based on the tags. Alternatively, you may want to run 
only web tests or database tests. You can tag your tests accordingly and then filter them based on these tags.

In Junit, you can tag your tests using the `@Tag` annotation. This annotation can be applied at the class level or 
at method level. You can also use multiple tags for a single test.

Here's an example of tagging tests at the method level:

```java
package com.github.piyushpatel2005.tagging;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaggingTest {
    @Test
    @Tag("fast")
    @Tag("web")
    void webTest1() {
        assertTrue(true);
    }

    @Test
    @Tag("fast")
    @Tag("web")
    void webTest2() {

    }

    @Test
    @Tag("api")
    void apiTest1() {

    }

    @Tag("slow")
    @Test
    void slowTest() throws InterruptedException {
        Thread.sleep(5);
    }
}
```

You can see that we can define multiple tags for a single test method depending on how you want to filter  your 
tests. Now, when you run you tests using maven or gradle, you can specify the tags you want to include or exclude.

## Using Maven

With Maven, you can use `maven-surefire-plugin` to filter tests based on tags. You can specify the tags you want to 
include using `groups` parameter.

```shell
<plugins>
  <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.1.2</version>
    <configuration>
      <groups>fast</groups>
    </configuration>
  </plugin>
</plugins>
```

In above configuration, `mvn clean test` will run only the tests that are tagged with `fast`. You can also use 
multiple tags separated by comma.

### Excluding Tags

You can use below configuration to exclude certain tests.

```xml
  <configuration>
    <excludedGroups>slow,api</excludedGroups>
  </configuration>
```

## Using Gradle

With Gradle, you can use `test` task to filter tests based on tags. You can specify the tags you want to include.

```groovy
test {
    useJUnitPlatform {
        includeTags 'fast'
    }
}
```

### Excluding Tags

To exclude certain tags, you can use `excludeTags` method.

```groovy
test {
    useJUnitPlatform {
        excludeTags 'slow', 'api'
    }
}
```