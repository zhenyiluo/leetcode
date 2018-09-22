// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Integer buf;
    Iterator<Integer> it;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        it = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(hasNext()){
            return buf;
        }
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(hasNext()){
            int ans = buf;
            buf = null;
            return ans;
        }
        throw new RuntimeException();
    }

    @Override
    public boolean hasNext() {
        if(buf == null && it.hasNext()){
            buf = it.next();
        }
        return buf != null;
    }
}