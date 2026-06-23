class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int left = 0, res = 0;
        Map<Integer, Integer> freq = new HashMap<>();

        for (int right = 0; right < n; right++) {
            freq.put(fruits[right],
                     freq.getOrDefault(fruits[right], 0) + 1);

            while (freq.size() > 2) {
                freq.put(fruits[left],
                         freq.get(fruits[left]) - 1);

                if (freq.get(fruits[left]) == 0) {
                    freq.remove(fruits[left]);
                }
                left++;
            }

            // Window is valid (contains at most 2 types)
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}