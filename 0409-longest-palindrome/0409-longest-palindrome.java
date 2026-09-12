class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        HashMap<Character, Integer> f = new HashMap<>();
        for(int i=0; i<n; i++){
            f.put(s.charAt(i),f.getOrDefault(s.charAt(i),0)+1);
        }
        boolean odd = false;
        int res=0;
        for(var i:f.entrySet()){
            int val = i.getValue();
            if(val%2==0)
                res += val;
            else
                odd=true;
        }
        for(var i:f.entrySet()){
            int val = i.getValue();
            if(val%2==1)
                res+=val-1;
        }
        return odd ? res + 1 : res;
    }
}