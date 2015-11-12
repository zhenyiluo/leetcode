public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int len1 = low.length();
        int len2 = high.length();
        int ret = 0;
        if(len1 > len2){
            return 0;
        }
        for(int i = len1+1; i< len2 ; i++){
            ret += findStrobogrammatic(i).size();
        }
        
        if(len1 == len2){
            List<String> list = findStrobogrammatic(len1);
            for(String s : list){
                if(s.compareTo(low) >= 0 && s.compareTo(high) <= 0){
                    ret++;
                }
            }
            return ret;
        }
        
        List<String> list1 = findStrobogrammatic(len1);
        for(String s : list1){
            if(s.compareTo(low) >= 0){
                ret++;
            }
        }
        List<String> list2 = findStrobogrammatic(len2);
        for(String s : list2){
            if(s.compareTo(high) <= 0){
                ret++;
            }
        }
        return ret;
    }
    
    public List<String> findStrobogrammatic(int n) {
        List<String> ret = new ArrayList<String>();
        if(n <= 0){
            return ret;
        }
        int start = 1;
        if(n %2 == 0){
            ret.add("");
        }else{
            ret.add("0");
            ret.add("1");
            ret.add("8");
            start = 2;
        }
        
        for(int i= start; i <=n; i += 2){
            List<String> tmp = new ArrayList<String>();
            for(String s : ret){
                if(i+1 != n){
                    tmp.add("0" + s + "0");
                }
                tmp.add("1" + s + "1");
                tmp.add("8" + s + "8");
                tmp.add("6" + s + "9");
                tmp.add("9" + s + "6");
            }
            ret = tmp;
        }
        return ret;
    }
}