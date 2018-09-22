public class ZigzagIterator {
    Queue<Iterator<Integer>> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        if(!v1.isEmpty()) q.add(v1.iterator());
        if(!v2.isEmpty()) q.add(v2.iterator());
    }

    public int next() {
        if(hasNext()){
            Iterator<Integer> it = q.poll();
            int ans = it.next();
            if(it.hasNext()) q.add(it);
            return ans;
        }
        throw new RuntimeException();
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */