public class Solution {
       public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0){
            return 0;
        }
        int m = image.length;
        int n = image[0].length;
        int left = searchColumns(0, y, image, true);
        int right = searchColumns(y, n-1, image, false);
        int up = searchRows(0, x, image, true);
        int down = searchRows(x, m-1, image, false);
        return (right - left + 1) * (down - up + 1);
    }

    private int searchColumns(int left, int right, char[][] image, boolean flag){
        while(left <= right){
            int mid = left + ((right - left)>> 1);
            if(checkColumn(mid, image) ^ flag){
                    left = mid + 1;
            }else{
                    right = mid - 1;
            }
        }
        return flag ? left : right;
    }

    private int searchRows(int up, int down, char[][] image, boolean flag){
        while(up <= down){
            int mid = up + ((down - up)>>1);
            if(checkRow(mid, image) ^ flag){
                    up = mid + 1;
            }else{
                    down = mid - 1;
            }
        }
        return flag ? up : down;
    }

    private boolean checkRow(int num, char[][] image){
        for(int j = 0; j < image[0].length; j++){
            if(image[num][j] == '1'){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumn(int num, char[][] image){
        for(int i = 0; i < image.length; i++){
            if(image[i][num] == '1'){
                return true;
            }
        }
        return false;
    }
    
}
