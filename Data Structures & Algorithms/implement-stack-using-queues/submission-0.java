class MyStack {
    private Queue<Integer> notStack;
    private int head;
    public MyStack() {
        notStack = new LinkedList<>();
        head = 0;
    }
    
    public void push(int x) {
        notStack.offer(x);
        head++;
    }
    
    public int pop() {
        int popped = notStack.peek();
        for (int i = 0; i < head - 1; i++) {
            notStack.offer(notStack.poll());
        }
        popped = notStack.poll();
        head--;
        return popped;
    }
    
    public int top() {
        int popped = notStack.peek();
        for (int i = 0; i < head - 1; i++) {
            notStack.offer(notStack.poll());
        }
        popped = notStack.poll();
        notStack.offer(popped);
        return popped; 
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