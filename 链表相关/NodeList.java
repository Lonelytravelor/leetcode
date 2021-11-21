package 链表相关;

class NodeList{
    public int val;
    public NodeList next;

    public NodeList(int data) {
        this.val = data;
    }

    public static void show(NodeList head){
        NodeList root = head;
        while ( root != null ){
            System.out.print(root.val);
            System.out.print(" ");
            root = root.next;
        }
        System.out.println();
    }
}