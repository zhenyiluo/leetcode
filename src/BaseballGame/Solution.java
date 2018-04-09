class Solution {
    public int calPoints(String[] ops) {
        if(ops == null || ops.length == 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(String op: ops){
            switch (op) {
                case "+" : list.add(list.get(list.size() -1) + list.get(list.size() -2)); break;
                case "D" : list.add(2 * list.get(list.size() -1)); break;
                case "C" : list.remove(list.size() -1); break;
                default : list.add(Integer.valueOf(op)); break;
            }
        }
        int ret = 0;
        for(int val: list){
            ret += val;
        }
        return ret;
    }
}