package com.core.executor;

import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.xml.XmlSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static com.core.utils.FigletHelper.figlet;

import static com.core.manager.ConfigFileManager.*;
import static com.core.manager.FileLocations.*;
import static java.lang.System.getProperty;
import static java.util.Collections.addAll;

public class UIATExecutor {
    private final List<String> items = new ArrayList<String>();

    public boolean generateTestNGXmlAndTriggerRunner(List<String> test, String pack,int devicesCount, String exeType) throws Exception{
        boolean result;
        String suiteName = SUITE_NAME.get();
        String categoryName = CATEGORY.get();
        String runnerLevel = RUNNER_LEVEL.get();
        Set<Method> setOfMethods = getMethods(pack);

    if (exeType.equalsIgnoreCase("distribute")){
        if(runnerLevel != null && runnerLevel.equalsIgnoreCase("class")){
            generateTestNGXmlForClassLevelDistributeTest(test,getTestMethods(setOfMethods),suiteName,categoryName,devicesCount);
        } else {
            generateTestNGXmlForMethodLevelDistributeTest(test,getTestMethods(setOfMethods),suiteName,categoryName,devicesCount);
        }
    } else {
        generateTestNGXmlForTestLevelParallelTest(test,getTestMethods(setOfMethods),suiteName,categoryName,devicesCount);
    }

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
        suites.add(getProperty("") + PARALLEL_XML_LOCATION.getFileLocation());
        testNG.setTestSuites(suites);
        testNG.run();
        return testNG.hasFailure();
    }

    //根据传入的pack目录获取带有@Test注解的class文件
    private Set<Method> getMethods(String pack) throws MalformedURLException {
        URL newUrl;
        List<URL> newUrls = new ArrayList<>();
        addAll(items, pack.split("\\s*,\\s*"));
        int a = 0;
        Collection<URL> urls = ClasspathHelper.forPackage(items.get(a));
        Iterator<URL> iter = urls.iterator();

        URL url = null;

        while (iter.hasNext()){
            url = iter.next();
            if (url.toString().contains("test-classes")) {
                break;
            }
        }
        for (String item: items){
            newUrl = new URL(url.toString() + item.replaceAll("\\.","/"));
            newUrls.add(newUrl);
            a++;
        }
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(newUrls).setScanners(new MethodAnnotationsScanner()));
        return reflections.getMethodsAnnotatedWith(Test.class);
    }


    public Map<String, List<Method>> getTestMethods(Set<Method> methods){
        Map<String, List<Method>> listOfMethods = new HashMap<>();
        methods.forEach(method -> {
            List<Method> methodList = listOfMethods.computeIfAbsent(method.getDeclaringClass().getPackage().getName() + "." + method.getDeclaringClass().getSimpleName(), k -> new ArrayList<>());
            methodList.add(method);
        });
        return listOfMethods;

    }
}



