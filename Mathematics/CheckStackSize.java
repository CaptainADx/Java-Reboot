public class CheckStackSize {
    static int depth = 0;

    public static void recursiveCall() {
        depth++;
        recursiveCall(); // Keep calling recursively to cause StackOverflowError
    }

    public static void main(String[] args) {
        try {
            recursiveCall();
        } catch (StackOverflowError e) {
            System.out.println("Estimated maximum call stack depth: " + depth);
        }
    }

}
