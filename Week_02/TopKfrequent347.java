import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKfrequent347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num: nums){
            int temp = map.getOrDefault(num,0);
            map.put(num,temp+1);
        }
        PriorityQueue<Integer> queue =new PriorityQueue<>( (x , y) -> map.get(y) - map.get(x) );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry.getKey());
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
