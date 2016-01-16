public class Solution {
    public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null || dict == null || start.length() == 0 || end.length() == 0 || dict.size() == 0){
            return 0;
        }
        dict.add(end);
        Queue<Element> q = new LinkedList<Element>();
        q.add(new Element(start, 1));
        while(!q.isEmpty()){
            Element e = q.poll();
            if(e.str.equals(end)){
                return e.level;
            }
            int len = e.str.length();
            for(int i = 0; i < len; i++){
                StringBuilder sb = new StringBuilder(e.str);
                for(char c = 'a' ; c <= 'z'; c++){
                    if(c != e.str.charAt(i)){
                        sb.setCharAt(i, c);
                        if(dict.contains(sb.toString())){
                            q.add(new Element(sb.toString(), e.level+1));
                            dict.remove(sb.toString());
                        }
                    }
                }
            }
        }
        return 0;
    }
}
class Element{
    int level;
    String str;
    public Element(String str, int level){
        this.level = level;
        this.str = str;
    }
}