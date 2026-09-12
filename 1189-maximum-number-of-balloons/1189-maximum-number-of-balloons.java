class Solution {
    public int maxNumberOfBalloons(String text) {
        int n = text.length();
        HashMap<Character, Integer> have = new HashMap<>();
        for(int i=0; i<n;i++){
            have.put(text.charAt(i), have.getOrDefault(text.charAt(i),0)+1);
        }
        HashMap<Character,Integer> need = new HashMap<>();
        need.put('b',1);
        need.put('a',1);
        need.put('l',2);
        need.put('o',2);
        need.put('n',1);
        int res = Integer.MAX_VALUE;
        for(var i:need.entrySet()){
            char c = i.getKey();
            int fneed = i.getValue();
            int fhave = have.getOrDefault(c,0);
            int times = fhave/fneed;
            res = Math.min(res,times);
        }
        return res;
    }
}