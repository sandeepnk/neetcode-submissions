class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq map
        Map<Integer,Integer> map = new HashMap<>();
        for(int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // min heap of size k
        Queue<Integer> pq = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));

        for(int n : map.keySet()) {
            pq.add(n);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
}