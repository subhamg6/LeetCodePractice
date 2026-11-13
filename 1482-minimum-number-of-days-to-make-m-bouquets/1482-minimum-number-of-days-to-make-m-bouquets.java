class Solution {
    public int minDays(int[] bloomDay, int m, int k) {

        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        int ans=-1;
        int n = bloomDay.length;

        if(n<m*k)
            return -1;

        while(low<=high){
            int mid = (low+high)/2;

            if(poss(bloomDay, mid, m, k)){
                ans=mid;
                high = mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
    public boolean poss(int[] arr,int day,int m, int k){

        int n=arr.length;
        int count=0, noOfB=0;

        for(int i=0;i<n;i++){

            if(arr[i]<=day){
                count++;

                if (count == k) {
                    noOfB++;
                    count = 0;
                }
            } else{
                count=0;
            }
        }
        return noOfB >= m;
    }
}