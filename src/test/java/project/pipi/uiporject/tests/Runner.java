package project.pipi.uiporject.tests;
/**
 * @author Charles
 * @className Runner
 * @description 测试入口类
 * @date 2020/10/21 21:34
 */


import com.core.appium.manager.ATDRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class Runner {


    @Test public void testRunner() throws Exception {
        ATDRunner concurrentExecution = new ATDRunner();
        List<String> test = new ArrayList<String>();
//        test.add("EnterInAppTest");
        test.add("LoginTest");
        boolean runner = concurrentExecution.runner("com.pipi.tests", test);
        System.out.println(runner);
        System.out.println("---------------------------------------");
        System.out.println("测试执行完成" + runner);
        System.out.println("---------------------------------------");
        //如果有用例失败，runner返回的是true
        Assert.assertFalse(runner);
    }

}
