package interview6;

public class BinaryTree {

    class Node{
        public int data;
        public Node left;
        public Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node root;

    public BinaryTree(int data) {
        this.root = new Node(data);
    }

    public void add(int data){
        Node temp = root;
        if(data < temp.data){
            if(temp.left != null){
                temp = temp.left;
                add(data);
            }else{
                temp.left = new Node(data);
            }
        }else if(data > temp.data){
            temp = temp.right;
            if(temp.right != null){
                temp = temp.right;
                add(data);
            }else {
                temp.right = new Node(data);
            }
        }
    }


    //前序遍历:先访问左节点，然后根节点，然后右节点
    public void leftTraversal(){
        Node temp = root;

    }

    //中序遍历
    public void rootTraversal(){

    }

    //后序遍历
    public void rightTraversal(){

    }

}
