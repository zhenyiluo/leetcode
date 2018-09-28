class RLEIterator {
    int index;
    int next;
    int cnt;
    int[] A;
    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
        if(A.length == 0) return;
        cnt = A[0];
        next = A[1];
    }

    public int next(int n) {
        if(index + 1 >= A.length) return -1;
        while(cnt < n){
            n -= cnt;
            index += 2;
            if(index + 1 >= A.length) return -1;
            cnt = A[index];
            next = A[index+1];
        }
        cnt -= n;
        return next;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */