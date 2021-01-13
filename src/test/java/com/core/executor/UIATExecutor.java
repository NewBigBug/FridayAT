package com.core.executor;


import org.testng.TestNG;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static com.core.utils.FigletHelper.figlet;

import static com.core.manager.ConfigFileManager.*;
import static com.core.manager.FileLocations.PARALLEL_XML_LOCATION;
import static java.lang.System.getProperty;

public class UIATExecutor {

    public boolean generateTestNGXmlAndTriggerRunner(List<String> test, String pack,int devicesCount, String exeType) throws Exception{
        boolean result;
        String suiteName = SUITE_NAME.get();
        String categoryName = CATEGORY.get();
        String runnerLevel = RUNNER_LEVEL.get();
        Set<Method> setOfMethods = getMethods(pack);

//    if (exeType.equalsIgnoreCase("distribute")){
//        if(runnerLevel != null && runnerLevel.equalsIgnoreCase("class")){
//            generateTestNGXmlForClassLevelDistributeTest(test,setOfMethods,suiteName,categoryName,devicesCount);
//        } else {
//            generateTestNGXmlForMethodLevelDistributeTest(test,setOfMethods,suiteName,categoryName,devicesCount);
//        }
//    } else {
//        generateTestNGXmlForTestLevelParallelTest(test,setOfMethods,suiteName,categoryName,devicesCount);
//    }

    result = runTestNGXmlForTest();
    figlet("Test Completed");
    return result;
    }

    //构建testng xml文件，Class 级别分发测试
    public XmlSuite generateTestNGXmlForClassLevelDistributeTest(List<String> tests,
                                                                 Map<String, List<Method>> methods,
                                                                 String suiteName, String categoryName,
                                                                 int deviceCount){
        XmlSuite suite = new XmlSuite();

        return suite;

    }

    //构建testng xml文件，Method 级别分发测试
    public XmlSuite generateTestNGXmlForMethodLevelDistributeTest(List<String> tests,
                                                                 Map<String, List<Method>> methods,
                                                                 String suiteName, String categoryName,
                                                                 int deviceCount){
        XmlSuite suite = new XmlSuite();

        return suite;

    }

    //构建testng xml文件，Test 级别并发测试
    public XmlSuite generateTestNGXmlForTestLevelParallelTest(List<String> tests,
                                                                  Map<String, List<Method>> methods,
                                                                  String suiteName, String categoryName,
                                                                  int deviceCount){
        XmlSuite suite = new XmlSuite();

        return suite;

    }

    //执行xml文件测试
    public boolean runTestNGXmlForTest(){
        TestNG testNG = new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(getProperty("") + PARALLEL_XML_LOCATION);
        testNG.setTestSuites(suites);
        testNG.run();
        return testNG.hasFailure();
    }

    public Set<Method> getMethods(String pack) throws Exception{
        return null;

    }

}



