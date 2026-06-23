class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0, j=1, res=1;
        int n=nums.length;
        while(j<n){
            if(nums[j]==nums[j-1]){
                j++;
                continue;
            }
            else{
                nums[i+1]=nums[j];
                i++;
                res++;
                j++;
            }
        }
        return res;
    }
}