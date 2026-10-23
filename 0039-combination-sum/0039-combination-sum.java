import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int idx = 0;
        List<Integer> diary = new ArrayList<>();
        int sum = 0;
        List<List<Integer>> res = new ArrayList<>();

        combSum(candidates, n, idx, diary, sum, target, res);
        return res;
    }

    void combSum(int[] candidates, int n, int idx, List<Integer> diary,
                 int sum, int target, List<List<Integer>> res) {

        if (idx == n) {
            if (sum == target) {
                res.add(new ArrayList<>(diary));
            }
            return;
        }

        combSum(candidates, n, idx + 1, diary, sum, target, res);

        if (candidates[idx] + sum <= target) {
            diary.add(candidates[idx]);
            sum = sum + candidates[idx];

            combSum(candidates, n, idx, diary, sum, target, res);

            diary.remove(diary.size() - 1);
            sum = sum - candidates[idx];
        }
    }
}