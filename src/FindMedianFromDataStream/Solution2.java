class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> (a - b));
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        if(!minHeap.isEmpty() && num >= minHeap.peek()){
            minHeap.add(num);
        }else{
            maxHeap.add(num);
        }

        if(Math.abs(minHeap.size() - maxHeap.size()) >= 2){
            if(minHeap.size() < maxHeap.size()){
                minHeap.add(maxHeap.poll());
            }else{
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        if(minHeap.size() > maxHeap.size()){
            return minHeap.peek();
        }else if(minHeap.size() < maxHeap.size()){
            return maxHeap.peek();
        }
        return 0.5 * minHeap.peek() + 0.5 * maxHeap.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */