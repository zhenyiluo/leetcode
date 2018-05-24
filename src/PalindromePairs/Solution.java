class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if(words == null || words.length == 0){
            return ret;
        }

        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            hm.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            for(int j = 0; j <= word.length(); j++){
                String left = word.substring(0, j);
                String right = word.substring(j);
                if(isPalindrome(left)){
                    String need = new StringBuilder(right).reverse().toString();
                    if(hm.containsKey(need) && hm.get(need) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(hm.get(need));
                        list.add(i);
                        ret.add(list);
                    }
                }
                if(isPalindrome(right) && right.length() != 0){
                    String need = new StringBuilder(left).reverse().toString();
                    if(hm.containsKey(need) && hm.get(need) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(hm.get(need));
                        ret.add(list);
                    }
                }
            }
        }
        return ret;
    }

    private boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() -1;
        while(left <= right){
            if(s.charAt(left++) != s.charAt(right--)){
                return false;
            }
        }
        return true;
    }
}