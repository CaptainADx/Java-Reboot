public class Brackets {
    synchronized public void printBrackets(char open, char close){  //Syncronized keyword used to prevent the ambiguity
        for (int i = 0; i < 10; i++) {
            if(i<5 ){
                System.out.print(open);
            } else{
                System.out.print(close);
            }
        }
        System.out.println();
    }
}
