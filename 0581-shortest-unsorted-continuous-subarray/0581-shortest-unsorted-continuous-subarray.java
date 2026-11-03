class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int l=0,r=-1;
        int maxsofar=Integer.MIN_VALUE;
        int minsofar=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]>=maxsofar)maxsofar=nums[i];
            else r=i;
        }
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]<=minsofar)minsofar=nums[i];
            else l=i;
        }
        if(r==-1) return 0;
        return r-l+1;
    }
}