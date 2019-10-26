package interview7;

/**
 * 重建二叉树：输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果否不含重复的数字。
 * 例如：输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
 */
public class ConstructBinaryTree {

    public static void main(String[] args) {
        int preArr[] = {1,2,4,7,3,5,6,8};
        int inArr[] = {4,7,2,1,5,3,8,6};
        TreeNode tree = construct(preArr,inArr);
        preOrder(tree);
    }

    public static TreeNode construct(int[] preArr, int[] inArr){
        if(preArr == null || inArr == null || preArr.length == 0 || inArr.length == 0){
            return null;
        }
        return constructCore(preArr,inArr,0,preArr.length - 1,0,inArr.length - 1);
    }

    public static TreeNode constructCore(int[] preArr, int[] inArr, int preStart,int preEnd,int inStart,int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int root = preArr[preStart];
        //找出根节点在中序遍历结果中的位置
        int inRootIndex = -1;
        for (int j = 0; j < inArr.length; j++) {
            if (root == inArr[j]) {
                inRootIndex = j;
                break;
            }
        }

        // 没找到，参数不合法，返回null
        if (inRootIndex < 0) {
            return null;
        }

        TreeNode rootNode = new TreeNode(root);
        if (preStart == preEnd && inStart == inEnd) {
            return rootNode;
        }

        int leftLength = inRootIndex - inStart;

        if(leftLength > 0){
            rootNode.left = constructCore(preArr,inArr,
                    preStart + 1,preStart + leftLength,
                    inStart, inRootIndex - 1);

            rootNode.right = constructCore(preArr,inArr,
                    preStart + 1 + leftLength, preEnd,
                    inRootIndex + 1,inEnd);
        }
        return rootNode;
    }

    //树节点
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int data) {
            this.val = data;
        }
    }

    /**
     * 遍历二叉树
     * @param biTree
     */
    public static void preOrder(TreeNode biTree) {
        System.out.print(biTree.val + ",");
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
}
