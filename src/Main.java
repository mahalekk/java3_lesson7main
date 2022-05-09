package src;


import java.lang.reflect.Method;
import java.util.*;



public class Main {

    public static void main(String[] args) {
        Class testClass = TestClass.class;
        start (testClass);
    }

    private static void start(Class testClass) {
        try {
            Method TestClassBeforeSuite = testClass.getMethod ("beforeSuiteMethod", null);
            Method TestClassAfterSuite = testClass.getMethod ("afterSuiteMethod", null);
            Method mainTest1 = testClass.getMethod ("test1", null);
            Method mainTest2 = testClass.getMethod ("test2", null);
            Method mainTest3 = testClass.getMethod ("test3", null);
            BeforeSuite beforeSuite = TestClassBeforeSuite.getAnnotation (BeforeSuite.class);
            AfterSuite afterSuite = TestClassAfterSuite.getAnnotation (AfterSuite.class);
            List<Test> testsArray = new ArrayList<> ();
            Test test1 = mainTest1.getAnnotation (Test.class);
            Test test2 = mainTest2.getAnnotation (Test.class);
            Test test3 = mainTest3.getAnnotation (Test.class);
            testsArray.add (test1);
            testsArray.add (test2);
            testsArray.add (test3);
            testsArray.sort(Comparator.comparing (Test::priority));
            if (beforeSuite != null) {
                System.out.println (beforeSuite.s ());
            } else {
                throw new RuntimeException ("@BeforeSuite method is not exist");
            }
            for (Test test: testsArray) {
                System.out.println ("Running test with priority " + test.priority ());
            }
            if (afterSuite != null) {
                System.out.println (afterSuite.s ());
                } else {
                    throw new RuntimeException ("@AfterSuite method is not exist");
                }
            } catch (NoSuchMethodException e) {
            e.printStackTrace ();
        }
        }
    }

