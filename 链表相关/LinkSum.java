package 链表相关;

/**
 * @author : Pandora
 * 2021/11/15-1:30
 * 剑指 Offer II 025. 链表中的两数相加 midem 给定两个 非空链表 l1和 l2来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只
 * 存储一位数字。将这两数相加会返回一个新的链表。可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */

public class LinkSum {
    public static NodeList addTwoNumbers(NodeList l1, NodeList l2) {
        /**
        * @Author : Pandora
        * @Date : 1:55 2021/11/15
        * @Description : 链表中的两数相加
        * @Core : 反转链表 + 双指针
        * @SolveThinking : 先翻转两个字符串，通过双指针的方式遍历两个链表，相加判断是否进位等
        **/
        l1 = LinkReverse.reverse(l1);
        l2 = LinkReverse.reverse(l2);
        NodeList res = new NodeList(-1);
        NodeList result = res;
        Boolean mark = false;
        while ( l1 != null && l2 != null ){
            int temp = l1.val + l2.val;
            if ( mark )
                temp++;
            if ( temp >= 10 ){
                mark = true;
                temp -= 10;
            }else {
                mark = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            NodeList nodeList = new NodeList(temp);
            res.next = nodeList;
            res = res.next;
        }
        while ( l1 != null ){
            int temp = l1.val;
            if( mark ){
                temp ++;
                mark = false;
            }

            if ( temp >= 10 ){
                mark = true;
                temp -= 10;
            }

            NodeList nodeList = new NodeList(temp);
            res.next = nodeList;
            res = res.next;
            l1 = l1.next;
        }
        while ( l2 != null ){
            int temp = l2.val;
            if( mark ){
                temp ++;
                mark = false;
            }

            if ( temp >= 10 ){
                mark = true;
                temp -= 10;
            }

            NodeList nodeList = new NodeList(temp);
            res.next = nodeList;
            res = res.next;
            l2 = l2.next;
        }
        if (mark){
            NodeList nodeList = new NodeList(1);
            res.next = nodeList;
        }
        result = LinkReverse.reverse(result.next);
        return result;
    }
}
