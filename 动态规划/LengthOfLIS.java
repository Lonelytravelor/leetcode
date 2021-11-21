package 动态规划;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * @author : Pandora
 * 2021/11/15-17:34
 * 300. 最长递增子序列 midem
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 */

public class LengthOfLIS {
    public static int lengthOfLIS(int[] nums) {
        /**
        * @Author : Pandora
        * @Date : 18:09 2021/11/15
        * @Description : 找到其中最长严格递增子序列的长度。
        * @Core : 暴力搜索
        * @SolveThinking : 通过计算每一个节点的最长子序列，然后返回最大值
         * 在每次子循环中，该点的最长递增子序列的长度为 下一个比此节点大的节点的最长子序列 + 1
        **/
        int max = -1;
        for( int i = 0; i < nums.length; i++){
            max = findLength(nums,i) > max ? findLength(nums,i) : max;
        }
        return max;
    }

    public static int findLength(int[] nums, int k){
        if (k == nums.length - 1)
            return 1;
        int maxLength = 1;
        for( int i = k + 1; i < nums.length; i++){
            if( nums[i] > nums[k] ){
                maxLength = findLength(nums, i) + 1;
            }
        }
        return maxLength;
    }



//    public static int lengthOfLIS02(int[] nums) {
//
//    }

    public static void main(String[] args) {
        int[] num = new int[]{10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(num));
    }
}
