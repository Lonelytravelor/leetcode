package 链表相关;

/**
 * @author : Pandora
 * 2021/11/15-1:59
 * 剑指 Offer II 026. 重排链表 midem 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 *
 * L0→ L1→ … → Ln-1→ Ln
 * 请将其重新排列后变为：
 *
 * L0→Ln→L1→Ln-1→L2→Ln-2→ …
 *
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

public class LinkArray {
    public void reorderList(NodeList head) {
        /**
        * @Author : Pandora
        * @Date : 2:15 2021/11/15
        * @Description :重排
        * @Core : 翻转链表 + 双指针
        * @SolveThinking : 先通过双指针获取到中间节点，然后翻转链表，再根据双指针重排链表
        **/
        NodeList root = head;
        NodeList left = head,right = head;
        while ( right != null || right.next != null ){
            left = left.next;
            right = right.next.next;
        }
        right = left.next;
        left.next = null;
        right = LinkReverse.reverse(right);
        while ( root != null && right != null ){
            NodeList temp1 = root.next;
            NodeList temp2 = right.next;
            root.next = right;
            right.next = temp1;
            root = temp1;
            right = temp2;
        }
    }
}
