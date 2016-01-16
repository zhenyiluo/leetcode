public class Solution{
    public List<List<String>> findLadders(String start, String end, Set<String> dict){
        List<List<String>> ret = new LinkedList<>();
        dict.add(end);
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(1, null, start));
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unVisited = new HashSet<>(dict);
        
        int min = 0;
        int pre = 0;
        while(!q.isEmpty()){
            Element e = q.poll();
            int cur = e.step;
            String curStr = e.str;
            if(curStr.equals(end)){
                if(min == 0){
                    min = cur;
                }
                
                if(min != 0 && cur == min){
                    List<String> list = new LinkedList<>();
                    list.add(e.str);
                    while(e.prev != null){
                        e = e.prev;
                        list.add(0, e.str);
                    }
                    ret.add(list);
                }
                continue;
            }
            
            if(pre < cur){
                unVisited.removeAll(visited);
            }
            pre = cur;
            
            char[] chArr = curStr.toCharArray();
            for(int i= 0; i < chArr.length; i++){
                char tmp = chArr[i];
                for(char c = 'a'; c <= 'z'; c++){
                    chArr[i] = c;
                    String s = new String(chArr);
                    if(unVisited.contains(s)){
                        visited.add(s);
                        q.add(new Element(cur+1, e, s));
                    }
                }
                chArr[i] = tmp;
            }
        }
        return ret;
    }
}

class Element{
    int step;
    Element prev;
    String str;
    public Element(int step, Element prev, String str){
        this.step = step;
        this.prev = prev;
        this.str = str;
    }
}