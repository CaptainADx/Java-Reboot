public class LemonadeChange {
    // In this problem we have 3 currencies  $5, $10 and $20.
    // We are starting with $0 with us and keep collecting change from customers.
    // Each Lemonade costs $5.

    // For Example :- 
    // If a customer comes with $10 we can only give him lemonade if :- 
    //      --> We have atleast one $5 already with us.
    //      --> otherwise reject.

    public static boolean canServeAllCustomers(int[] bills){
        
        int five = 0, ten = 0;   // we are not considering $20 coz we don't need to return $20

        for(int i=0; i<bills.length; i++){
            switch (bills[i]) {

                case 5 -> {
                    five++;
                }
                
                case 10 -> {
                    if(five >= 1){
                        five--;
                        ten++;
                    } else {
                        return false;
                    }
                }
                
                default -> {
                    if(ten >= 1 && five>=1){
                        ten--;
                        five--;
                    }
                    else if(five >= 3){
                        five -=3;
                    }
                    else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] bills = {5, 5, 5, 10, 20, 20};

        System.out.println(canServeAllCustomers(bills));
    }
}
