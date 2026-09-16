class KthLargest {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int len = 0;
    public KthLargest(int k, int[] nums) {
        len =k;
        for(int n: nums){
            pq.offer(n);
        }
        while(pq.size()>len){
            pq.poll();
        }
        //System.out.println(nums +" "+pq);
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>len){
            pq.poll();
        }
        return pq.peek();
    }
}
