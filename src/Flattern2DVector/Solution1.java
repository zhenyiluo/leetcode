public class Vector2D {
    List<Iterator<Integer>> list;
    int cur = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        list = new ArrayList<>();
        for(List<Integer> vec1d : vec2d){
            if(!vec1d.isEmpty()){
                list.add(vec1d.iterator());
            }
        }
    }

    public int next() {
        Iterator<Integer> iter = list.get(cur);
        int ret = iter.next();
        if(!iter.hasNext()){
            cur++;
        }
        return ret;
    }

    public boolean hasNext() {
         return cur < list.size() && list.get(cur).hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */