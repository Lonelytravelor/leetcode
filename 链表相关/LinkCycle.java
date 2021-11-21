package 链表相关;

/**
 * @author : Pandora
 * 2021/11/9-9:52
 * 141. 环形链表 easy 给定一个链表，判断链表中是否有环。
 * 142. 环形链表 II medim 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */



public class LinkCycle {

    public static boolean isCycle(NodeList head){
        /**
        * @Author : Pandora
        * @Date : 9:55 2021/11/14
        * @Description : 实现给定一个链表，判断链表中是否有环。
        * @Core : 快慢指针法
        * @SolveThinking :
         * 通过快指针向前，判断是否有环，因为每次前进两个距离，所以可能会出现到达链表的最后一个位置，这样下一次走两个位置就可能会报空指针异常。
         * 如果存在环，那么快慢指针会相遇，故只要循环判断即可
        **/
        NodeList p1 = head;
        NodeList p2 = head.next;

        while (p2 != null && p2.next != null ){
            if( p1 == p2 ){
                return true;
            }else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        return false;
    }

//    判断环的长度
    public static int cycleLength(NodeList head){
        /**
        * @Author : Pandora
        * @Date : 10:50 2021/11/14
        * @Description : 实现给定一个链表，判断链表中环的长度。
        * @Core : 循环
        * @SolveThinking : 记录相遇点，然后通过另一个指针进行循环，直至回到相遇点
        **/
        NodeList p1 = head;
        NodeList p2 = head.next;
        int length = 0;
        NodeList temp = null;

        while (p2 != null && p2.next != null ){
            if( p1 == p2 ){
                temp = p1.next;
                length ++;
                break;
            }else {
                p1 = p1.next;
                p2 = p2.next.next;
            }
        }
        while (temp != p1){
            temp = temp.next;
            length ++;
        }
        return length;
    }

    public static NodeList ctcleBegin(NodeList head){
        /**
        * @Author : Pandora
        * @Date : 10:52 2021/11/14
        * @Description : 判断环的入点
        * @Core : 循环
        * @SolveThinking : 问题的核心就是判断他们相遇的点，因为通过快慢指针再相遇时快指针是慢指针的两倍路程
         * 可得等式    2（D+S1） = D+S1+n（S1+S2）  => D = n(S1+S2)-S1  => D = (n-1)(S1+S2)+S2
         * 故从起始点到入点的距离等于相交点走n圈之后再到入点的距离
        **/
        NodeList p1 = head;
        NodeList p2 = head;
        NodeList point = null;

        while (p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if( p1 == p2 ){
                point = p1;
                break;
            }
        }
        p2 = head;
        while ( p2 != point ){
            System.out.println("p2=" + p2.val);
            System.out.println("point=" + point.val);
            p2 = p2.next;
            point = point.next;
        }
        return point;
    }

//    实现主函数，完成对链表的创建和初始化
    public static void main(String[] args) {
        NodeList nodeList = null;

        NodeList nodeList01 = new NodeList(1);
        NodeList nodeList02 = new NodeList(2);
        NodeList nodeList03 = new NodeList(3);
        NodeList nodeList04 = new NodeList(4);
        NodeList nodeList05 = new NodeList(5);
        NodeList nodeList06 = new NodeList(6);

        nodeList01.next = nodeList02;
        nodeList02.next = nodeList03;
        nodeList03.next = nodeList04;
        nodeList04.next = nodeList05;
        nodeList05.next = nodeList06;
        nodeList06.next = nodeList04;
//  输出是否为环
        System.out.println(isCycle(nodeList01));
//  输出环的长度
        System.out.println(cycleLength(nodeList01));
//  计算环的入点
        System.out.println(ctcleBegin(nodeList).val);
    }
//    计算环的入节点是要考虑两个游标的路程，故在初始化时只能两个都在同一地址进行前进，否则长度不同
//    所以在计算交点时，要考虑先判断还是先前进


}
