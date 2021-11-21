package 链表相关;

import java.util.List;

/**
 * @author : Pandora
 * 2021/11/14-16:56
 * 剑指 Offer II 077. 链表排序 midem 给定链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 */

public class LinkSort {
    public static NodeList listSort(NodeList head){
        /**
        * @Author : Pandora
        * @Date : 19:52 2021/11/14
        * @Description : 链表排序
        * @Core : 冒泡排序法
        * @SolveThinking : 两遍循环，然后每一遍酒把一个最大的放到最后
        **/
        NodeList root = head;
        for (NodeList i = root; i.next != null; i = i.next ){
            for( NodeList j = root ; j.next != null; j = j.next){
                if ( j.val > j.next.val ){
                    int temp = j.val;
                    j.val = j.next.val;
                    j.next.val = temp;
                }
            }
        }
        return root;
    }


    public static NodeList linkSort_guibing(NodeList head){
        NodeList root = head;
        if ( root.next == null ){
            return root;
        }
        NodeList left = new NodeList(-1);
        left.next = head;
        NodeList right = head;
        while ( right != null && right.next != null){
            right = right.next.next;
            left = left.next;
        }
        right = left.next;
        left.next = null;
        head = linkSort_guibing( head );
        right = linkSort_guibing( right );
        NodeList res = LinkReverse.merge(head, right);

        return res;
    }

    public static void main(String[] args) {
        NodeList nodeList01 = new NodeList(1);
        NodeList nodeList02 = new NodeList(2);
        NodeList nodeList03 = new NodeList(5);
        NodeList nodeList04 = new NodeList(4);
        NodeList nodeList05 = new NodeList(3);
        NodeList nodeList06 = new NodeList(0);
        nodeList01.next = nodeList02;
        nodeList02.next = nodeList03;
        nodeList03.next = nodeList04;
        nodeList04.next = nodeList05;
        nodeList05.next = nodeList06;
        NodeList.show(nodeList01);
//        冒泡排序算法
//        NodeList.show(listSort(nodeList01));
//        归并排序算法
//        NodeList.show(linkSort_guibing(nodeList01));
    }
}
