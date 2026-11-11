class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(int i=0; i<s1.length(); i++){
            freq[s1.charAt(i) - 'a']++;
        }
        int windSize = s1.length();
        for(int i=0; i<=s2.length() - windSize;i++){
            int windIdx=0, idx=i;
            int[] windFreq = new int[26];
            while(windIdx < windSize && idx < s2.length()){
                windFreq[s2.charAt(idx)-'a']++;
                windIdx++;
                idx++;
            }
            if(windIdx == windSize &&Arrays.equals(freq,windFreq)){
                return true;
            }
        }
        return false;
    }
}