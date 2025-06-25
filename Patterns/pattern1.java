public class pattern1 {
    public static void printPattern(int n){
        int num = 2;
        for(int i=0; i<5; i++){
            int count =0;
            if(i>0){
                for(int j=0; j<=i; j++){
                    
                    if(j==0){
                        num = num+7-i;
                    } 
                    if(j>0 ){
                        count+=j;
                    }
                    System.out.print(num-count + " ");
                    
                }
            } else{
                System.out.print(n);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        
        printPattern(2);
    }
}
