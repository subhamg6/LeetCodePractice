class Solution {
    public int firstUniqChar(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i;
        for(i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(i=0;i<n;i++){
            if(map.get(s.charAt(i))==1)
                return i;
        }
        return -1;
    }
}