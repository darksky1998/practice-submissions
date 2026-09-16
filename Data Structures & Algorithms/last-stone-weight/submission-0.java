class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone : stones){
            pq.add(stone);
        }
        //System.out.println(pq);
        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            //System.out.println(x +" "+y+" "+pq);
            if(x==y){
                continue;
            }
            if(x>y){
                pq.add(x-y);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        return pq.poll();
    }
}
