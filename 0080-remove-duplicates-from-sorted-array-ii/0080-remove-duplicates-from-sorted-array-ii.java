class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n<3)
            return n;
        int s = 2, f = 2;
        while(f<n){
            if(nums[f] != nums[s-2])
                nums[s++] = nums[f];
            f++;
        }
        return s;
    }
}