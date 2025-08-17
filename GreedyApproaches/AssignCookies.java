import java.util.Arrays;

public class AssignCookies {
    
    public static int assign(int[] cookies, int[] children){
        Arrays.sort(cookies);
        Arrays.sort(children);
        int count = 0;

        int i=0, j=0;
        
        while(i < children.length && j < cookies.length){
            if(cookies[j] >= children[i]){
                count++;
                i++;
                j++;
            } else{
                j++;
            }
        }

        return count;
    }
    public static void main(String[] args) {
        int[] cookies = {4, 2, 1, 2, 1, 3};
        int[] children = {1, 5, 3, 3, 4};

        System.out.println(assign(cookies, children));
    }
}
