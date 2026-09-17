class Solution {
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(a->a[0]));
    public int[][] kClosest(int[][] points, int k) {
        
        for(int[] point : points){
            int dist =(point[0]*point[0])+(point[1]*point[1]);
            pq.offer(new int[]{dist,point[0],point[1]});
        }
        int[][] res = new int[k][2];
        for(int i = 0; i<k;i++){
            int[] cur = pq.poll();
            res[i]=new int[]{cur[1],cur[2]};
        }
        return res;
    }
}
