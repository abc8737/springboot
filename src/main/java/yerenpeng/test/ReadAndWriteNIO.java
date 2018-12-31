package yerenpeng.test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * NIO读写
 *
 * @Author: YeRenpeng
 * @e-mail: abc8737@163.com
 * @github: https://github.com/Liu-xingyu
 * @Date: 2018/12/2 20:21
 * @Version 1.0
 */
public class ReadAndWriteNIO {

    private static final String READ_FILE_PATH = "D:\\test.txt";
    private static final String WRITE_FILE_PATH = "D:\\nio.txt";
    private static StringBuffer fileContent = new StringBuffer();

    // NIO读文件
    public static void readFileNIO() throws IOException {
        File file = new File(READ_FILE_PATH);
        FileInputStream fis = null;
        FileChannel channel = null;
        try {
            fis = new FileInputStream(file);
            channel = fis.getChannel();
            ByteBuffer dst = ByteBuffer.allocate(1 << 10);
            int position = channel.read(dst);
            while (position != -1) {
                //切换状态，之前是读文件，切换后是写文件
                dst.flip();
                fileContent.append(Charset.forName("gbk").decode(dst).toString());
                // 读取在缓存的字节流设置为"GBK"编码格式才不会输出乱码
                System.out.println(fileContent.toString());
                // 清空缓存，并且需要重新确定新的position读取位置
                // 如果不加入下面两句则会出现无限制的读取相同内容
                dst.clear();            // 没有则会出现无限循环读取文件内容
                position = channel.read(dst);   // 没有则会出现读取内容为空
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            channel.close();
            fis.close();
        }
    }

    // NIO写文件
    public static void writeFileNIO() throws IOException {
        File file = new File(WRITE_FILE_PATH);
        FileOutputStream fos = null;
        FileChannel channel = null;
//        System.out.println(TestBaiduTranslate.transZh2En(fileContent.toString()));
        try {
            fos = new FileOutputStream(file);
            channel = fos.getChannel();
            ByteBuffer src = Charset.forName("gbk").encode(TestBaiduTranslate.transZh2En(fileContent.toString()));
            int position = channel.write(src);
            // 这里需要判断文件是否全部写入，当前写入文件位置不等于文件总长度则继续写入，很重要
            while (position != src.position()) {
                System.out.println("位置position：" + position);
                // 写文件不需要下面注释的两句
//                src.flip();
//                src.clear();
                position = channel.write(src);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            channel.close();
            fos.close();
            System.out.println("翻译文件以NIO形式成功写入" + WRITE_FILE_PATH + "文件");
        }

    }

    public static void main(String[] args) {
        TestBaiduTranslate.init();
        try {
            readFileNIO();
            writeFileNIO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
