package 数组相关;

/**
 * @author : Pandora
 * 2021/11/17-15:31
 */

public class HuiWenNum {
    public static Boolean isHuiwen( int[] nums ){
        /**
        * @Author : Pandora
        * @Date : 15:47 2021/11/17
        * @Description : 判断数组是否为会问数组
        * @Core : 双指针
        * @SolveThinking : 双指针
        **/
        int left = 0, right = nums.length - 1;
        while ( left < right ){
            if ( nums[left] != nums[right] )
                return false;
            left++;
            right--;
        }
        return true;
    }

    public static Boolean isHuiwenString( String s ){
        /**
         * @Author : Pandora
         * @Date : 15:47 2021/11/17
         * @Description : 判断数组是否为会问数组
         * @Core : 双指针
         * @SolveThinking : 双指针
         **/
        int left = 0, right = s.length() - 1;
        while ( left < right ){
            if ( s.charAt(left) != s.charAt(right) )
                return false;
            left++;
            right--;
        }
        return true;
    }


    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,5,3,2,1};
        int[] b = new int[]{1,2,2};
        System.out.println(isHuiwen(a));
        System.out.println(isHuiwen(b));

        String s = "1235321";
        String s1 = "122";
        System.out.println(isHuiwenString(s));
        System.out.println(isHuiwenString(s1));
    }
}
