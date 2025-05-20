public class RopeCuttingProblem {

    //In this classic question we are provided with a rope of length N and we are provide with 3 options A, B & C
    //We need to cut the rope in such a way that no extra portion other than the option is left.
    //In each turn we can cut the rope in length equals to either of the three options (A, B, or C)

    public static int ropeCuttingSolution(int n, int a, int b, int c){
        if(n == 0){
            return 0;
        }
        if (n<0){
            return -1;
        }

        int res = 0;
        int choice1 = ropeCuttingSolution(n-a, a, b, c);
        int choice2 = ropeCuttingSolution(n-b, a, b, c);
        int choice3 = ropeCuttingSolution(n-c, a, b, c);

        res = Math.max(choice1, choice2);
        res = Math.max(res, choice3);

        if(res == -1){
            return -1;
        }

        return res+1;

    }
    public static void main(String[] args) {
        int ropeLength = 23;
        int cutOption1 = 9;
        int cutOption2 = 11;
        int cutOption3 = 12;

        System.out.println(ropeCuttingSolution(ropeLength, cutOption1, cutOption2, cutOption3));

    }
}
