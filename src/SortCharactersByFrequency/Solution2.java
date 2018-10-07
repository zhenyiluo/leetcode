class Solution {
    public String frequencySort(String s) {
        if(s == null || s.length() <= 1) return s;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0 ;i < s.length(); i++){
            char c = s.charAt(i);
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        ArrayList<Element> list = new ArrayList<>();
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            list.add(new Element(entry.getKey(), entry.getValue()));
        }
        Collections.sort(list, (a, b) -> (b.cnt - a.cnt));
        StringBuilder sb = new StringBuilder();
        for(Element e: list){
            for(int i = 0; i < e.cnt; i++){
                sb.append(e.c);
            }
        }
        return sb.toString();
    }
}
class Element{
    char c;
    int cnt;
    public Element(char c, int cnt){
        this.c = c;
        this.cnt = cnt;
    }
}