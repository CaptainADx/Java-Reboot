class BuildTreeBasics {

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
      a  static int idx = -1;
        public TreeNode buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1) return null; 

            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }
    
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root);  //Print root.data to see the data at memory location
    }
}


//Level Order Traversal With null Markers

/*
    import java.util.*;

    class BuildTreeLevelOrder {

        static class TreeNode {
            int data;
            TreeNode left, right;

            TreeNode(int data) {
                this.data = data;
            }
        }

        public static TreeNode buildTree(int[] nodes) {
            if (nodes.length == 0 || nodes[0] == -1) return null;

            // Step 1: Create root
            TreeNode root = new TreeNode(nodes[0]);

            // Step 2: Queue for BFS
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            int i = 1;

            // Step 3: Process nodes
            while (!q.isEmpty() && i < nodes.length) {
                TreeNode curr = q.poll();

                // Left child
                if (i < nodes.length && nodes[i] != -1) {
                    curr.left = new TreeNode(nodes[i]);
                    q.add(curr.left);
                }
                i++;

                // Right child
                if (i < nodes.length && nodes[i] != -1) {
                    curr.right = new TreeNode(nodes[i]);
                    q.add(curr.right);
                }
                i++;
            }

            return root;
        }

        public static void main(String[] args) {
            int[] nodes = {1, 2, 3, 4, 5, -1, 6};

            TreeNode root = buildTree(nodes);

            System.out.println(root.data); // 1
        }
    }
 
*/
