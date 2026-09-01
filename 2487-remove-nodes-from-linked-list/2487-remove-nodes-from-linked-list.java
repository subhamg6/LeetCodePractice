class Solution {
    public ListNode removeNodes(ListNode head) {

        Stack<ListNode> st = new Stack<>();

        ListNode curr = head;

        while (curr != null) {

            while (!st.isEmpty() && st.peek().val < curr.val) {
                st.pop();
            }

            st.push(curr);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (ListNode node : st) {
            temp.next = node;
            temp = temp.next;
        }

        temp.next = null;

        return dummy.next;
    }
}