

public class DiameterOfATreeApproach1 {
    
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class BinaryTree{
        static int idx = -1;
        
        public TreeNode buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    static int diameter = 0;
    public static int diameterOfTree(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftMax = diameterOfTree(node.left);
        int rightMax = diameterOfTree(node.right);

        diameter = Math.max(diameter, (leftMax + rightMax + 1));

        return 1 + Math.max(leftMax, rightMax);

    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, 8, -1, -1, 3, 6, -1, -1, 7, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);

        //Setting the idx as -1;
        BinaryTree.idx = -1;
        diameterOfTree(root);
        System.out.println("Diameter of Tree --> " + diameter);
    }
}
