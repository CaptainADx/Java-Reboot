import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {
    public static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int _data) {
            this.data = _data;
            this.left = null;
            this.right = null;
        }
    }
    public static class BinaryTree {
        int idx = -1;

        public TreeNode buildTree(int[] nodes){
            idx ++;
            if(nodes[idx] == -1){
                return null;
            }

            TreeNode newNode = new TreeNode(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

    }

    public static boolean findRootToNodePath(TreeNode node, int target, List<Integer> path){
        if(node == null){
            return false;
        }

        path.add(node.data);
        if(node.data == target){
            return true;
        }

        if(findRootToNodePath(node.left, target, path) || findRootToNodePath(node.right, target, path)){
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }

    public static List<Integer> solve(TreeNode node, int target){
        List<Integer> res = new ArrayList<>();
        if(node == null){
            return res;
        }

        findRootToNodePath(node, target, res);
        return res;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 8, -1, -1, 9, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);  //Print root.data to see the data at memory location


        System.out.println(solve(root, 6));
    }
}
