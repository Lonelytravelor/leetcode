package 栈与队列相关;

import java.util.Stack;

/**
 * @author : Pandora
 * 2021/11/9-12:11
 * 剑指 Offer 09. 用两个栈实现队列 easy 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */

public class QueueOfStack_07 {
    /**
    * @Author : Pandora
    * @Date : 11:23 2021/11/14
    * @Description : 请实现它的两个函数 appendTail 和 deleteHead
    * @Core : 额外栈
    * @SolveThinking : 由于队列是先进先出，栈是后进先出，则通过两个栈，当队列要弹出元素时，通过一个栈先弹出到另一个栈中，然后再从第二个栈弹出
    **/
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void push(int num ){
        /**
        * @Author : Pandora
        * @Date : 11:32 2021/11/14
        * @Description : 入栈
        * @Core : 入栈
        * @SolveThinking : 元素入栈正常进入inStack，不做其他操作
        **/
        inStack.push(num);
    }

    public Integer pop(){
        /**
        * @Author : Pandora
        * @Date : 11:32 2021/11/14
        * @Description : 出栈时首先判断outStack中是否有元素，有则首先出outStack中的元素，
         * 否则就判断inStack中是否有元素，如有，就依次弹出放入outStack中，如果没有代表整个队列为空，返回null
        * @Core :
        * @SolveThinking :
        **/
        if(outStack.empty()){
            if(inStack.empty()){
                return null;
            }
            while ( !inStack.empty() ){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        QueueOfStack_07 queueOfStack_07 = new QueueOfStack_07();
        queueOfStack_07.push(1);
        queueOfStack_07.push(2);
        System.out.println(queueOfStack_07.pop());
        queueOfStack_07.push(3);
        System.out.println(queueOfStack_07.pop());
        System.out.println(queueOfStack_07.pop());
        queueOfStack_07.push(4);
        queueOfStack_07.push(5);
        System.out.println(queueOfStack_07.pop());
        System.out.println(queueOfStack_07.pop());
        System.out.println(queueOfStack_07.pop());
        System.out.println(queueOfStack_07.pop());
    }
}
