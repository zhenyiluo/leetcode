public class ZigzagIterator {
    Queue<Iterator<Integer>> q;
    Iterator<Integer> it;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        q.add(v1.iterator());
        q.add(v2.iterator());
    }

    public int next() {
        if(hasNext()){
            int ans = it.next();
            if(it.hasNext()){
                q.add(it);
            }
            it = null;
            return ans;
        }
        throw new RuntimeException();
    }

    public boolean hasNext() {
        while((it == null || !it.hasNext()) && !q.isEmpty()){
            it = q.poll();
        }
        return it != null && it.hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */