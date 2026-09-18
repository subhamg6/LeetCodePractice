class Solution {
    int first(int[] arr,int x){
        int n=arr.length;
        int low=0,high=n-1;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(arr[guess]<x)
                low=guess+1;
            else if(arr[guess]>x)
                high=guess-1;
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
    int last(int[] arr,int x){
        int n=arr.length;
        int low=0,high=n-1;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            if(arr[guess]<x)
                low=guess+1;
            else if(arr[guess]>x)
                high=guess-1;
            else{
                res=guess;
                low=guess+1;
            }
        }
        return res;
    } 


    public int[] searchRange(int[] nums, int target) {
        int a,b;
        a=first(nums,target);
        b=last(nums,target);
        return new int[]{a, b};
        
    }
}