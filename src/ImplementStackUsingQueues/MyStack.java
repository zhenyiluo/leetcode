class MyStack {
    Queue<Integer> q = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        if(q.isEmpty()){
            q.add(x);
        }else{
            Queue<Integer> tmp = new LinkedList<Integer>();
            while(!q.isEmpty()){
                tmp.add(q.poll());
            }
            q.add(x);
            while(!tmp.isEmpty()){
                q.add(tmp.poll());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        q.poll();
    }

    // Get the top element.
    public int top() {
        return q.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
}