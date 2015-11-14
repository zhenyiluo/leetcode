public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }

        HashMap<Character, HashSet<Character>> dag = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            for(int j = 0; j < words[i].length(); j++){
                char c = words[i].charAt(j);
                if(!dag.containsKey(c)){
                    dag.put(c, new HashSet<>());
                }
            }
            if(i != 0){
                buildDAG(words[i-1], words[i], dag);
            }
        }

        return topologicalSort(dag);
    }

    private void buildDAG(String word1, String word2, HashMap<Character, HashSet<Character>> dag){
        int len1 = word1.length();
        int len2 = word2.length();
        int len = Math.min(len1, len2);
        for(int i = 0; i < len; i++){
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);
            if(c1 != c2){
                dag.get(c1).add(c2);
                return;
            }
        }
    }

    private String topologicalSort(HashMap<Character, HashSet<Character>> dag){
        Queue<Character> q = new LinkedList<>();
        HashMap<Character, Integer> indegree = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(char c1 : dag.keySet()){
            for(char c2 : dag.get(c1)){
                if(indegree.containsKey(c2)){
                    indegree.put(c2, indegree.get(c2) + 1);
                }else{
                    indegree.put(c2, 1);
                }
            }
        }

        for(char c : dag.keySet()){
            if(!indegree.containsKey(c)){
                q.add(c);
            }
        }

        while(! q.isEmpty()){
            char c = q.poll();
            sb.append(c);
            for(char neighbor : dag.get(c)){
                int val = indegree.get(neighbor);
                val --;
                if(val == 0){
                    indegree.remove(neighbor);
                    q.add(neighbor);
                }else{
                    indegree.put(neighbor, val);
                }
            }
        }

        if(!indegree.isEmpty()){
            return "";
        }

        return sb.toString();
    }
}