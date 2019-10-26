package interview6;

public class TreeMain {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(10);
        tree.add(6);
        tree.add(14);
        tree.add(4);
        tree.add(8);
        tree.add(12);
        tree.add(16);

        //tree.preOrder(tree.getRoot());//10,6,4,8,14,12,16,
        //tree.preOrder2(tree.getRoot());//10,6,4,8,14,12,16,
        //tree.inOrder(tree.getRoot());//4,6,8,10,12,14,16,
        //tree.inOrder2(tree.getRoot());//4,6,8,10,12,14,16,
        //tree.postOrder(tree.getRoot());//4,8,6,12,16,14,10,
        tree.postOrder2(tree.getRoot());//4,8,6,12,16,14,10,
    }
}
