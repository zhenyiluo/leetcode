public class ValidWordAbbr {
    HashMap<String, String> hm;
    public ValidWordAbbr(String[] dictionary) {
        hm = new HashMap<>();
        if(dictionary != null){
            for(String s : dictionary){
                String key = getKey(s);
                if(hm.containsKey(key) && s.length() > 2){
                    hm.put(key, "");
                }else{
                    hm.put(key, s);
                }
            }
        }
    }

    public boolean isUnique(String word) {
        String key = getKey(word);
        return !hm.containsKey(key) || hm.get(key).equals(word);
    }
    
    private String getKey(String s){
        String key = s;
        if(key.length() <= 2){
            return key;
        }
        
        return "" + key.charAt(0) + (key.length()-2) + key.charAt(key.length()-1); 
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");