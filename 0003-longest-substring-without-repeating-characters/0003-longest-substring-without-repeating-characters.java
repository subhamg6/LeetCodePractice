class Solution {
    public int lengthOfLongestSubstring(String s) {
         int n = s.length();
        int left = 0, maxLength=0;
        Map<Character, Integer> lastIndex = new HashMap<>();
        for(int right=0; right<n;right++){
            char c = s.charAt(right);
            if(lastIndex.containsKey(c)){
                left=Math.max(left,lastIndex.get(c)+1);
            }
            lastIndex.put(c,right);
            int len=right-left+1;
            maxLength=Math.max(maxLength, len);
        }
        return maxLength;
    }
}