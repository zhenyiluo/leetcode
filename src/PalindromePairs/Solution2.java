class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ret = new ArrayList<>();
        if(words == null || words.length == 0) return ret;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            hm.put(words[i], i);
        }

        for(int i = 0; i < words.length; i++){
            String word = words[i];
            List<String[]> list = generate(word);
            for(String[] pair: list){
                if(hm.containsKey(pair[0])){
                    if(hm.get(pair[0]) == i) continue;
                    List<Integer> tmp = new ArrayList<>();
                    if(pair[1].equals("left")){
                        tmp.add(hm.get(pair[0]));
                        tmp.add(i);
                    }else if(pair[1].equals("right")){
                        tmp.add(i);
                        tmp.add(hm.get(pair[0]));
                    }else{
                        tmp.add(i);
                        tmp.add(hm.get(pair[0]));
                        ret.add(tmp);
                        tmp = new ArrayList<>();
                        tmp.add(hm.get(pair[0]));
                        tmp.add(i);
                    }
                    ret.add(tmp);
                }
            }
        }
        return ret;
    }

    private List<String[]> generate(String word){
        List<String[]> ret = new ArrayList<>();
        if(word == null || word.length() == 0) return ret;
        for(int i = 0; i < word.length(); i++){
            int left = i - 1;
            int right = i;
            boolean flag = true;
            while(left >= 0 && right < word.length()){
                if(word.charAt(left) != word.charAt(right)){
                    flag = false;
                    break;
                }
                left --;
                right ++;
            }
            if(flag){
                String[] ss = new String[2];
                if(left < 0 && right < word.length()){
                    ss[0] = new StringBuilder(word.substring(right)).reverse().toString();
                    ss[1] = "left";
                }else if(right >= word.length() && left >= 0){
                    ss[0] = new StringBuilder(word.substring(0, left + 1)).reverse().toString();
                    ss[1] = "right";
                }else if(left < 0 && right >= word.length()){
                    ss[0] = "";
                    ss[1] = "other";
                }
                ret.add(ss);
            }

            left = i -1;
            right = i + 1;
            flag = true;
            while(left >= 0 && right < word.length()){
                if(word.charAt(left) != word.charAt(right)){
                    flag = false;
                    break;
                }
                left --;
                right ++;
            }
            if(flag){
                String[] ss = new String[2];
                if(left < 0 && right < word.length()){
                    ss[0] = new StringBuilder(word.substring(right)).reverse().toString();
                    ss[1] = "left";
                }else if(right >= word.length() && left >= 0){
                    ss[0] = new StringBuilder(word.substring(0, left + 1)).reverse().toString();
                    ss[1] = "right";
                }else if(left < 0 && right >= word.length()){
                    ss[0] = "";
                    ss[1] = "other";
                }
                ret.add(ss);
            }
        }
        return ret;
    }
}