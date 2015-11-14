public class Solution {
    public List<String> generatePalindromes(String s) {
        List<String> ret = new ArrayList<>();
        if(s == null || s.length() == 0){
            return ret;
        }
        int[] map = new int[256];
        for(int i = 0; i < s.length(); i++){
            map[s.charAt(i)]++;
        }

        int cnt = 0;
        for(int i = 0; i < 256; i++){
            if(map[i] % 2 == 1){
                if(cnt == 0){
                    cnt ++;
                }else{
                    return ret;
                }
            }
        }

        String cur = "";
        for(int i = 0; i < 256; i++){
            if(map[i] % 2 != 0){
                cur = "" + (char) i;
                map[i] --;
            }
        }
        int len = s.length();
        dfs(ret, cur, map, len);

        return ret;
    }

    private void dfs(List<String> ret, String cur, int[] map, int len){
        if(cur.length() == len){
            ret.add(new String(cur));
            return;
        }
        for(int i = 0; i < 256; i++){
            if(map[i] > 0){
                char c = (char) i;
                String nextS = c + cur + c;
                map[i] -= 2;
                dfs(ret, nextS, map, len);
                map[i] += 2;
            }
        }
        return ;
    }
}

