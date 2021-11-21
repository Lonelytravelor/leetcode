package 字符串相关;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : Pandora
 * 2021/11/16-9:35
 */

public class StringContainer {
    public static void findShortestString(String s1, String s2){

    }

    public static Boolean isContain(String s1, String s2){
        ArrayList<Character> list = new ArrayList<>();
        for (int i = 0 ; i < s2.length(); i++){
            list.add(s2.charAt(i));
        }
        for (int i = 0 ; i < s1.length(); i++){
            if (list.contains(s1.charAt(i))){
                list.remove(s1.charAt(i));
            }
        }
        Boolean res = list.isEmpty() ? true : false;
        return res;
    }

    public static void main(String[] args) {
        String s1 = "abcdefg";
        String s2 = "ab";

        System.out.println(isContain(s1, s2));
    }
}
