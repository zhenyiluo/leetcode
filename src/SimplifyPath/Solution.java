public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "";
        }
        
        String[] strings = path.trim().split("\\");
        
        Stack<String> st = new Stack<>();
        
        for(String s : strings){
            if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }else if(s.length() != 0){
                st.push();
            }
        }
        if(st.isEmpty()){
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append("/" + st.pop());
        }
        return sb.toString();
    }
}