package yerenpeng.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.translate.demo.TransApi;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * 测试百度翻译API
 *
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/11/29 22:40
 * @Version 1.0
 */
public class TestBaiduTranslate {

    private static Logger logger = Logger.getLogger(TestBaiduTranslate.class);

    private static TransApi transApi;

    private static final String APP_ID = "20181129000241086";
    private static final String SECURITY_KEY = "ZUe5P4XKizaHCTz5YgKV";

    static void init() {
        BasicConfigurator.configure();
        transApi = new TransApi(APP_ID, SECURITY_KEY);
    }

    public static void main(String[] args) {
        BasicConfigurator.configure();
        init();
        String querySource = "我的名字叫叶仁鹏。";
        logger.warn("源文：" + querySource);
        transZh2En(querySource);
        transZh2Jp(querySource);
        transZh2Kor(querySource);
        transZh2Th(querySource);
    }

    // Chinese to English
    public static String transZh2En(String querySource) {
        String dest = transApi.getTransResult(querySource, "auto", "en");
        return resolveDestSource(dest, "en");
    }

    // Chinese to Japanese
    public static void transZh2Jp(String querySource) {
        String dest = transApi.getTransResult(querySource, "auto", "jp");
        resolveDestSource(dest, "jp");
    }

    // Chinese to Korean
    public static void transZh2Kor(String querySource) {
        String dest = transApi.getTransResult(querySource, "auto", "kor");
        resolveDestSource(dest, "kor");
    }

    // Chinese to Thailand
    public static void transZh2Th(String querySource) {
        String dest = transApi.getTransResult(querySource, "auto", "th");
        resolveDestSource(dest, "th");
    }

    /**
     * 解析翻译返回信息
     * JSON -> String
     *
     * @param dest 翻译返回信息
     */
    public static String resolveDestSource(String dest, String language) {
        JSONObject object = JSONObject.parseObject(dest);
        String result = object.getString("trans_result");
        JSONArray array = JSONArray.parseArray(result);
        StringBuilder destBuilder = new StringBuilder();
        for (Object o : array) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            destBuilder.append(jsonObject.getString("dst")).append("\n");
//            logger.warn("源文：" + jsonObject.getString("src"));
//            logger.warn(getDestType(language) + "译文：" + jsonObject.getString("dst"));
//            System.out.println(getDestType(language) + "译文：" + jsonObject.getString("dst"));
        }
        return destBuilder.toString();
    }

    // 目的译文语言
    public static String getDestType(String language) {
        String destType;
        switch (language) {
            case "en":
                destType = "英语";
                break;
            case "jp":
                destType = "日语";
                break;
            case "kor":
                destType = "韩语";
                break;
            case "th":
                destType = "泰语";
                break;
            default:
                destType = "";
                break;
        }
        return destType;
    }

}
