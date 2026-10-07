import java.util.*;

class Pair {
    Integer first;   // frequency
    String second;   // word

    Pair(Integer first, String second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {

                // Lower frequency comes first
                if (!a.first.equals(b.first))
                    return a.first - b.first;

                // If frequency is same,
                // lexicographically larger word comes first
                return b.second.compareTo(a.second);
            }
        );

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Put words into heap
        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            String word = entry.getKey();
            int freq = entry.getValue();

            Pair curr = new Pair(freq, word);

            if (pq.size() < k) {
                pq.offer(curr);
                continue;
            }

            // If current word is better than heap top
            if (curr.first > pq.peek().first ||
                (curr.first.equals(pq.peek().first) &&
                 curr.second.compareTo(pq.peek().second) < 0)) {

                pq.poll();
                pq.offer(curr);
            }
        }

        // Extract result
        List<String> res = new ArrayList<>();

        while (!pq.isEmpty()) {
            res.add(pq.poll().second);
        }

        // Heap gives least desirable → most desirable,
        // so reverse it.
        Collections.reverse(res);

        return res;
    }
}