class MovingAverage {

    int[] buffer;
    int idx = -1;
    long sum = 0;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        buffer = new int[size];
        this.size = size;
    }

    public double next(int val) {
        idx ++;
        if(idx >= size){
            sum -= buffer[idx % size];
        }
        buffer[idx % size] = val;
        sum += val;
        if(idx >= size){
            return 1.0 * sum / size;
        }
        return 1.0 * sum / (idx + 1);
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */