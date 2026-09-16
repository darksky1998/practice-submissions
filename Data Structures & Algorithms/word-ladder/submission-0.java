class Solution {
    Map<String, List<String>> adjMap = new HashMap<>();
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1, word.length());
                List<String> cur = adjMap.getOrDefault(pattern, new ArrayList<>());
                cur.add(word);
                adjMap.put(pattern, cur);
            }
        }
        HashSet<String> visit = new HashSet<>();
        Deque<String> dq = new ArrayDeque<>();
        int res = 1;
        dq.addLast(beginWord);
        visit.add(beginWord);
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                String cur = dq.removeFirst();
                if (cur.equals(endWord)) {
                    return res;
                }
                for (int j = 0; j < cur.length(); j++) {
                    String pattern = cur.substring(0, j) + "*" + cur.substring(j + 1, cur.length());
                    List<String> neighbors = adjMap.get(pattern);
                    for (String n : neighbors) {
                        if (!visit.contains(n)) {
                            dq.addLast(n);
                            visit.add(n);
                        }
                    }
                }
            }
            res+=1;
        }
        return 0;
    }
}
