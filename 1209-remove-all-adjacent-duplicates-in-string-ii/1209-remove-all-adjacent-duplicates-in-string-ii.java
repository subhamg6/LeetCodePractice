import java.util.Stack;

class Solution {
    public String removeDuplicates(String s, int k) {

        int n = s.length();

        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            char c = s.charAt(i);

            // If stack is empty
            if (st.empty()) {
                st.push(new Pair(c, 1));
                continue;
            }

            // If top character is different
            if (st.peek().ch != c) {
                st.push(new Pair(c, 1));
                continue;
            }

            // Same character
            if (st.peek().count < k - 1) {
                Pair p = st.pop();
                st.push(new Pair(p.ch, p.count + 1));
                continue;
            }

            // Count reached k
            st.pop();
        }

        StringBuilder res = new StringBuilder();

        while (!st.empty()) {

            Pair p = st.pop();

            while (p.count > 0) {
                res.append(p.ch);
                p.count--;
            }
        }

        return res.reverse().toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}