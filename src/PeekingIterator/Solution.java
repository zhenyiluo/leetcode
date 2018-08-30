// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    Integer next;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!hasNext()) return null;
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(!hasNext()) return null;
        Integer ans = next;
        next = null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        if(next == null && iterator.hasNext()){
            next = iterator.next();
        }
        return next != null;
    }
}