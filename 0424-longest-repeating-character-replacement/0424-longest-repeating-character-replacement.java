class Solution {
    public int characterReplacement(String s, int k) {
        int low=0;
        int res=0;
        int maxc=0;
        int n = s.length();
        int[] freq = new int[256];

        for(int high =0;high<n;high++){
            char ch = s.charAt(high);
            freq[ch]++;
            maxc=Math.max(maxc,freq[ch]);
            int length=high-low+1;
            int diff = length-maxc;
            while(diff>k){
                char left = s.charAt(low);
                freq[left]--;
                low++;

                length = high-low+1;
                diff=length-maxc;
            }
            if(diff<k || diff==k){
                length=high-low+1;
                res=Math.max(res,length);
            }
        }
        return res;
    }
}