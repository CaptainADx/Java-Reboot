public class PowerSet {
    public static void main(String[] args) {
        String s = "abc";
        int n = s.length();
        int powerSetSize = 1<<n;

        for(int i=0; i<powerSetSize; i++){
            boolean isEmpty = true;
            for(int j=0; j<n;j++){
                if((i&(1<<j)) != 0){
                    System.out.print(s.charAt(j));
                    isEmpty = false;
                }
            }
            if(isEmpty){
                System.out.print("NULL");
            }
            System.out.println();
        }
    }
}
