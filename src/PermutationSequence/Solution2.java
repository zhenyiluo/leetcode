class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int size = n - 1;
        StringBuilder sb = new StringBuilder();
        while(size != 0){
            int num = f(size);
            int index = (k -1) / num;
            sb.append(list.remove(index));
            k -= num * index;
            size--;
        }
        sb.append(list.get(0));
        return sb.toString();
    }

    private int f(int n){
        if(n == 1) return 1;
        return n * f(n-1);
    }
}