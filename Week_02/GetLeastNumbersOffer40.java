import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class GetLeastNumbersOffer40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }
        if(queue.isEmpty()){
            return new int[]{};
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
