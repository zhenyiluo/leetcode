//31 ms
public class Solution1 {
    public int maxProduct(String[] words) {
        int max = 0;

        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });

        int[] info = new int[words.length]; 
        for(int i = 0; i < info.length; i++){
            info[i] = getMask(words[i]);
        }

        for(int i = 0; i < info.length; i++){
            for(int j = i + 1; j < info.length; j++){
                if((info[i] & info[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                    break; 
                }
            }
        }
        return max;
    }

    private int getMask(String s){
        int mask = 0;
        for(char c: s.toCharArray()){
            mask |= 1 << (c - 'a');
        }
        return mask;
    }
}