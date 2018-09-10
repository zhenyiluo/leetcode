class Solution {
    public List<Integer> cheapestJump(int[] A, int B) {
        List<Integer> ans = new ArrayList<>();
        int n = A.length;
        Item[] items = new Item[n];
        items[0] = new Item();
        items[0].minCost = A[0];
        items[0].list = new ArrayList<>();
        items[0].list.add(1);
        for(int i = 0; i < n -1; i++){
            if(A[i] == -1 || items[i] == null) continue;
            for(int k = 1; k <= B && i + k < n; k++){
                int j = i + k;
                if(A[j] == -1) continue;
                if(items[j] == null) {
                    items[j] = new Item();
                    items[j].minCost = items[i].minCost + A[j];
                    items[j].list = new ArrayList<>(items[i].list);
                    items[j].list.add(j+1);
                }else{
                    int newCost = items[i].minCost + A[j];
                    if(newCost < items[j].minCost){
                        items[j].minCost = newCost;
                        items[j].list = new ArrayList<>(items[i].list);
                        items[j].list.add(j+1);
                    }else if(newCost == items[j].minCost){
                        List<Integer> curList = items[j].list;
                        List<Integer> newList = items[i].list;
                        newList.add(j+1);
                        if(compare(newList, curList) < 0){
                            items[j].list = new ArrayList<>(newList);
                        }
                        newList.remove(newList.size()-1);
                    }
                }
            }
        }
        if(items[n-1] != null && items[n-1].list != null){
            ans = items[n-1].list;
        }
        return ans;
    }

    private int compare(List<Integer> l1, List<Integer> l2){
        int size1 = l1.size();
        int size2 = l2.size();
        int minSize = Math.min(size1, size2);
        for(int i = 0; i < minSize; i++){
            if(l1.get(i) == l2.get(i)) continue;
            return l1.get(i) - l2.get(i);
        }
        return size1 - size2;
    }
}
class Item{
    int minCost;
    List<Integer> list;
    public Item(){
        minCost = Integer.MAX_VALUE;
    }
}