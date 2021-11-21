package 整数相关;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : Pandora
 * 2021/11/15-12:21
 *剑指 Offer II 006. 排序数组中两个数字之和  easy
 * 给定一个已按照 升序排列 的整数数组numbers ，请你从数组中找出两个数满足相加之和等于目标数target 。
 *
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 0开始计数 ，所以答案数组应当满足
 * 0<= answer[0] < answer[1] <numbers.length。
 *
 * 假设数组中存在且只存在一对符合条件的数字，同时一个数字不能使用两次。
 */

public class NumSum {

    public int[] findTwoSum(int[] numbers, int target) {
        /**
        * @Author : Pandora
        * @Date : 12:22 2021/11/15
        * @Description : 从数组中找出两个数满足相加之和等于目标数target
        * @Core : 双指针
        * @SolveThinking : 从数组两次进行循环，如果大于目标值则right--，反之left++
        **/
        int[] res = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        while (left < right){
            if( numbers[left] + numbers[right] == target ){
                res[0] = left;
                res[1] = right;
                return res;
            }
            int i = numbers[left] + numbers[right] > target ? right-- : left++;
        }
        return null;
    }

    public List<List<Integer>> findThreeSum(int[] numbers, int target) {
        /**
         * @Author : Pandora
         * @Date : 12:22 2021/11/15
         * @Description : 从数组中找出两个数满足相加之和等于目标数target
         * @Core : 双指针
         * @SolveThinking : 从数组两次进行循环，如果大于目标值则right--，反之left++
         **/
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        for (int nmn : numbers) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right){
                if ( numbers[left] == nmn ){
                    left++;
                    continue;
                }
                if ( numbers[right] == nmn ){
                    right--;
                    continue;
                }
                if ( numbers[left] + numbers[right] == (-1*nmn) ){
                    res.add(Arrays.asList(numbers[left], numbers[right], nmn ));
                }
                int i = numbers[left] + numbers[right] > (-1*nmn) ? right-- : left++;
            }
        }
        return res;
    }
}
