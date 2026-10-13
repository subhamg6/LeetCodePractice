import java.util.*;

class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        int leader = -1;
        result.add(leader);

        for (int i = n - 1; i >= 1; i--) {
            if (arr[i] > leader) {
                leader = arr[i];
            }
            result.add(leader);
        }

        Collections.reverse(result);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}