
import java.util.*;

class Pair {
    int first;   // Required capital
    int second;  // Profit

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        List<Pair> project = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            project.add(new Pair(capital[i], profits[i]));
        }

        // Sort projects by required capital in ascending order
        project.sort((a, b) -> Integer.compare(a.first, b.first));

        // Max-heap: highest profit comes first
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b, a)
        );

        int index = 0;

        for (int count = 0; count < k; count++) {

            // Add all affordable projects to the heap
            while (index < n && project.get(index).first <= w) {
                pq.offer(project.get(index).second);
                index++;
            }

            // No affordable project remains
            if (pq.isEmpty()) {
                return w;
            }

            // Select the project with maximum profit
            w += pq.poll();
        }

        return w;
    }
}
