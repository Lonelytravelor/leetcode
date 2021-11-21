package 树相关;

/**
 * @author : Pandora
 * 2021/11/15-21:40
 */

public class TreeNodeM {
    int val;
    TreeNodeM left;
    TreeNodeM right;

    TreeNodeM() {}
    TreeNodeM(int val) {
         this.val = val;
    }
    TreeNodeM(int val, TreeNodeM left, TreeNodeM right) {
         this.val = val;
         this.left = left;
         this.right = right;
    }

}
