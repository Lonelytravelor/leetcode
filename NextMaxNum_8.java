import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author : Pandora
 * 2021/11/10-16:24
 */

public class NextMaxNum_8 {
    public static int[] getNextMaxNum(int[] nums){

        int[] num_mine = Arrays.copyOf(nums,nums.length);
        int pos = -1;
        for( int i = num_mine.length - 1; i > 0; i--){
            if( num_mine[i] > num_mine[i-1]){
                pos = i - 1;
                break;
            }
        }
        if( pos == -1 || num_mine.length == 1){
            return null;
        }
        int min_pos = pos+1;
        int min_num = num_mine[pos+1];
        for(int i = min_pos; i < num_mine.length; i++){
            if( min_num > num_mine[i] && min_num > num_mine[pos]){
                min_num = num_mine[i];
                min_pos = i;
            }
        }
        System.out.println(min_pos);
        int temp = num_mine[min_pos];
        num_mine[min_pos] =num_mine[pos];
        num_mine[pos] = temp;
        show(num_mine);
        int left = pos+1, right = num_mine.length-1;
        temp = 0;
        while (left < right){
            temp = num_mine[left];
            num_mine[left] = num_mine[right];
            num_mine[right] = temp;
            left++;
            right--;
        }

        return num_mine;
    }

    public static void show(int[] a){
        String string = new String();
        for( int i = 0; i < a.length; i++){
            int temp = a[i];
            string += String.valueOf(temp);
        }
        System.out.println(Integer.valueOf(string));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2};
        int[] res = getNextMaxNum(nums);
        show(res);
    }
}
