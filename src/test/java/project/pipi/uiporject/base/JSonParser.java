package project.pipi.uiporject.base;



import com.alibaba.fastjson.JSONObject;

import java.io.FileReader;

/**
 * @author Charles
 * @className JSonParser
 * @description TODO
 * @date 2020/10/22 21:28
 */
public class JSonParser {
    public static JSONObject getUserData(int threadID) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(System.getProperty("user.dir") + "/src/test/java/com/pipi/" +
                    "credentials.json"));
            JSONObject jsonObject = (JSONObject) obj;
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
