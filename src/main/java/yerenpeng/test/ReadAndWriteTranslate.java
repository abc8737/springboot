package yerenpeng.test;

import java.io.*;

/**
 * 读取文件内容并翻译保存到新的文件
 *
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/12/1 23:03
 * @Version 1.0
 */
public class ReadAndWriteTranslate {

    private static final String FILE_PATH = "D:\\test.txt";

    private static StringBuffer buffer = new StringBuffer();

    public static void readFile() throws IOException {
        File file = new File(FILE_PATH);
        FileInputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(file);
            // 加上gbk编码才能够实现正常内容显示，如果不加gbk编码格式化则会出现乱码
            reader = new BufferedReader(new InputStreamReader(inputStream, "gbk"));
            String readLine;
            TestBaiduTranslate.init();
            int line = 0;
            while ((readLine = reader.readLine()) != null) {
                String dest = new String(readLine.getBytes());
                System.out.println("第" + (++line) + "行原文：" + dest);
                buffer.append(TestBaiduTranslate.transZh2En(dest));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            reader.close();
        }

    }

    public static void writeTranslationFile(byte[] bytes) throws IOException {
        File destFile = new File("D:\\translate.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(destFile);
            bos = new BufferedOutputStream(fos);
            bos.flush();
            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bos.close();
            fos.close();
            System.out.println("翻译结果已经成功写入" + destFile.getName());
        }
    }

    public static void main(String[] args) throws Exception {
        readFile();
        writeTranslationFile(buffer.toString().getBytes());
    }

}
