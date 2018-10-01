class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for(int i = 1; i < n; i++){
            fact[i] = fact[i-1] * i;
        }
        StringBuilder sb = new StringBuilder();
        k = k - 1;
        for(int i = n -1; i >= 0; i--){
            int index = k / fact[i];
            k %= fact[i];
            sb.append(list.remove(index));
        }
        return sb.toString();
    }
}