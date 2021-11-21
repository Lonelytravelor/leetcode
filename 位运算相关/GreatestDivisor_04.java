package 位运算相关;

/**
 * @author : Pandora
 * 2021/11/9-11:22
 */

public class GreatestDivisor_04 {
    public static int getNum01(int a, int b){
        /**
        * @Author : Pandora
        * @Date : 12:11 2021/11/14
        * @Description : 最大公约数
        * @Core : 辗转相除法
        * @SolveThinking : 有两个数a，b（a>b）,则a和b的最大公约数等于a%b的值c与b的最大公约数。
        **/
        while( a % b != 0){
            if ( a < b ){
                int temp = a;
                a = b;
                b = temp;
            }
            a = a % b;
        }
        return b;
    }
    public static int getNum02(int a, int b){
        /**
        * @Author : Pandora
        * @Date : 12:11 2021/11/14
        * @Description : 最大公约数
        * @Core : 更项相减法
        * @SolveThinking : 有两个数a，b（a>b）,则a和b的最大公约数等于a-b的值c与b的最大公约数。
        **/
        while( a != b){
            if ( a < b ){
                int temp = a;
                a = b;
                b = temp;
            }
            a = a - b;
        }
        return b;
    }
//    更项相减法与辗转相除法相结合：并使用位运算来优化%的过程
    public static int getNum03(int a, int b){
        /**
        * @Author : Pandora
        * @Date : 12:16 2021/11/14
        * @Description : 最大公约数
        * @Core : 更项相减法-辗转相除法优化
        * @SolveThinking : 当两数中可以整除2，那么久乘除2，否则就更相相减
        **/
        while( a != b) {
            if( (a&1)==0 && (b&1)==0 ){
                a = a >> 1;
                b = b >> 1;
            }else if( (a&1)==0 ){
                a = a >> 1;
            }else if( (b&1)==0 ){
                b = b >> 1;
            }else {
                if ( a < b ){
                    int temp = a;
                    a = b;
                    b = temp;
                }
                a = a - b;
            }

        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(getNum01(9,12));
        System.out.println(getNum02(2,24));
        System.out.println(getNum02(30,61));
    }
}
