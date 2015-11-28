public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || A.length == 0 || A[0].length == 0){
            return new int[0][0];
        }
        if(B == null || B.length == 0 || B[0].length == 0){
            return new int[0][0];
        }
        
        int ma = A.length;
        int na = A[0].length;
        
        ArrayList<ArrayList<Element>> listA = new ArrayList<>();
        for(int i = 0; i < ma; i++){
            ArrayList<Element> tmp = new ArrayList<>();
            for(int j = 0; j < na; j++){
                if(A[i][j] != 0){
                    tmp.add(new Element(A[i][j], j));
                }
            }
            listA.add(tmp);
        }
        
        int mb = B.length;
        int nb = B[0].length;
        ArrayList<ArrayList<Element>> listB = new ArrayList<>();
        for(int j = 0; j < nb; j++){
            ArrayList<Element> tmp = new ArrayList<>();
            for(int i = 0; i < mb; i++){
                if(B[i][j] != 0){
                    tmp.add(new Element(B[i][j], i));
                }
            }
            listB.add(tmp);
        }
        
        int[][] ret = new int[ma][nb];
        for(int i = 0; i < ma; i++){
            for(int j = 0; j < nb; j++){
                ArrayList<Element> list1 = listA.get(i);
                ArrayList<Element> list2 = listB.get(j);
                ret[i][j] = getSingleMultiplication(list1, list2);
            }
        }
        return ret;
    }
    
    private int getSingleMultiplication(ArrayList<Element> list1, ArrayList<Element> list2){
        int ret = 0;
        int i = 0; 
        int j = 0;
        while(i < list1.size() && j < list2.size()){
            Element e1 = list1.get(i);
            Element e2 = list2.get(j);
            if(e1.y == e2.y){
                ret += e1.x * e2.x;
                i++;
                j++;
            }else if(e1.y < e2.y){
                i++;
            }else{
                j ++;
            }
        }
        return ret;
    }
}

class Element{
    int x;
    int y;
    public Element(int x, int y){
        this.x = x;
        this.y = y;
    }
}