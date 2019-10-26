package interview8;

/**
 * 获取二叉树的下一个节点
 * 给定一个二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中除了有两个分别指向左、右子节点的指针，还有一个指向父节点的指针。
 * 分析：
 * 1.第一种情况：有右子节点，且右子节点有左子树——>返回左子树里面最小的节点
 * 2.第二种情况：有右叶子节点——>直接返回右叶子节点。
 * 3.第三种情况：左叶子(没有子节点,某节点的左儿子)——>直接返回父节点
 * 4.第四种情况：右叶子(没有子节点,某节点的右儿子)——>返回父节点的父节点
 */
public class GetNextNode {

    static class Node{
        int data;
        Node left;
        Node right;
        Node parent;

        public Node(int data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10,null);
        Node n1 = add(6,root);
        Node n2 = add(14,root);
        Node n3 = add(4,root);
        Node n4 = add(8,root);
        Node n5 = add(12,root);
        Node n6 = add(11,root);
        Node n7 = add(13,root);
        Node n8 = add(16,root);

        //inOrder(root);
        //中序遍历结果：4,6,8,10,11,12,13,14,16,
        System.out.println(getNext(root,n6).data);
    }

    /**
     * 获取指定节点的下一个节点
     * @param root
     * @param current
     * @return
     */
    public static Node getNext(Node root,Node current){

        if(root == null || current == null){
            return null;
        }

        if(current.right != null){
            //第一种情况
            if(current.right.left != null){
                Node cL = current.right;
                while (cL.left != null){
                    cL = cL.left;
                }
                return cL;
            }
            //第二种情况
            if(current.right.left == null){
                return current.right;
            }
        }

        if(current.left == null && current.right == null){
            Node parent = current.parent;
            //第三种情况
            if(current.data == parent.left.data){
                return parent;
            }

            //第四种情况
            if(current.data == parent.right.data){
                if(parent.parent != null){
                    return parent.parent;
                }
            }
        }
        return null;
    }

    //给二叉树中添加节点
    public static Node add(int data,Node root){
        Node temp = root;
        Node currentRoot = null;

        while (temp != null){
            currentRoot = temp;
            if(data < temp.data){
                temp = temp.left;
            }else if(data > temp.data){
                temp = temp.right;
            }
        }

        Node parent = currentRoot;
        Node current = new Node(data,parent);

        if(data < currentRoot.data){
            currentRoot.left = current;
        }else if(data > currentRoot.data){
            currentRoot.right = current;
        }
        return current;
    }

    //中序遍历
    public static void inOrder(Node biTree) {
        if (biTree == null)
            return;
        else {
            inOrder(biTree.left);
            System.out.print(biTree.data + ",");
            inOrder(biTree.right);
        }
    }
}
