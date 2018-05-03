public class ZigzagIterator2 {
    int idx1;
    int idx2;
    List<Integer> v1;
    List<Integer> v2;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        idx1 = 0;
        idx2 = 0;
        this.v1 = v1;
        this.v2 = v2;
    }

    public int next() {
        if(idx1 == v1.size()){
            return v2.get(idx2++);
        }else if(idx2 == v2.size()){
            return v1.get(idx1++);
        }else{
            if(idx1 == idx2){
                return v1.get(idx1++);
            }else{
                return v2.get(idx2++);
            }
        }
    }

    public boolean hasNext() {
        return idx1 < v1.size() || idx2 < v2.size();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */