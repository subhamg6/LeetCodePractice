import java.util.*;

class Pair {
    Integer first;
    Integer second;

    Pair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a.first != b.first)
                    return a.first - b.first;
                return a.second.compareTo(b.second);
            }
        );

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            int element = i.getKey();
            int freq = i.getValue();

            Pair curr = new Pair(freq, element);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            if (curr.first < pq.peek().first)
                continue;

            pq.poll();
            pq.offer(curr);
        }

        int[] res = new int[k];
        int index = 0;

        while (!pq.isEmpty()) {
            res[index++] = pq.peek().second;
            pq.poll();
        }

        return res;
    }
}
