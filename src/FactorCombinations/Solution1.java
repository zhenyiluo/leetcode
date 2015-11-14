public class Solution {
    public List<List<Integer>> getFactors(int n) {
        return generate(n, 2, n);
    }

    private List<List<Integer>> generate(int n, int low, int high){
        List<List<Integer>> ret = new ArrayList<>();

        if(n >= low && n < high){
            List<Integer> list = new ArrayList<>();
            list.add(n);
            ret.add(list);
        }

        for(int i = low; i * i <= n; i++){
            if(n % i == 0){
                for(List<Integer> list : generate(n / i, i, n)){
                    list.add(0, i);
                    ret.add(list);
                }
            }
        }
        return ret;
    }
}