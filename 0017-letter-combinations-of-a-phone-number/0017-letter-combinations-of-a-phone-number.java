class Solution {
    HashMap<Character, String> f = new HashMap<>();
    public List<String> letterCombinations(String digits) {
        f.put('2',"abc");
        f.put('3',"def");
        f.put('4',"ghi");
        f.put('5',"jkl");
        f.put('6',"mno");
        f.put('7',"pqrs");
        f.put('8',"tuv");
        f.put('9',"wxyz");

        int n = digits.length();
        int idx = 0;
        String diary = "";
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) return res;

        lettComb(digits, n, idx, diary, res);
        return res;
    }
    void lettComb(String digits, int n, int idx, String diary, List<String> res){
        if(idx == n){
            res.add(diary);
            return;
        }

        String choice = f.get(digits.charAt(idx));

        for(int j=0; j< choice.length(); j++){
            lettComb(digits, n, idx+1, diary + choice.charAt(j), res);
        }
    }
}