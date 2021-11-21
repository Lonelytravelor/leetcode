package 栈与队列相关;

import java.util.Stack;

/**
 * @author : Pandora
 * 2021/11/9-11:00
 * 155. 最小栈 easy 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 */

public class MinStacktest_03 {
    /**
    * @Author : Pandora
    * @Date : 11:11 2021/11/14
    * @Description : 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
    * @Core : 额外栈
    * @SolveThinking : 使用两个栈，一个作为存储数据的栈，一个作为存最小值的栈
     * 每当元素入栈时，就比对最小栈栈顶的元素与新入栈的元素的大小，如果小于最小值，则同时入两个栈空间内
     * 出栈时，如果出的值就是当前最小值，则一起出栈
    **/
    private Stack<Integer> mainStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();


    public void push(int num){
        /**
        * @Author : Pandora
        * @Date : 11:16 2021/11/14
        * @Description : 入栈
        * @Core : 判断
        * @SolveThinking : 当入栈时主栈没有元素，则说明当前为空栈，当前值为最小值，同时入栈
         * 当入栈时主栈有值，则直接入主栈，然后和最小栈中的栈顶元素比较，
         * 特别注意：如果小于等于最小值，则入栈，大于最小值则不操作
        **/
        if( mainStack.empty() || num <= minStack.peek()){
            minStack.push(num);
        }
        mainStack.push(num);
    }


    public int pop(){
        /**
        * @Author : Pandora
        * @Date : 11:18 2021/11/14
        * @Description : 出栈
        * @Core : 判断
        * @SolveThinking : 如果是最小值，则将最小栈中的元素也一起弹出
        **/
        if( mainStack.peek() == minStack.peek() ){
            minStack.pop();
        }
        return mainStack.pop();
    }


    public int getMin(){
        /**
        * @Author : Pandora
        * @Date : 11:19 2021/11/14
        * @Description : 获取最小值
        * @Core : 获取栈顶元素
        * @SolveThinking : peek（） -> 获取栈顶元素
        **/
        return minStack.peek();
    }


    public static void main(String[] args) {
        MinStacktest_03 minStacktest = new MinStacktest_03();
        minStacktest.push(2);
        minStacktest.push(3);
        minStacktest.push(4);
        minStacktest.push(5);
        minStacktest.push(6);
        minStacktest.push(1);
        System.out.println(minStacktest.getMin());
        System.out.println("pop:" + minStacktest.pop());
        System.out.println(minStacktest.getMin());
        System.out.println("pop:" + minStacktest.pop());
        System.out.println("pop:" + minStacktest.pop());
        System.out.println(minStacktest.getMin());

    }
}
