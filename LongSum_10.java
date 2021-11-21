/**
 * @author : Pandora
 * 2021/11/9-22:02
 */

public class LongSum_10 {
    public static int[] getNextMax(int[] num01, int[] num02){
        int length = 0;
        length = (num01.length > num02.length ? num01.length : num02.length);
        int[] result = new int[length + 1];
        reverse(num01);
        reverse(num02);

        for(int i = 0; i < result.length; i++){
            int temp = 0;
            if( i < num01.length )
                temp += num01[i];
            if( i < num02.length )
                temp += num02[i];
            System.out.println("temp:" + temp);
            if( temp >= 10 ){
                result[i + 1] = 1;
                temp -= 10;
            }
            result[i] += temp;
        }
        return result;
    }

    public static void reverse(int[] a){
        int left = 0,right = a.length-1;
        int temp = 0;
        while (left < right){
            temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    public static void show(int[] a){
        String string = new String();
        for( int i = a.length-1; i >= 0; i--){
            int temp = a[i];
            string += String.valueOf(temp);
        }
        System.out.println(Integer.valueOf(string));
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,9};
        int[] b = new int[]{4,3,2,7,0,1};
        show(getNextMax(a,b));
    }
}
