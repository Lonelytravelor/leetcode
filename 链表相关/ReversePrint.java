package 链表相关;

import java.util.Stack;

/**
 * @author : Pandora
 * 2021/11/21-19:17
 * 剑指 Offer 06. 从尾到头打印链表 easy 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 */

public class ReversePrint {
    public int[] reversePrint(NodeList head) {
        /**
        * @Author : Pandora
        * @Date : 19:25 2021/11/21
        * @Description : 从尾到头打印链表
        * @Core : 额外栈
        * @SolveThinking : 使用栈进行倒序存储链表元素
        **/
        Stack<Integer>  stack = new Stack<>();
        while ( head != null ){
            stack.push(head.val);
            head = head.next;
        }
        int[] array = new int[stack.size()];
        for ( int i = 0; i < array.length; i++){
            array[i] = stack.pop();
        }
        return array;
    }
}
