package 链表相关;

/**
 * @author : Pandora
 * 2021/11/15-0:32
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点 medim 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 */

public class DeleteKPoint {
    public static NodeList deleteKPoint(NodeList head, int k){
        /**
        * @Author : Pandora
        * @Date : 0:56 2021/11/15
        * @Description : 删除链表的倒数第 n 个结点
        * @Core : 快慢指针
        * @SolveThinking : 通过快慢指针的方式向让右指针先以动k个节点，然后一起移动知道right为null
         * 问题的核心是要判断k是否为数组的长度，否则就是删除首个元素
        **/
        NodeList root = head,left = head, right = head;
        for (int i = 0; i < k ; i++ ){
            right = right.next;
        }
        if ( right == null ){
            return root.next;
        }
        while ( right.next != null ){
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return root;
    }

    public static NodeList deleteKPointPro(NodeList head, int k){
        /**
        * @Author : Pandora
        * @Date : 1:12 2021/11/15
        * @Description : 删除链表的倒数第 n 个结点Pro
        * @Core : 哨兵 + 快慢指针法
        * @SolveThinking : 原解法需要特殊考虑到边界值的情况，通过加入哨兵的方式我们可以避免删除的k与长度相等。来避免边界条件
        **/
        NodeList root = new NodeList(-1);
        root.next = head;
        NodeList left = root, right = head;
        for( int i = 0; i < k; i++)
            right = right.next;
        while ( right != null ){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return root.next;
    }

    public static void main(String[] args) {

    }
}
