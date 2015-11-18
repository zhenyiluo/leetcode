class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2){
            return i1 - i2;
        }
    });

    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
        @Override
        public int compare(Integer i1, Integer i2){
            return i2 - i1;
        }
    });

    // Adds a number into the data structure.
    public void addNum(int num) {
        if(minHeap.size() == maxHeap.size()){
            if(!minHeap.isEmpty() && num > minHeap.peek()){
                maxHeap.add(minHeap.poll());
                minHeap.add(num);
            }else{
                maxHeap.add(num);
            }
        }else{
            if(num < maxHeap.peek()){
                minHeap.add(maxHeap.poll());
                maxHeap.add(num);
            }else{
                minHeap.add(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()){
            return 0.5 * (maxHeap.peek() + minHeap.peek());
        }else{
            return maxHeap.peek();
        }
    }
};

// Your MedianFinder object will be instantiated and called as such:
// MedianFinder mf = new MedianFinder();
// mf.addNum(1);
// mf.findMedian();