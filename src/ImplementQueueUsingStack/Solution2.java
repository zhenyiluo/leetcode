class MyQueue {
    Stack<Integer> st;
    /** Initialize your data structure here. */
    public MyQueue() {
        st = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(st.isEmpty()){
            st.push(x);
        }else{
            Stack<Integer> tmp = new Stack<>();
            while(!st.isEmpty()){
                tmp.push(st.pop());
            }
            st.push(x);
            while(!tmp.isEmpty()){
                st.push(tmp.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return st.pop();
    }

    /** Get the front element. */
    public int peek() {
        return st.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */