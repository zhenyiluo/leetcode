class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        if(A == null || B == null || A.length == 0 || A[0].length == 0 || B.length == 0 || B[0].length == 0) return new int[0][0];
        int mA = A.length;
        int nA = A[0].length;
        int mB = B.length;
        int nB = B[0].length;
        ArrayList<ArrayList<int[]>> listA = new ArrayList<>();
        ArrayList<ArrayList<int[]>> listB = new ArrayList<>();
        for(int j = 0; j < nA; j++){
            ArrayList<int[]> list = new ArrayList<>();
            for(int i = 0; i < mA; i++){
                if(A[i][j]!= 0){
                    list.add(new int[]{A[i][j], i});
                }
            }
            listA.add(list);
        }

        for(int i = 0; i < mB; i++){
            ArrayList<int[]> list = new ArrayList<>();
            for(int j = 0; j < nB; j++){
                if(B[i][j] != 0){
                    list.add(new int[]{B[i][j], j});
                }
            }
            listB.add(list);
        }
        int[][] ret = new int[mA][nB];
        for(int i = 0; i < listA.size(); i++){
            ArrayList<int[]> list1 = listA.get(i);
            ArrayList<int[]> list2 = listB.get(i);
            for(int[] arr1 : list1){
                for(int[] arr2: list2){
                    ret[arr1[1]][arr2[1]] += arr1[0] * arr2[0];
                }
            }
        }
        return ret;
    }
}