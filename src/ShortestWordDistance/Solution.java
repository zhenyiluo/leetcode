public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                list1.add(i);
            }else if(words[i].equals(word2)){
                list2.add(i);
            }
        }
        int i = 0; 
        int j = 0;
        int min = Integer.MAX_VALUE;
        while(i < list1.size() && j < list2.size()){
            min = Math.min(min, Math.abs(list1.get(i) - list2.get(j)));
            if(list1.get(i) < list2.get(j)){
                i++;
            }else{
                j++;
            }
        }
        
        return min;
    }
}