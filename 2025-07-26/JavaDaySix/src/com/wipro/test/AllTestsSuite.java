package com.wipro.test;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages({
    "com.wipro.test",
    "com.wipro.util"
})
public class AllTestsSuite {
    // No implementation needed. This class just runs all test classes in the selected packages.
}

public class AllTestsSuite {

}
