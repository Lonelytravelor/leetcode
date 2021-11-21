package 整数相关;

/**
 * @author : Pandora
 * 2021/11/15-10:40
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数 easy 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一
 * 个数组。
 */

public class NumBits {
    public static int[] countBits(int n) {
        /**
        * @Author : Pandora
        * @Date : 10:47 2021/11/15
        * @Description : 前 n 个数字二进制中 1 的个数
        * @Core : 位运算
        * @SolveThinking : 利用与1进行&运算即可知道最低位是否为1，然后将数字右移一位，连续判断
        **/
        int[] res = new int[n+1];
        res[0] = 0;
        for( int i = 1; i <=n ; i++){
            int sum = 0;
            for (int j = i; j > 0; j>>=1){
                if ((j & 1) == 1){
                    sum++;
                }
            }
            res[i] = sum;
        }
        return res;
    }
}
