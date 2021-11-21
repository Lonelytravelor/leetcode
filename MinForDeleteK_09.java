import java.util.Stack;

/**
 * @author : Pandora
 * 2021/11/9-12:33
 */

public class MinForDeleteK_09 {
    public static int minForDeleteK(int num, int k){
        String numStr = String.valueOf(num);
        if ( numStr.length() == k ){
            return 0;
        }

        for(int i = 0; i < k; i++){
            boolean mark = false;
            for(int j = 0; j < numStr.length(); j++){
                if( numStr.charAt(j) > numStr.charAt(j+1)){
                    numStr = (numStr.substring(0,j) + numStr.substring(j+1,numStr.length()));
                    mark = true;
                    break;
                }
            }
            if ( !mark ){
                numStr = numStr.substring(0,numStr.length()-1);
            }
        }
        return Integer.valueOf(numStr);
    }

    public static String minForDeleteK02(String numStr, int k){
        int newLenght = numStr.length() - k;
        char[] stack = new char[numStr.length()];
        int top = 0;
        for( int i = 0; i < numStr.length(); i++){
            char c = numStr.charAt(i);
            while( top > 0 && stack[top-1] > c && k > 0){
                top -= 1;
                k -= 1;
            }
            stack[top++] = c;
        }
        int offset = 0;
        while (offset < newLenght && stack[offset] == '0') {
            offset++;
        }
        return (offset == newLenght ? "0" : new String(stack,offset,newLenght-offset));
    }

    public static int minForDeleteK03(int num,  int k){
        Stack<Character> stack = new Stack<>();
        String numStr = String.valueOf(num);
        int r = k;
        if ( numStr.length() == k ){
            return 0;
        }
        for( int i = 0; i < numStr.length(); i++){
            char c = numStr.charAt(i);
            while( k > 0 && !stack.empty() && stack.peek() > c){
                stack.pop();
                k --;
            }
            stack.push(c);

        }
        int length = numStr.length() - r;
        char[] list = new char[length];
        int i = length - 1;
        while ( i >= 0 ){
            list[i] = stack.pop();
            i--;
        }
        String s = String.valueOf(list);
        return Integer.valueOf(s);
    }


    public static void main(String[] args) {
        System.out.println(minForDeleteK(1593212, 3));
        System.out.println(minForDeleteK02("1593212", 3));
        System.out.println(minForDeleteK03(1593212, 3));
    }
}
