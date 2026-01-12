public class StackUsingArrays {

    static class Stack {
        int[] arr;
        int top;
        int size;

        // Constructor
        Stack(int size) {
            this.size = size;
            arr = new int[size];
            top = -1;
        }

        // Check if stack is empty
        boolean isEmpty() {
            return top == -1;
        }

        // Push operation
        void push(int data) {
            if (top == size - 1) {
                System.out.println("Stack Overflow");
                return;
            }
            top++;
            arr[top] = data;
        }

        // Pop operation (logical + physical removal)
        int pop() {
            if (isEmpty()) {
                System.out.println("Stack Underflow");
                return -1;
            }

            int value = arr[top];
            arr[top] = 0;   // physically clear (optional but now intentional)
            top--;          // logical removal
            return value;
        }

        // Peek operation
        int peek() {
            if (isEmpty()) {
                return -1;
            }
            return arr[top];
        }
    }

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }

    }
}
