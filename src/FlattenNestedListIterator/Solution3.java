/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {

    Integer buf = null;
    Stack<NestedInteger> st;
    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        pushToStack(st, nestedList);
    }

    @Override
    public Integer next() {
        if(hasNext()){
            int ans = buf;
            buf =  null;
            return ans;
        }
        throw new RuntimeException();
    }

    @Override
    public boolean hasNext() {
        while (buf == null && !st.isEmpty()){
            NestedInteger ni = st.pop();
            if(ni.isInteger()){
                buf = ni.getInteger();
            }else{
                pushToStack(st, ni.getList());
            }
        }
        return buf != null;
    }

    private void pushToStack(Stack<NestedInteger> st, List<NestedInteger> nestedList){
        if(nestedList == null) return;
        for(int i = nestedList.size() -1; i >= 0; i--){
            st.push(nestedList.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */