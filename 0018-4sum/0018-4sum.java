class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> hs = new HashSet<>();
        for(int i=0; i<nums.length-3; i++){
            for(int j=i+1; j<nums.length; j++){
                int k=j+1;
                int l=nums.length-1;
                while(k<l){
                    long sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum<target) k++;
                    else if(sum>target) l--;
                    else{
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        tempList.add(nums[l]);
                        hs.add(tempList);
                        k++;
                        l--;
                    }
                }
            }
           
        }
        List<List<Integer>> ans = new ArrayList<>(hs);
        return ans;
    }
}