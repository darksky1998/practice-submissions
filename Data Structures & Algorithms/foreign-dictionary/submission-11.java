class Solution {
    Map<Character, Set<Character>> map = new HashMap<>();
    Map<Character,Boolean> visited = new HashMap<>();
    ArrayList<Character> res = new ArrayList<>();
    public String foreignDictionary(String[] words) {
      for(String w : words){
        char[] ws = w.toCharArray();
        for(char c : ws){
            map.put(c,new HashSet<>());
        }
      }
      for(int i = 0 ;i<words.length-1;i++){
        int minLen = Math.min(words[i].length(),words[i+1].length());
        if(words[i].length()>words[i+1].length() && words[i].substring(0,minLen).equals(words[i+1].substring(0,minLen))){
            return "";
        }
        for(int j = 0;j<minLen;j++){
            if(words[i].charAt(j)!=words[i+1].charAt(j)){
                map.get(words[i].charAt(j)).add(words[i+1].charAt(j));
                break;
            }
        }
      }
        for(Character cv : map.keySet()){
            if(dfs(cv))
                return "";
        }
        Collections.reverse(res);
        StringBuilder sb = new StringBuilder();
        for(Character cc : res){
            sb.append(cc);
        }
      return sb.toString();
    }

    boolean dfs(Character c){
        if(visited.containsKey(c)){
            return visited.get(c);
        }
        visited.put(c,true);
        for(Character adj : map.get(c)){
            if(dfs(adj)){
                return true;
            }
        }
        res.add(c);
        visited.put(c,false);
        return false;
    }

}
