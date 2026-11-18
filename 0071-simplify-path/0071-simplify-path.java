
class Solution {
    public String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        String cur = "";

        for (char c : (path + "/").toCharArray()) {

            if (c == '/') {

                if (cur.equals("..")) {

                    if (!stack.isEmpty()) {
                        stack.pop();
                    }

                } else if (!cur.equals("") && !cur.equals(".")) {

                    stack.push(cur);
                }

                cur = "";

            } else {
                cur += c;
            }
        }

        return "/" + String.join("/", stack);
    }
}
