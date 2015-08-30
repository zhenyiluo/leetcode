public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int x1 = Math.max(A, E);
        int x2 = Math.min(C, G);
        int y1 = Math.max(B, F);
        int y2 = Math.min(D, H);
        int area1 = calc(A, B, C, D);
        int area2 = calc(E, F, G, H);
        int intersectArea = calc(x1, y1, x2, y2);
        return area1 + area2 - intersectArea;
    }
    
    private int calc(int x1, int y1, int x2, int y2){
        if(x2 <= x1 || y2 <= y1){
            return 0;
        }
        return (x2-x1)* (y2 - y1);
    }
}