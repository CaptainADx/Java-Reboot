import java.util.*;

public class VerticalOrderTraversal {

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

    public static class Tuple{
        TreeNode node;
        int col;
        int level;

        public Tuple(TreeNode _node, int _col, int _level){
            this.node = _node;
            this.col = _col;
            this.level = _level;
        }

    }

    public static List<List<Integer>> verticalTraversal (TreeNode root){
        //The format is like TreeMap<Vertical Column, TreeMap<Level, PriorityQueue<Data Values>>>
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.col;
            int y = tuple.level;

            if(!map.containsKey(x)){
                map.put(x, new TreeMap<>());
            }
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.data);

            if(node.left != null){
                q.offer(new Tuple(node.left, x-1, y+1));
            }

            if(node.right != null){
                q.offer(new Tuple(node.right, x+1, y+1));
            }

        }

        List<List<Integer>> res = new ArrayList<>();
        
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()){
            res.add(new ArrayList<>());

            for(PriorityQueue<Integer> pq : ys.values()){
                while(!pq.isEmpty()){
                    res.get(res.size()-1).add(pq.poll());
                }
            }
        }

        return res;
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

        System.out.println(verticalTraversal(root));
    }
    
}
