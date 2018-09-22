class RLEIterator {
    int index = 0;
    int cur = 0;
    int[] A;
    public RLEIterator(int[] A) {
        this.A = A;
        cur = A[index];
    }

    public int next(int n) {
        while(cur < n){
            n -= cur;
            index += 2;
            if(index >= A.length) return -1;
            cur = A[index];
        }
        if(index < A.length) {
            cur -= n;
            return A[index+1];
        }
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */