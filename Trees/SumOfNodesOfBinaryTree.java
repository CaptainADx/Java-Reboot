public class SumOfNodesOfBinaryTree {
    
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
        int idx = -1;
        
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

    static int countNodes(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    static int sumOfNodes(TreeNode node){
        if(node == null){
            return 0;
        }
        
        return node.data + sumOfNodes(node.left) + sumOfNodes(node.right);
    }

    public static void main(String[] args) {
        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.println("Total Nodes in tree is --> " + countNodes(root));
        System.out.println("Sum of Nodes is --> " + sumOfNodes(root));
    }

}
