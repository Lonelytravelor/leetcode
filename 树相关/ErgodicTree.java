package 树相关;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : Pandora
 * 2021/11/15-21:39
 */

public class ErgodicTree {
    public static void leftErgodicTree(TreeNodeM root){
        if (root == null)
            return;
        System.out.println(root.val);
        leftErgodicTree(root.left);
        leftErgodicTree(root.right);
    }

    public static void midErgodicTree(TreeNodeM root){
        if (root == null)
            return;
        leftErgodicTree(root.left);
        System.out.println(root.val);
        leftErgodicTree(root.right);
    }

    public static void rightErgodicTree(TreeNodeM root){
        if (root == null)
            return;
        leftErgodicTree(root.left);
        leftErgodicTree(root.right);
        System.out.println(root.val);
    }

    public static void layerErgodicTree(TreeNodeM root){
        if ( root == null )
            return;

        List<TreeNodeM> treeList = new LinkedList<TreeNodeM>();
        Queue<TreeNodeM> queue = new LinkedList<>();

        queue.add(root);
        while ( !queue.isEmpty() ){
            while ( !queue.isEmpty() ){
                treeList.add(queue.poll());
            }
            for (TreeNodeM tree : treeList) {
                System.out.print(tree.val);
                System.out.print(" ");
                if ( tree.left != null )
                    queue.add(tree.left);
                if ( tree.right != null )
                    queue.add(tree.right);
            }
            treeList.clear();
            System.out.println();
        }
    }

    public static void layerErgodicTree02(TreeNodeM root){
        if ( root == null )
            return;
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNodeM> queue = new LinkedList<>();

        queue.add(root);
        while ( queue.size() > 0 ){
           int num = queue.size();
           List<Integer> temp = new LinkedList<>();
           for (int i = 0; i < num; i++){
               TreeNodeM tree = queue.poll();
               if ( tree.left != null )
                   queue.add(tree.left);
               if ( tree.right != null )
                   queue.add(tree.right);
               temp.add(tree.val);
           }
           res.add(temp);
        }
    }

    public static void main(String[] args) {
        TreeNodeM tree01 = new TreeNodeM(1);
        TreeNodeM tree02 = new TreeNodeM(2);
        TreeNodeM tree03 = new TreeNodeM(3);
        TreeNodeM tree04 = new TreeNodeM(4);
        TreeNodeM tree05 = new TreeNodeM(5);
        TreeNodeM tree06 = new TreeNodeM(6);

        tree01.left = tree02;
        tree01.right = tree03;
        tree02.left = null;
        tree02.right = tree04;
        tree03.left = tree05;
        tree03.right = tree06;
        tree05.left = null;
        tree05.right = null;
        tree06.left = null;
        tree06.right = null;

//        leftErgodicTree();
//        midErgodicTree();
//        rightErgodicTree();
        layerErgodicTree(tree01);


    }
}
