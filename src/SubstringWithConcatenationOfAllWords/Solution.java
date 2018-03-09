class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        final HashMap<String, Integer> count = new HashMap<>();
        for(String word: words){
            count.put(word, count.getOrDefault(word, 0) + 1);
        }

        final List<Integer> indexes = new LinkedList<>();

        final int n = s.length();
        final int num = words.length;
        final int len = words[0].length();

        for(int i = 0; i <= n - num * len; i++){
            final HashMap<String, Integer> seen = new HashMap<>();
            int j = 0;
            while(j < num){
                final String word = s.substring(i + j * len, i + (j+1)*len);
                if(count.containsKey(word)){
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    if(seen.get(word) > count.get(word)){
                        break;
                    }
                }else{
                    break;
                }
                j++;
            }
            if(j == num){
                indexes.add(i);
            }
        }
        return indexes;
    }
}