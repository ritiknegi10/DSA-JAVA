// Question Link
//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {

    public static List<Long> printFirstNegativeInteger(long[] A, long N, long K) {
        List<Long> result = new ArrayList<>();
        Deque<Long> deq = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            if (A[i] < 0)
                deq.addLast(i);
        }

        for (int i = (int) K; i < N; i++) {
            if (!deq.isEmpty()) {
                result.add(A[deq.peekFirst()]);
            } else {
                result.add(0L);
            }

            while (!deq.isEmpty() && deq.peekFirst() < i - K + 1) {
                deq.removeFirst();
            }

            if (A[i] < 0)
                deq.addLast((long) i);
        }

        if (!deq.isEmpty())
            result.add(A[deq.peekFirst()]);
        else
            result.add(0L);

        return result;
    }

    public static void main(String[] args) {
        long[] arr = {-8, 2, 3, -6, 10};
        long N = arr.length;
        long K = 2;
        List<Long> result = printFirstNegativeInteger(arr, N, K);
        System.out.println(result); // Output: [-8, -6, -6]
    }
}
