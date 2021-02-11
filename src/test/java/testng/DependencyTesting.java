/*
    Dependency Testing

        So what exactly is dependency testing? Dependency testing is when two or more actions, two or more tasks,
        or two or more functions depend on the order of their methods. We must sign into an application before we can
        test sign out. The sign out test depends on the sign in being successful.

        In a scenario where Dependency Testing is not handled correctly, if the test on which other tests depend on fails,
        then all other tests will be also marked as failed. This is not a correct reflection of the actual test results,
        since the tests don't even get to run.

        In a scenario where Dependency Testing is handled correctly, if the test in which other tests depend on fails,
        then all other tests which had a dependency will be marked as "skipped" and not as failed. This will reflect the
        actual results more accurately since the tests did not get to run.

        TestNG provides these attributes to be used with Dependency Testing:
            - dependsOn
            - groups
            - dependsOnGroups

        Source: https://testautomationu.applitools.com/introduction-to-testng/chapter7.1.html

 */

package testng;
s
public class DependencyTesting {
}
