import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int len = tasks.length;

        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Integer> free = new HashMap<>();

        for (int i = 0; i < len; i++) {
            freq.put(tasks[i], freq.getOrDefault(tasks[i], 0) + 1);
            free.put(tasks[i], 1);
        }

        PriorityQueue<Map.Entry<Integer, Character>> pq =
            new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

        for (char c : freq.keySet()) {
            pq.offer(new AbstractMap.SimpleEntry<>(freq.get(c), c));
        }

        int seat = 1;
        List<Map.Entry<Integer, Character>> pulled = new ArrayList<>();

        while (!pq.isEmpty()) {
            boolean executed = false;

            while (!pq.isEmpty()) {
                Map.Entry<Integer, Character> p = pq.poll();

                int fr = p.getKey();
                char child = p.getValue();

                if (free.get(child) <= seat) {
                    if (fr > 1) {
                        pq.offer(new AbstractMap.SimpleEntry<>(fr - 1, child));
                        free.put(child, seat + n + 1);
                    }

                    seat++;
                    executed = true;
                    break;
                } else {
                    pulled.add(p);
                }
            }

            for (Map.Entry<Integer, Character> p : pulled) {
                pq.offer(p);
            }
            pulled.clear();

            if (!executed && !pq.isEmpty()) {
                seat++;
            }
        }

        return seat - 1;
    }
}