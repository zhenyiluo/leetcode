public class ZigzagIterator {
    List<Iterator> iterators;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new LinkedList<>();
        if(!v1.isEmpty()) {
            iterators.add(v1.iterator());
        }
        
        if(!v2.isEmpty()) {
            iterators.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iter = iterators.remove(0);
        int ret = iter.next();
        if(iter.hasNext()) {
            iterators.add(iter);
        }
        return ret;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */