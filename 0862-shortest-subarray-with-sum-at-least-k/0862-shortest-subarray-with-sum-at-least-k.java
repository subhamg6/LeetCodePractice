class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        Deque<Integer> deq = new ArrayDeque<>();

        long[] cumulativeSum = new long[n + 1];

        int result = Integer.MAX_VALUE;

        for (int j = 0; j < n; j++) {

            cumulativeSum[j + 1] = cumulativeSum[j] + nums[j];

            // Check subarray starting from index 0
            if (cumulativeSum[j + 1] >= k) {
                result = Math.min(result, j + 1);
            }

            // Remove elements from front
            while (!deq.isEmpty() &&
                   cumulativeSum[j + 1] - cumulativeSum[deq.peekFirst()] >= k) {

                result = Math.min(result, j + 1 - deq.peekFirst());

                deq.pollFirst();
            }

            // Maintain increasing prefix sums
            while (!deq.isEmpty() &&
                   cumulativeSum[j + 1] <= cumulativeSum[deq.peekLast()]) {

                deq.pollLast();
            }

            deq.offerLast(j + 1);
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}