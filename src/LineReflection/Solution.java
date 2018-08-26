class Solution {
    public boolean isReflected(int[][] points) {
        if(points == null || points.length <= 1) return true;
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int[] point : points){
            if(!hm.containsKey(point[0])){
                hm.put(point[0], new HashSet<>());
            }
            hm.get(point[0]).add(point[1]);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int key: hm.keySet()){
            list.add(key);
        }
        Collections.sort(list);
        int sum = -1;
        while(list.size() >= 2){
            int first = list.remove(0);
            int last = list.remove(list.size()-1);
            int tmp = first + last;
            if(sum != -1 && sum != tmp){
                return false;
            }else if(sum == -1){
                sum = tmp;
            }
            if(!hm.get(first).equals(hm.get(last))) return false;
        }
        if(list.size() == 1){
            if(sum != -1 && sum != list.get(0) * 2) return false;
        }
        return true;
    }
}