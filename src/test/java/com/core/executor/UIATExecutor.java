package com.core.executor;

import com.core.manager.ConfigFileManager;
import com.core.manager.FileLocations;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.testng.TestNG;
import org.testng.annotations.Test;
import org.testng.collections.Lists;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import static com.core.utils.FigletHelper.figlet;

import static com.core.manager.ConfigFileManager.*;
import static com.core.manager.FileLocations.*;
import static java.lang.System.getProperty;
import static java.util.Collections.addAll;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;

public class UIATExecutor {
    private final List<String> items = new ArrayList<String>();
    private final List<String> listeners = new ArrayList<>();
    private final List<String> groupsInclude = new ArrayList<String>();
    private final List<String> groupsExclude = new ArrayList<String>();

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
    figlet("TEST FINISH");
    return result;
    }



    //构建testng xml文件，Class 级别分发测试
    public XmlSuite generateTestNGXmlForClassLevelDistributeTest(List<String> tests,
                                                                 Map<String, List<Method>> methods,
                                                                 String suiteName, String categoryName,
                                                                 int deviceCount){
        listeners.add("");//添加testng listener，主要负责appium相关服务和操作内容
        listeners.add("");//添加testng listener，类似于watcher的作用，主要负责失败用例重试
        include(listeners,LISTENERS);//添加自定义监听，例如测试结果上报
        include(groupsInclude, INCLUDE_GROUPS);
        include(groupsExclude,EXCLUDE_GROUPS);
        XmlSuite suite = new XmlSuite();
        suite.setName(suiteName);
        suite.setThreadCount(deviceCount);
        suite.setParallel(XmlSuite.ParallelMode.CLASSES);
        suite.setVerbose(3);
        suite.setListeners(listeners);
        XmlTest test = new XmlTest(suite);
        test.setName(categoryName);
        test.addParameter("device", "");
        test.setIncludedGroups(groupsExclude);
        test.setExcludedGroups(groupsExclude);
        List<XmlClass> xmlClasses = wirteXmlClass(tests, methods);
        test.setXmlClasses(xmlClasses);
        writeTestNGXmlFile(suite);
        return suite;
    }

    //构建testng xml文件，Method 级别分发测试
    public XmlSuite generateTestNGXmlForMethodLevelDistributeTest(List<String> tests,
                                                                 Map<String, List<Method>> methods,
                                                                 String suiteName, String categoryName,
                                                                 int deviceCount){
        listeners.add("");//添加testng listener，主要负责appium相关服务和操作内容
        listeners.add("");//添加testng listener，类似于watcher的作用，主要负责失败用例重试
        include(listeners,LISTENERS);//添加自定义监听，例如测试结果上报
        include(groupsInclude, INCLUDE_GROUPS);
        include(groupsExclude,EXCLUDE_GROUPS);
        XmlSuite suite = new XmlSuite();
        suite.setName(suiteName);
        suite.setThreadCount(deviceCount);
        suite.setParallel(XmlSuite.ParallelMode.METHODS);
        suite.setVerbose(3);
        suite.setListeners(listeners);
        CreateGroups createGroups = new CreateGroups(tests, methods, categoryName, suite);
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


    //根据传入的pack目录获取带有@Test注解的class
    private  Set<Method> getMethods(String pack) throws MalformedURLException {
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

    //拼接获取方法全路径，返回方法list
    public  Map<String, List<Method>> getTestMethods(Set<Method> methods){
        Map<String, List<Method>> listOfMethods = new HashMap<>();
        methods.forEach(method -> {
            List<Method> methodList = listOfMethods.computeIfAbsent(method.getDeclaringClass().getPackage().getName() + "." + method.getDeclaringClass().getSimpleName(), k -> new ArrayList<>());
            methodList.add(method);
        });
        return listOfMethods;
    }

    //组装拼接两个list，config配置中为,分隔的字符串，需要split转换list
    private void include(List<String> groups, ConfigFileManager config){
        String listItems = config.get();
        if(isNotEmpty(listItems)){
            addAll(groups,listItems.split("\\s*,\\s*"));
        }
    }


    //构造testng class内容
    private List<XmlClass> wirteXmlClass(List<String> tests, Map<String, List<Method>> methods) {
        List<XmlClass> xmlClasses = new ArrayList<>();
        for (String className : methods.keySet()){
            XmlClass xmlClass = new XmlClass();
            xmlClass.setName(className);
            if (className.contains("Test")){
                if (tests.size() == 0) {
                    xmlClasses.add(xmlClass);
                } else {
                    for (String s : tests){
                        for (String item : items) {
                            String testName = item.concat("." + s);
                            if (testName.equals(className)) {
                                xmlClasses.add(xmlClass);
                            }
                        }
                    }
                }
            }
        }
        return xmlClasses;
    }

    //写入生产testng xml 文件
    private void writeTestNGXmlFile(XmlSuite suite) {
        try (FileWriter writer = new FileWriter(new File(getProperty("user.dir") + PARALLEL_XML_LOCATION.getFileLocation()))){
            writer.write(suite.toXml());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //构造生成group
    private class CreateGroups {
        private List<String> tests;
        private Map<String, List<Method>> methods;
        private String categoryName;
        private XmlSuite suite;
        private List<XmlClass> xmlClasses;
        private XmlTest test;
        private List<XmlClass> writeXml;

        public CreateGroups(List<String> tests,
                            Map<String, List<Method>> methods,
                            String categoryName, XmlSuite suite) {
            this.tests = tests;
            this.methods = methods;
            this.categoryName = categoryName;
            this.suite = suite;
        }
        public List<XmlClass> getXmlClasses() { return xmlClasses; }
        public XmlTest getTest() { return test; }
        public List<XmlClass> getWriteXml() {return writeXml;}

        public CreateGroups invoke() {
            xmlClasses = wirteXmlClass(tests, methods);
            test = new XmlTest(suite);
            test.setName(categoryName);
            test.addParameter("device", "");
            include(groupsExclude, EXCLUDE_GROUPS);
            test.setIncludedGroups(groupsExclude);
            test.setExcludedGroups(groupsExclude);
            writeXml = new ArrayList<>();
            return this;
        }


    }




}



