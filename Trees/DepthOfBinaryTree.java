public class DepthOfBinaryTree {

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

    static class BinaryTree {
        int idx = -1;

        public TreeNode buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1) return null;

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    // int depth = 0;
    static int findDepthOfTree(TreeNode node){
        if(node == null) return 0;

        int leftDepth = findDepthOfTree(node.left);
        int rightDepth = findDepthOfTree(node.right);
        int currDepth = Math.max(leftDepth, rightDepth);
        
        return 1 + currDepth;
        
    }
    
    public static void main(String[] args){
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        int depth = findDepthOfTree(root);
        System.out.println("Maximum Depth of tree is --> " + depth);
    }
}
