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
    Stack<NestedInteger> st;
    Integer cur = null;
    public NestedIterator(List<NestedInteger> nestedList) {
        st = new Stack<>();
        pushToStack(st, nestedList);
    }

    @Override
    public Integer next() {
        if(cur == null){
            if(!hasNext()) return null;
        }
        Integer ans = cur;
        cur = null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        while(cur == null && !st.isEmpty()){
            NestedInteger ni = st.pop();
            if(ni.isInteger()){
                cur = ni.getInteger();
            }else{
                pushToStack(st, ni.getList());
            }
        }
        return cur != null;
    }

    private void pushToStack(Stack<NestedInteger> st, List<NestedInteger> list){
        if(list == null) return;
        for(int i = list.size() -1; i >= 0; i--){
            st.push(list.get(i));
        }
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */