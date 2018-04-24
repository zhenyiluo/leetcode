public class Solution2 {
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