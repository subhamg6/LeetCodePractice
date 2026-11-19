class Solution {

    int countElements(int[] arr, int sum){
        int elements = 1;
        long sumElement = 0;
        for(int i = 0; i<arr.length; i++){
            if(sumElement + arr[i] <= sum){
                sumElement += arr[i];
            }
            else {
                elements += 1;
                sumElement = arr[i];
            }
        }
        return elements;
    }

    int largSum(int[] arr, int n, int m){
        if(m > n)
            return -1;
        int low = 0;
        int high = 0;
        for (int num : arr) {
            low = Math.max(low, num);
            high += num;
        }
        while(low <= high){
            int mid = low+(high-low)/2;
            int elements = countElements(arr, mid);
            if(elements > m){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

    public int splitArray(int[] nums, int k) {
        return largSum(nums, nums.length, k);
    }
}