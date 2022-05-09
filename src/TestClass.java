package src;

import java.lang.reflect.Method;

public class TestClass {
    @BeforeSuite(s = "Performing @BeforeSuite")
    public void beforeSuiteMethod (){
        System.out.println ("...");
    }

    @AfterSuite(s = "Performing @AfterSuite")
    public void afterSuiteMethod (){
        System.out.println ("...");
    }

    @Test(priority = 1)
    public void test1 (){
        System.out.println ("...");
    }

    @Test(priority = 2)
    public void test2 (){
        System.out.println ("...");
    }

    @Test(priority = 3)
    public void test3 (){
        System.out.println ("...");
    }
}
