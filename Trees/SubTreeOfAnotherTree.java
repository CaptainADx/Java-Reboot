public class SubTreeOfAnotherTree {
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
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

    public static boolean isIdentical(TreeNode mainTreeNode, TreeNode subTreeRoot){
        //If both tree have next node as null that means,  uptil that part trees are identical so return true
        if(mainTreeNode == null && subTreeRoot == null){
            return true;
        }

        //Else we will be checking all the cases for the False condition

        //Case 1 : If either of the Node is Null and other Not Null, then return false
        if(mainTreeNode == null || subTreeRoot == null){
            return false;
        } 
        // Case 2 : If the data at the nodes are not same, return false
        else if (mainTreeNode.data != subTreeRoot.data){
            return false;
        }

        // Case 3 : Check using recursive call the the Left and Right Part of Main-Tree also matches the Sub-Tree
        if(!isIdentical(mainTreeNode.left, subTreeRoot.left)) return false;
        if(!isIdentical(mainTreeNode.right, subTreeRoot.right)) return false;


        // If None of the above Cases Matches that means Main-Tree contains the Sub-Tree, so return true.
        return true;
        
    }

    public static boolean checkSubTree(TreeNode mainTreeRoot, TreeNode subTreeRoot){
        
        //Base case is if at any point mainTreeNode is null and SubTreeRoot is still not found then return false
        if(mainTreeRoot == null){
            return false;
        }

        //We will check if Current Data of MainTreeRoot & Data of SubTreeRoot are same
        if(mainTreeRoot.data == subTreeRoot.data){
            //if they are same we check if the remaining tree is identical or not using isIdentical Function
            if(isIdentical(mainTreeRoot, subTreeRoot)){
                return true;
            }
        }

        //Then we check if Sub-Tree Root lies in Left part of Main tree or not...
        boolean leftAns = checkSubTree(mainTreeRoot.left, subTreeRoot);

        //If Not found in Left part...
        //Then we check if Sub-Tree Root lies in Right part of Main tree or not...
        boolean rightAns = checkSubTree(mainTreeRoot.right, subTreeRoot);


        //Then we return OR of both cases coz if at any part(left or right) the subtree lies then return true
        return leftAns || rightAns;
        
    }

    public static void main(String[] args) {
        int[] mainTreeNodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        int[] subTreeNodes =  {2, 4, -1, -1, 5, -1, -1};

        BinaryTree mainTree = new BinaryTree();
        BinaryTree subTree = new BinaryTree();

        TreeNode mainTreeRoot = mainTree.buildTree(mainTreeNodes);
        TreeNode subTreeRoot = subTree.buildTree(subTreeNodes);

        System.out.println(mainTreeRoot.data);
        System.out.println(subTreeRoot.data);

        System.out.println(checkSubTree(mainTreeRoot, subTreeRoot));
    }
}
