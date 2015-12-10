public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ret = new LinkedList<>();
        if(s == null){
            return ret;
        }
        
        HashSet<String> hs = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        boolean found = false;
        q.add(s);
        hs.add(s);
        while(!q.isEmpty()){
            String tmp = q.poll();
            if(isValid(tmp)){
                found = true;
                ret.add(tmp);
            }
            
            if(found){
                continue;
            }
            
            for(int i= 0; i < tmp.length(); i++){
                if(tmp.charAt(i) == '(' || tmp.charAt(i) == ')'){
                    String ns = tmp.substring(0, i) + tmp.substring(i+1);
                    if(!hs.contains(ns)){
                        hs.add(ns);
                        q.add(ns);
                    }
                }
            }
        }
        return ret;
    }
    
    private boolean isValid(String s){
        int cnt = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                cnt ++;
            }else if(c == ')'){
                cnt --;
                if(cnt < 0){
                    return false;
                }
            }
        }
        return cnt == 0;
    }
}