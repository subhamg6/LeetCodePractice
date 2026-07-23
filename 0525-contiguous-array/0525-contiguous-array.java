class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length, zero=0, one=0, res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            if(nums[i]==0)
                zero++;
            else
                one++;
            
            int diff = zero -one;

            if(diff == 0){
                res=Math.max(res, i+1);
            }
            if(!map.containsKey(diff)){
                map.put(diff,i);
            }
            else{
                int index = map.get(diff);
                int len = i - index;
                res = Math.max(len,res);
            }
        }
        return res;
    }
}