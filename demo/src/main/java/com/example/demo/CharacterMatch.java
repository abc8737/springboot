import java.util.*;

/**
 * 匹配字符串(括号)
 * <p>
 * 匹配各种括号：
 * []       yes
 * []{}     yes
 * [[[()}   no
 * 如果是yes表示可以括号正反匹配，输出结果为0
 * 如果是no表示不能正确匹配，需要填充N个括号相匹配
 *
 * @AUTHOR Yrp
 * @CREATE 2018-09-17
 * 08:37
 **/
public class CharacterMatch {

    private static Scanner scanner = new Scanner(System.in);

    private static Map<Character, Character> csMap;

    public static void main(String[] args) {
        int lines = getLines();

        if (lines > 10) {
            System.err.println("行数不能超过10");
            return;
        }

        // 分别得到每一行的字符
        initMap();

        String s = getInputStr();
        for (int line = 0; line < lines; ++line) {
            if (matchCharacters(s)) {
                System.out.println(s + "可以成功匹配");
            } else {
                System.err.println(s + "无法成功匹配");
            }
        }
    }

    // 获取行数
    public static int getLines() {
        System.out.println("输入不大于10的行数：");
        return scanner.nextInt();
    }

    // 获取每一行的字符串（括号组成的字符串）
    public static String getInputStr() {
        return scanner.next();
    }

    public static void initMap() {
        csMap = new HashMap<>();
        csMap.clear();
        csMap.put(']', '[');
        csMap.put('}', '{');
        csMap.put(')', '(');
    }

    public static boolean matchCharacters(String s) {
        boolean isMatch = false;
        Stack<Character> cs = new Stack<>();
//        Queue<Character> cqs = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (int index = 0; index < chars.length; ++index) {
            // 如果匹配的是']' '}' ')'直接返回
            if (csMap.keySet().contains(chars[0])) {
                return false;
            }
            // 匹配的是'[' '{' '('才可以继续
            if (csMap.containsValue(chars[index])) {
                cs.push(chars[index]);
                isMatch = false;
            } else if (csMap.containsKey(chars[index])) {
                if (cs.size() > 0 && cs.peek() == csMap.get(chars[index])) {
                    isMatch = true;
                    cs.pop();
                } else {
                    isMatch = false;
                }
            }
        }
        return isMatch;
    }

}
