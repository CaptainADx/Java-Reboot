public class gridWays {

    public static int gridWay(int i, int j, int rows, int cols){
        if(i==rows-1 && j==cols-1){
            return 1;
        } else if(i== rows || j == cols){
            return 0;
        }

        int w1 = gridWay(i+1, j, rows, cols);
        int w2 = gridWay(i, j+1, rows, cols);

        return w1+w2;
    }
    public static void main(String[] args) {
        int n=3,  m=3;

        System.out.println(gridWay(0, 0, n, m));
    }
}

