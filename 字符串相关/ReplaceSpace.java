package 字符串相关;

import java.util.ArrayList;

/**
 * @author : Pandora
 * 2021/11/24-21:56
 * 剑指 Offer 05. 替换空格 easy 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */

public class ReplaceSpace {
    public static String replaceSpace(String s) {
        /**
        * @Author : Pandora
        * @Date : 21:57 2021/11/24
        * @Description : 替换空格
        * @Core : 遍历字符串
        * @SolveThinking : 通过charAt获取字符串
        **/
        char[] array = new char[s.length() * 3];
        int size = 0;
        for ( int i = 0; i < s.length(); i++ ){
            if ( s.charAt(i) == ' ' ){
                array[size++] = '%';
                array[size++] = '0';
                array[size++] = '2';
            } else {
                array[size++] = s.charAt(i);
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }


    public static void main(String[] args) {
        String s = "fjkdsh dfskj fhsdj  fdhu      ";
        System.out.println(replaceSpace(s));
    }
}
