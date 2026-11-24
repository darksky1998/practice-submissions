class RandomizedSet {
    Map<Integer,Integer> hmap;
    List<Integer> alist;
    Random random;

    public RandomizedSet() {
        hmap = new HashMap<>();
        alist = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(hmap.containsKey(val)) return false;
        hmap.put(val,alist.size());
        alist.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hmap.containsKey(val)) return false;
        int idx = hmap.get(val);
        int last = alist.get(alist.size()-1);
        hmap.put(last,idx);
        alist.set(idx,last);
        hmap.remove(val);
        alist.remove(alist.size()-1);
        return true;
    }
    
    public int getRandom() {
        return alist.get(random.nextInt(alist.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */