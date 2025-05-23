public class TowerOfHanoi {

    //Note here:
    // first parameter is START
    // second is Helper
    // third is Destination

    public static void TOH(int n, char A, char B, char C){
        if(n==1){
            System.out.println("Move disc 1 from " + A + " to "+ C );
            return;
        }
        TOH(n-1, A, C, B);
        System.out.println("Move Disc "+ n +" from "+ A + " to "+C);
        TOH(n-1, B, A, C);
    }
    
    public static void main(String[] args) {
        int discs = 3;
        TOH(discs, 'A', 'B', 'C');
    }
}
