class MyStack {
    private Queue<Integer> notStack;
    public MyStack() {
        notStack = new LinkedList<>();
    }
    
    public void push(int x) {
        notStack.offer(x);
        int size = notStack.size();
        while (size-- > 1) {
            notStack.offer(notStack.poll());
        }
    }
    
    public int pop() {
        return notStack.poll();
    }
    
    public int top() {
        return notStack.peek(); 
    }
    
    public boolean empty() {
        return notStack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */