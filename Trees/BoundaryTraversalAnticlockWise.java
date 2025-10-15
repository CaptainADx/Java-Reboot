
import java.util.ArrayList;

public class BoundaryTraversalAnticlockWise {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    

    public ArrayList<Integer> printBoundary(TreeNode node){
        ArrayList<Integer> res = new ArrayList<>();
        if(node == null ) return res;
        res.add(node.data);
        addLeftBoundary(node, res);
        addLeafNodes(node, res);
        addRightBoundary(node, res);

        return res;
    }

    public void addLeftBoundary(TreeNode node, ArrayList<Integer> res){
        TreeNode curr = node.left;
        while(curr != null){
            if(isLeaf(curr) == false) res.add(curr.data);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    public void addLeafNodes(TreeNode node, ArrayList<Integer> res){
        if(isLeaf(node)){
            res.add(node.data);
            return;
        }
        if(node.left != null) addLeafNodes(node.left, res);
        if(node.right != null) addLeafNodes(node.right, res);
    }

    public void addRightBoundary(TreeNode node, ArrayList<Integer> res){
        TreeNode curr = node.right;
        ArrayList<Integer> temp = new ArrayList<>();

        while(isLeaf(curr) == false) {
            temp.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for(int i=temp.size()-1; i>=0; i--){
            res.add(temp.get(i));
        }

    }

    public boolean isLeaf(TreeNode node){
        return (node.left == null && node.right == null);
    }

    public static class BinaryTree{
        static int idx = -1;
        public TreeNode buildTree(int[] nodes) {
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

    
    public static void main(String[] args) {
            int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            BinaryTree tree = new BinaryTree();
            TreeNode root = tree.buildTree(nodes);
            System.out.println(root.data);  //Print root.data to see the data at memory location

            BoundaryTraversalAnticlockWise btac = new BoundaryTraversalAnticlockWise();


            System.out.println(btac.printBoundary(root));
        }
}
