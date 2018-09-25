public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> itt;
    Iterator<Integer> it;
    public Vector2D(List<List<Integer>> vec2d) {
        itt = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return it.next();
        }
        throw new RuntimeException();
    }

    @Override
    public boolean hasNext() {
        while((it == null || !it.hasNext()) && itt.hasNext()){
            it = itt.next().iterator();
        }
        return it != null && it.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */