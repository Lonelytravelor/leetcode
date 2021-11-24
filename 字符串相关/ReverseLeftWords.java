package 字符串相关;

/**
 * @author : Pandora
 * 2021/11/24-22:11
 * 剑指 Offer 58 - II. 左旋转字符串 easy
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */

public class ReverseLeftWords {
    public static String reverseLeftWords01(String s, int n) {
        /**
        * @Author : Pandora
        * @Date : 22:55 2021/11/24
        * @Description : 左旋转字符串
        * @Core : 截取字符串函数
        * @SolveThinking : subString( a,b ) 截取自a开始到b为止，包括a但不包括b。
        **/
        return s.substring(n, s.length()) + s.substring(0, n);
    }



    public static void main(String[] args) {
        String s = "abcdefghijk";
        System.out.println(reverseLeftWords01(s,2));
    }
}
