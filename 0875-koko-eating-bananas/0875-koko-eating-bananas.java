class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int low=1, high=Arrays.stream(piles).max().getAsInt();
        int res=-1;
        while(low<=high){
            int guess = (low+high)/2;
            long hour = temp(piles,n,guess);
            if(hour>h)
                low=guess+1;
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
    long temp(int[] a, int n, int speed){
        long h=0;
        for(int i=0;i<n;i++){
            h=h+a[i]/speed;
            if(a[i]%speed != 0)
                h++;
        }
        return h;
    }
}