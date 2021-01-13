package com.core.executor;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class UIATRunner {
    public static final String USER_DIR = "user.dir";



    public boolean runner(String pack, List<String> tests) throws Exception{
        return automationRunner(pack, tests);
    }

    public boolean runner(String pack) throws Exception{
        return automationRunner(pack, new ArrayList<>());
    }

    /***
     *  测试执行器
     * @param pack
     * @param tests
     * @return
     * @throws Exception
     * 1.创建临时文件夹 appiumlog、snapshot、adblog
     * 2.调用执行器
     */
    private boolean automationRunner(String pack, List<String> tests) throws Exception{

        createAppiumLogsFolder();
        createsnsSnapshotFolder();
        return true;


    }

    private void createsnsSnapshotFolder() {
    }

    private void createAppiumLogsFolder() {

    }
}
