
import java.util.*;

class Pair {
    Integer first;
    Character second;

    Pair(Integer first, Character second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public String reorganizeString(String s) {

        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(
            (a, b) -> {
                if (!a.first.equals(b.first)) {
                    return b.first - a.first;
                }
                return a.second.compareTo(b.second);
            }
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new Pair(freq[i], (char) ('a' + i)));
            }
        }

        StringBuilder res = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            if (res.length() == 0 ||
                res.charAt(res.length() - 1) != p.second) {

                res.append(p.second);
                p.first--;

                if (p.first > 0) {
                    pq.offer(p);
                }

            } else {
                if (pq.isEmpty()) {
                    return "";
                }

                Pair p2 = pq.poll();

                res.append(p2.second);
                p2.first--;

                if (p2.first > 0) {
                    pq.offer(p2);
                }

                pq.offer(p);
            }
        }

        return res.toString();
    }
}
