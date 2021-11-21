package 链表相关;

/**
 * @author : Pandora
 * 2021/11/14-16:38
 * 剑指 Offer 24. 反转链表 easy 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 21. 合并两个有序链表 easy 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 */


public class LinkReverse {

    public static NodeList reverse( NodeList head ){
        /**
         * @Author : Pandora
         * @Date : 16:51 2021/11/14
         * @Description : 翻转链表
         * @Core : 临时节点
         * @SolveThinking : 通过临时保存该节点的下一个点，因为如果改变该节点的指向，会丢失下一个点的信息
         * 首先创建临时节点存储cur节点的下一个节点，然后将cur之前pre节点，然后让pre节点向前一位（也就是将cur赋给pre），cur前进一位（之前保存
         * 的节点）
         **/
        NodeList pre = null;
        NodeList cur = head;

        while ( cur != null ){
            NodeList temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


    public static NodeList merge(NodeList head1, NodeList head2){
        /**
        * @Author : Pandora
        * @Date : 17:48 2021/11/14
        * @Description : 合并链表
        * @Core : 双指针
        * @SolveThinking : 双指针
        **/
        NodeList root = new NodeList(-1);
        NodeList head = root;
        while ( head1 != null && head2 != null ){
            if( head1.val < head2.val ){
                root.next = head1;
                head1 = head1.next;
            }else {
                root.next = head2;
                head2 = head2.next;
            }
            root = root.next;
        }
        root.next = head1 == null ? head2 : head1;

        return head.next;
    }

    public static void main(String[] args) {
        NodeList nodeList01 = new NodeList(1);
        NodeList nodeList02 = new NodeList(2);
        NodeList nodeList03 = new NodeList(6);
        NodeList nodeList04 = new NodeList(8);
        NodeList nodeList05 = new NodeList(9);

        NodeList nodeList06 = new NodeList(6);
        NodeList nodeList07 = new NodeList(7);
        NodeList nodeList08 = new NodeList(1);

        nodeList01.next = nodeList02;
        nodeList02.next = nodeList03;
        nodeList03.next = nodeList04;
        nodeList04.next = nodeList05;

        nodeList06.next = nodeList07;
        nodeList07.next = nodeList08;

        NodeList.show(nodeList01);
        NodeList.show(nodeList06);

//        翻转链表
//        NodeList resver = reverse(nodeList01);
//        合并链表
//        NodeList.show(merge(nodeList01, nodeList06));
        NodeList.show(LinkSum.addTwoNumbers(nodeList01, nodeList06));
    }
}
