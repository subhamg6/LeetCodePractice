class Solution {
    int fun(int[][] a, int n, int m, int guess){
        int r=n-1, c=0;
        int count=0;
        while(r>=0 && c<m){
            if(a[r][c]<=guess){
                count= count+r+1;
                c++;
            }
            else
                r--;
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        int m=matrix[0].length;
        int low=matrix[0][0], high=matrix[n-1][m-1];
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            int ans = fun(matrix, n, m, guess);
            if(ans<k)
                low=guess+1;
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;

    }
}