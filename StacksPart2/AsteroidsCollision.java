import java.util.Stack;
public class AsteroidsCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<n; i++){

            boolean isAlive = true;  //Using this flag to check if the incoming asteroid blast or still alive
             
            while(!s.isEmpty() && s.peek() > 0 && asteroids[i]<0){

                //CASE 1 : if Incoming Asteroid is smaller
                if(s.peek() > Math.abs(asteroids[i])){
                    isAlive = false;
                    break;
                } 
                //CASE 2 : if both asteroids are of same size
                else if(s.peek() == Math.abs(asteroids[i])){
                    isAlive = false;
                    s.pop();
                    break;
                } 
                //CASE 3 : if Incoming asteroid is bigger ()
                else if(s.peek() < Math.abs(asteroids[i])){
                    s.pop();
                }
            }

            //If the asteroid didn't blast then put this to the stack.
            if(isAlive){
                s.push(asteroids[i]);
            }
        }

        //Now pop the elements from the stack and create and array, Finally return that.
        int[] res = new int[s.size()];
        for(int i=res.length-1; i>=0; i--){
            res[i] = s.pop();
        }                   
        return res;
    }

    public static void main(String[] args){
        int[] asteroids = {10, 8, -10, 4, 5, 20, -10};  //Asteroids Array...

        int[] result_after_collision = asteroidCollision(asteroids);  //Storing the array result

        for(int i=0; i<result_after_collision.length; i++){
            System.out.println(result_after_collision[i]);
        }

    }
}
