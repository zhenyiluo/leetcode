public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> listIt;
    Iterator<Integer> intIt;
    public Vector2D(List<List<Integer>> vec2d) {
        listIt = vec2d.iterator();
    }

    @Override
    public Integer next() {
        hasNext();
        return intIt.next();
    }

    @Override
    public boolean hasNext() {
        while((intIt == null || !intIt.hasNext()) && listIt.hasNext()){
            intIt = listIt.next().iterator();
        }
        return intIt != null && intIt.hasNext();
    }

}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */