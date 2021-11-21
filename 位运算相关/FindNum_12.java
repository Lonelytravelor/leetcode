package 位运算相关;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author : Pandora
 * 2021/11/10-11:00
 *
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字 easy
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 * 136. 只出现一次的数字 easy
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 剑指 Offer II 004. 只出现一次的数字II  midem
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 * 137. 只出现一次的数字 III midem
 * 给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案
 */

public class FindNum_12 {
    public static int findNum01(int[] nums){
        /**
        * @Author : Pandora
        * @Date : 11:46 2021/11/14
        * @Description : 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且
         * 只有一个数字不在该数组中，请找出这个数字。
        * @Core : HashSet
        * @SolveThinking : 通过依次遍历0-n-1的所有数，并把它们依次加入Hashset中，再遍历给定输入，在HashSet依次删除，剩下的就是缺少的数
        **/
        Set<Integer> numSet = new HashSet<>();
        for( int i = 1; i <= 10; i++){
            numSet.add(i);
        }
        for (int i : nums) {
            numSet.remove(i);
        }
        Iterator<Integer> it = numSet.iterator();
        int res = -1;
        while (it.hasNext()){
            res = it.next();
        }
        return res;
    }


    public static int findNum02(int[] nums){
        /**
        * @Author : Pandora
        * @Date : 11:48 2021/11/14
        * @Description : 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且
         * 只有一个数字不在该数组中，请找出这个数字。
        * @Core : 累加和
        * @SolveThinking : 将0-n-1之间做累加，减去给定数组的累加，即可得到缺少的数字
        **/
        int sum = 0;
        int res = 0;
        for( int i = 1; i <= 10; i++){
            sum += i;
        }
        for( int i = 0; i < nums.length; i++ ){
            res += nums[i];
        }

        return sum - res == 0 ? -1 : sum - res;
    }


    public static int findNum03(int[] nums){
        /**
        * @Author : Pandora
        * @Date : 11:50 2021/11/14
        * @Description : 一个数组中，只有一个数组出现了奇数次，找到它
        * @Core : 位运算
        * @SolveThinking : 通过异或运算，我们可以消除掉相同的数字，剩下的则为出现次数为奇数的数字
         * 可以使用0进行亦或运算
        **/
        int res = 0;
        for(int i = 0; i < nums.length; i++ ){
            res ^= nums[i];
        }
        return res == 0 ? -1 : res;
    }

    public static int singleNumber(int[] nums) {
        /**
         * @Author : Pandora
         * @Date : 11:04 2021/11/15
         * @Description : 某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
         * @Core : 位运算
         * @SolveThinking : 因为除了目标元素剩下的元素都出现了三次，所以该位置的二进制和应该为3的整数倍（%3等于目标元素）
         **/
        int res = 0;
        int mark = 1;
        for( int i = 0; i < 32; i++){
            int sum = 0;
            for( int j = 0; j < nums.length; j++){
                sum += (nums[j] & mark) >> i;
            }
            mark <<= 1;
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }

    public static int[] findNum04(int[] nums){
        /**
        * @Author : Pandora
        * @Date : 11:52 2021/11/14
        * @Description : 在一个无序序列中有两个数出现了奇数次，其余都出现了偶数次，找到他
        * @Core : 位运算-分而治之
        * @SolveThinking : 累次相异或后得到的是最后两个数异或的结果，那么从右至左的第一位为1的位是两个数的分割线，然后将元分组切割成两个组进
         * 行上一个问题的解决方式
        **/
        int res = nums[0];
        int[] result = new int[2];
        for(int i = 1; i < nums.length; i++ ){
            res ^= nums[i];
        }
        if( res == 0){
            System.out.println("-1");
            return result;
        }
        int positon = 1;

//        ############
//        比较核心的一点：找到分界点
//        通过&运算来获得分界点，因为通过与运算，只要跟介点值的位不想对应，结果值都为零
//        ############
        while ((positon & res) == 0){
            positon <<= 1;
        }
        for( int i = 0; i < nums.length; i++){
            if( (nums[i] & positon) == 0){
                result[0] ^= nums[i];
            }else {
                result[1] ^= nums[i];
            }
        }
        System.out.println(result[0] + " " + result[1]);
        return result;
    }



    public static void main(String[] args) {
        int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
        int[] b = new int[]{1,1,2,2,3,3,4,4,5,5,6,6,7,7,7,7,8,8,9,9,10,10};
        int[] c = new int[]{1,1,2,2,3,3,4,5,6,6,7,7,7,7,8,8,9,9,10,10};
        int[] d = new int[]{2,3,2,2};
        System.out.println(1<<1);
        System.out.println(findNum01(a));
        System.out.println(findNum02(a));
        System.out.println(findNum03(b));
        findNum04(c);
        System.out.println(singleNumber(d));

    }
}
