class Solution {

    public int countRangeSum(int[] nums, int lower, int upper) {

        int n = nums.length;

        long[] prefix = new long[n + 1];

        // Step 1: Calculate prefix sum
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Step 2: Apply merge sort
        return mergeSort(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSort(long[] prefix, int left, int right,
                           int lower, int upper) {

        if (right - left <= 1) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;

        count += mergeSort(prefix, left, mid, lower, upper);
        count += mergeSort(prefix, mid, right, lower, upper);

        int j = mid;
        int k = mid;

        // Count valid range sums
        for (int i = left; i < mid; i++) {

            while (j < right && prefix[j] - prefix[i] < lower) {
                j++;
            }

            while (k < right && prefix[k] - prefix[i] <= upper) {
                k++;
            }

            count += k - j;
        }

        // Merge two sorted halves
        long[] temp = new long[right - left];

        int i = left;
        j = mid;
        k = 0;

        while (i < mid && j < right) {
            if (prefix[i] <= prefix[j]) {
                temp[k++] = prefix[i++];
            } else {
                temp[k++] = prefix[j++];
            }
        }

        while (i < mid) {
            temp[k++] = prefix[i++];
        }

        while (j < right) {
            temp[k++] = prefix[j++];
        }

        for (i = 0; i < temp.length; i++) {
            prefix[left + i] = temp[i];
        }

        return count;
    }
}