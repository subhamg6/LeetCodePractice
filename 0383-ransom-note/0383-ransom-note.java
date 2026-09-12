class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> have = new HashMap<>();
        HashMap<Character, Integer> need = new HashMap<>();
        for(int i=0; i<ransomNote.length();i++){
            need.put(ransomNote.charAt(i), need.getOrDefault(ransomNote.charAt(i),0)+1);
        }
        for(int i=0; i<magazine.length();i++){
            have.put(magazine.charAt(i), have.getOrDefault(magazine.charAt(i),0)+1);
        }
        return check(have, need);
    }
    public boolean check(HashMap<Character, Integer> have, HashMap<Character, Integer> need){
        for(var i:need.entrySet()){
            char c = i.getKey();
            int fneed = i.getValue();
            int fhave = have.getOrDefault(c,0);
            if(fhave<fneed)
                return false;
        }
        return true;
    }
}