public class Solution {
    HashMap<String, List<Integer>> hm = new HashMap<String, List<Integer>>();
    public List<Integer> diffWaysToCompute(String input) {
        if(hm.containsKey(input)){
            return hm.get(input);
        }
        List<Integer> ret = new LinkedList<Integer>();
        if(input == null || input.length() == 0){
            hm.put(input, ret);
            return ret;
        }
        if(input.contains("+") || input.contains("-") || input.contains("*")){
            for(int i = 0; i < input.length(); i++){
                char c = input.charAt(i);
                if(c != '+' && c != '-' && c != '*'){
                    continue;
                }
                List<Integer> list1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> list2 = diffWaysToCompute(input.substring(i+1));
                for(int n1: list1){
                    for(int n2 : list2){
                        if(c == '+'){
                            ret.add(n1 + n2);
                        }else if(c == '-'){
                            ret.add(n1 - n2);
                        }else{
                            ret.add(n1 * n2);
                        }
                    }
                }
            }
        }else{
            ret.add(Integer.valueOf(input));
        }
        hm.put(input, ret);
        return ret;
    }
}