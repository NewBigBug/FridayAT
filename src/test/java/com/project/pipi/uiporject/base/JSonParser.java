package com.project.pipi.uiporject.base;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author Charles
 * @className JSonParser
 * @description TODO
 * @date 2020/10/22 21:28
 */
public class JSonParser {
    public static JSONObject getUserData(int threadID) {
        try {
            InputStream inputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/project/pipi/uiporject/data/resource/" + "credentials.json");
            JSONObject jsonObject = JSON.parseObject(IOUtils.toString(inputStream,"utf8"));
            JSONArray msg = (JSONArray) jsonObject.get("credentials");
            JSONObject a = (JSONObject) msg.get(threadID);
            System.out.println(msg.get(threadID));
            return a;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
