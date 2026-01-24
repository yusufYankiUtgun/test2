import java.util.Deque;
import java.util.ArrayDeque;

public class PreviousGreaterElementProblem {
    public static int[] findPreviousGreaterElement(int[] A) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] B = new int[A.length];

        for (int i = A.length - 1; i >= 0; i--) {
            stack.push(i); //first pushing elements into stack and if there is PGA (previous greater element) they will pop

            if (i - 1 >= 0) {   //checking if all array are covered. not need to the number at index 0
                while (!stack.isEmpty() && A[i - 1] > A[stack.peekFirst()]) { //check if current number at index i - 1 bigger than the elements in stack
                    B[stack.peekFirst()] = A[i - 1]; //store the PGE related to the element at the top of stack
                    stack.pop(); // we found the PGE so we can pop the element at the top of stack
                }
            } else { //elements haven't popped yet have no PGE -1 expresses this
                while (!stack.isEmpty()) {
                    B[stack.pop()] = -1; // assign remaining element(s)'s indexes to -1 as we cannot find PGE
                 }
            }
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {10, 5, 8, 12, 11, 12, 6};

        int[] B = findPreviousGreaterElement(A);

        for (int num: B) {
            System.out.print(num + " ");
        }
    }
}

