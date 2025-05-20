public class PrintAllSubsets {
    //This is the recursive way to solve this problem.
    //There one more way mentioned to solve the same problem more efficiently using Bitwise operation
    //This is mentioned under the name -->  PowerSet.java 

    //In the recursive approach:
    //Time complexity is same --> O(n ⋅ 2^n)
    //Space Complexity in Bitwise is --> O(n)
    public static void printSubsets(String s, int idx, String emptyString){
        if(idx==s.length()){
            if(emptyString.length()==0){
                System.out.println("NULL");
            } else {
                System.out.println(emptyString);
            }
            
            return;
        }

        printSubsets(s, idx+1, emptyString);
        printSubsets(s, idx+1, emptyString+s.charAt(idx));
    }

    //THE BELOW CODE IS THE APPROACH USING BITWISE OPERATION
    //Time complexity is same --> O(n ⋅ 2^n)
    //Space Complexity in Bitwise is --> O(1)
    public static void PowerSet(String s){
        int n = s.length();
        int pSize = 1<<n;

        for(int i=0; i<pSize; i++){
            boolean isEmpty = true;
            for(int j=0; j<n; j++){
                if((i&(1<<j))!= 0){
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

    public static void main(String[] args){
        String s = "ABC";
        printSubsets(s, 0, "");
        // PowerSet(s);
    }
}
