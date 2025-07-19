import java.util.ArrayList;

public class LCA_1 {
    
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

    public static boolean getPath(TreeNode node, int k, ArrayList<TreeNode> pathOfK){
        if(node == null){
            return false;
        }

        pathOfK.add(node);

        if(node.data == k){
            return true;
        }
        
        boolean foundLeft = getPath(node.left, k, pathOfK);
        boolean foundRight = getPath(node.right, k, pathOfK);

        if(foundLeft || foundRight){
            return true;
        } 
        
        pathOfK.remove(pathOfK.size()-1);
        
        return false;
    }

    public static int lowestCommonAncestor(TreeNode root, int a, int b){
        ArrayList<TreeNode> pathOfA = new ArrayList<>();
        ArrayList<TreeNode> pathOfB = new ArrayList<>();

        boolean foundA = getPath(root, a, pathOfA);
        boolean foundB = getPath(root, b, pathOfB);
        
        if (!foundA || !foundB) {
            System.out.println("One or both nodes not found in the tree.");
            return -1; 
        }


        int i;
        
        for(i=0; i<pathOfA.size() && i<pathOfB.size(); i++){
            if(pathOfA.get(i) != pathOfB.get(i)){
                break;
            }
            
        }

        return pathOfA.get(i-1).data;
    }



    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        TreeNode root = tree.buildTree(nodes);
        System.out.println(root.data);

        int a = 5, b =4;
        int LCA = lowestCommonAncestor(root, a, b);
        if(LCA != -1){
            System.out.println("Lowest common ancesstor of " + a + " & " + b + " are --> " + LCA);
        }
    }
}