class Solution {
    public int longestOnes(int[] nums, int k) {
        int low=0,zeros=0,maxlen=0,n=nums.length;
        for(int high=0;high<n;high++){
            if(nums[high]==0)
                zeros++;
            if(zeros>k){
                if(nums[low]==0)
                    zeros--;
                low++;
            }
            if(zeros<=k){
                int len = high - low +1;
                maxlen = Math.max(maxlen,len);
            }
        }
        return maxlen;
    }
}