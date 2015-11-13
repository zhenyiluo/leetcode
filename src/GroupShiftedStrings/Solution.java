public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new LinkedList<>();
        if(strings == null || strings.length == 0){
            return ret;
        }
        
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for(String s : strings){
            if(hm.containsKey(s)){
                hm.put(s, hm.get(s)+1);
            }else{
                hm.put(s, 1);
            }
        }
        
        for(String s : strings){
            if(hm.containsKey(s)){
                List<String> gList = generate(s);
                List<String> tmp = new LinkedList<>();
                for(String g : gList){
                    if(hm.containsKey(g)){
                        int n = hm.get(g);
                        for(int i = 0; i < n; i++){
                            tmp.add(g);
                        }
                        hm.remove(g);
                    }
                }
                ret.add(tmp);
            }
        }
        
        for(List<String> list : ret){
            Collections.sort(list);
        }
        
        return ret;
    }
    
    private List<String> generate(String s){
        List<String> ret = new LinkedList<>();
        for(int i = 0; i < 26; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < s.length(); j++){
                int index = (s.charAt(j) - 'a' + i) % 26;
                char c = (char)(index + 'a');
                sb.append(c);
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}