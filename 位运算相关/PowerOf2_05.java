package 位运算相关;

/**
 * @author : Pandora
 * 2021/11/9-12:06
 */

public class PowerOf2_05 {
    public static boolean isPowerOf2(int num){
        /**
        * @Author : Pandora
        * @Date : 12:13 2021/11/14
        * @Description : 判断是否为2的整数幂
        * @Core : 位运算
        * @SolveThinking : 假设给定的数字是2的整数幂，则二进制位一定为100。。，则num与num-1&运算一定等于零
        **/
        return (num&(num-1)) == 0;
    }
}
