class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i;
        for(i=0;i<k;i++)
            pq.offer(nums[i]);
        for(i=k;i<n;i++){
            if(nums[i]<=pq.peek())
                continue;
            pq.poll();
            pq.offer(nums[i]);
        }
        return pq.peek();
    }
}