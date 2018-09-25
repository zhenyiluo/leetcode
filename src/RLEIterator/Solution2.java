class RLEIterator {
    int[] A;
    int size;
    int index;
    int cnt;
    public RLEIterator(int[] A) {
        this.A = A;
        size = A.length;
        if(size == 0) return;
        cnt = A[0];
        index = 1;
    }

    public int next(int n) {
        if(index >= size) return -1;
        while(n > cnt){
            n = n - cnt;
            index = index + 2;
            if(index >= size) return -1;
            cnt = A[index -1];
        }
        cnt -= n;
        return A[index];
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */