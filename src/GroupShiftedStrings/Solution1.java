public class Solution1 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ret = new LinkedList<>();
        if(strings == null || strings.length == 0){
            return ret;
        }
        
        HashMap<String, List<String>> hm = new HashMap<>();
        
        for(String s : strings){
            StringBuilder sb = new StringBuilder();
            int offset = s.charAt(0) - 'a';
            for(int i = 1; i < s.length(); i++){
                int related = (s.charAt(i) - 'a' - offset + 26) % 26;
                char c = (char)(related + 'a');
                sb.append(c);
            }
            String key = sb.toString();
            if(!hm.containsKey(key)){
                List<String> list = new ArrayList<>();
                hm.put(key, list);
            }
            hm.get(key).add(s);
        }
        
        for(List<String> list : hm.values()){
            Collections.sort(list);
            ret.add(list);
        }
        
        return ret;
    }
    
}