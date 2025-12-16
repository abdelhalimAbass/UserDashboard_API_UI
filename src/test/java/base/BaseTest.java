package base;

import data.TestData;
import data.TestDataFactory;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite
    public void generateTestData() {

        TestData.mobile = TestDataFactory.randomMobile();
       // TestData.email  = TestDataFactory.randomEmail();
        TestData.national_ID=TestDataFactory.random_national_ID();

        System.out.println("Generated Mobile: " + TestData.mobile);
        //System.out.println("Generated Email : " + TestData.email);
    }
}
