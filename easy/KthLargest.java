import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();

        // Initial numbers add karo
        for (int num : nums) {
            pq.offer(num);

            // Sirf k largest elements rakho
            if (pq.size() > k) {
                pq.poll();
            }
        }
    }

    public int add(int val) {
        pq.offer(val);

        // k se zyada elements ho gaye
        if (pq.size() > k) {
            pq.poll();
        }

        // k-th largest
        return pq.peek();
    }
} 
