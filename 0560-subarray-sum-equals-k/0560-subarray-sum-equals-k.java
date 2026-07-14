class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> subNum = new HashMap<>();
        subNum.put(0, 1);
        int total = 0, count = 0;

        for(int i=0;i<nums.length;i++){
            total += nums[i];
            int remove = total -k;
            count += subNum.getOrDefault(remove,0);
            subNum.put(total,subNum.getOrDefault(total,0)+1);
        }
        return count;
    }
}