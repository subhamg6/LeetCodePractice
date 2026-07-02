class Solution {
    public int maximumSum(int[] arr) {
        int n = arr.length;
        int i, power = 0, noPower = arr[0], res=arr[0];
        for(i=1;i<n;i++){
            int v1 = arr[i];
            int v2 = noPower + arr[i];
            int v3 = power + arr[i];
            int v4 = noPower;
            
            noPower = Math.max(v1, v2);
            power = Math.max(v3,v4);
            res = Math.max(res,Math.max(noPower, power));
        }
        return res;
    }
}