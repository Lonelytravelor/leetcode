package 链表相关;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : Pandora
 * 2021/11/15-1:17
 * 剑指 Offer II 023. 两个链表的第一个重合节点 easy 给定两个单链表的头节点 headA 和 headB ，请找出并返回两个单链表相交的起始节点。如果两个
 * 链表没有交点，返回 null
 */

public class LinkPoint {
    public static NodeList getIntersectionNode(NodeList headA, NodeList headB) {
        /**
        * @Author : Pandora
        * @Date : 1:21 2021/11/15
        * @Description : 两个链表的第一个重合节点
        * @Core : hashSet
        * @SolveThinking : 通过把第一个链表中的节点都放进一个Set中，再判断headB是否存在于set中，存在则相交，不存在则结束时返回null
        **/
        Set<NodeList> set = new HashSet<>();
        while ( headA != null ){
            set.add(headA);
            headA = headA.next;
        }
        while ( headB != null ){
            if ( set.contains(headB) )
                return headB;
            headB = headB.next;
        }
        return null;
    }
}
