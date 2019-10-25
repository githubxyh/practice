package interview6;

import java.util.Stack;

public class BinaryTree {

    class TreeNode{
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }

    private TreeNode root;

    public TreeNode getRoot() {
        return root;
    }

    public BinaryTree(int data) {
        this.root = new TreeNode(data);
    }

    public void add(int data){
        TreeNode temp = root;
        TreeNode currentRoot = null;

        while (temp != null){
            currentRoot = temp;
            if(data < temp.data){
                temp = temp.left;
            }else if(data > temp.data){
                temp = temp.right;
            }
        }
        if(data < currentRoot.data){
            currentRoot.left = new TreeNode(data);
        }else if(data > currentRoot.data){
            currentRoot.right = new TreeNode(data);
        }
    }


    //前序遍历，递归实现
    public static void preOrder(TreeNode biTree)
    {
        System.out.print(biTree.data + ",");
        TreeNode leftTree = biTree.left;
        if(leftTree != null)
        {
            preOrder(leftTree);
        }
        TreeNode rightTree = biTree.right;
        if(rightTree != null)
        {
            preOrder(rightTree);
        }
    }


    //前序遍历非递归实现
    public static void preOrder2(TreeNode root){
        if(root==null) return;
        Stack<TreeNode> s=new Stack<>();
        while (!s.isEmpty()||root!=null){
            while(root!=null){
                System.out.print(root.data+",");
                s.push(root);
                root=root.left;
            }
            if(!s.isEmpty()){
                TreeNode t=s.pop();
                root=t.right;
            }
        }
    }

    //中序遍历，递归实现
    public static void midOrder(TreeNode biTree) {

        if (biTree == null)
            return;
        else {
            midOrder(biTree.left);
            System.out.print(biTree.data + ",");
            midOrder(biTree.right);
        }
    }

    //中序遍历，非递归实现
    public static void midOrder2(TreeNode biTree){
        if(biTree==null) return;
        Stack<TreeNode> s=new Stack<>();
        while (!s.isEmpty()||biTree!=null){
            while(biTree!=null){
                s.push(biTree);
                biTree=biTree.left;
            }
            if(!s.isEmpty()){
                TreeNode t = s.pop();
                System.out.print(t.data+",");
                biTree=t.right;
            }
        }
    }

    //后续遍历，递归实现
    public static void postOrder(TreeNode biTree) {

        if (biTree == null)
            return;
        else {
            postOrder(biTree.left);
            postOrder(biTree.right);
            System.out.print(biTree.data + ",");
        }
    }

    //后续遍历，非递归实现
    public static void postOrder2(TreeNode biTree) {

        if(biTree==null) return;
        Stack<TreeNode> s=new Stack<>();
        TreeNode last=null;
        while (!s.isEmpty()||biTree!=null){
            while (biTree!=null){
                s.push(biTree);
                biTree=biTree.left;
            }
            if(!s.isEmpty()){
                TreeNode t=s.pop();
                if(t.right==null||last==t.right){//在这里面打印t并处理last之后，并不用处理root，因为之所以能进入这里，是因为root一定等于null，所以下一轮循环一定还能进入这里，然后弹出t的父结点做处理
                    System.out.print(t.data+",");
                    last=t;
                }else{//右孩子还没有打印过
                    s.push(t);//因为当前结点未打印，所以要重新放回去，等右孩子打印完之后回来打印
                    biTree=t.right;
                }
            }
        }
    }
}
