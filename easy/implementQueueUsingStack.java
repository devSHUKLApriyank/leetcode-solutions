import java.util.Stack;

public class implementQueueUsingStack {
    class MyQueue {

    private Stack<Integer> instack = new Stack<>();
    private Stack<Integer> outstack = new Stack<>();

    public MyQueue() {
        
        instack = new Stack<>();
        outstack = new Stack<>();

    }
    
    public void push(int x) {
        instack.push(x);
    }
    
    public int pop() {
        move();
        return outstack.pop();
    }
    
    public int peek() {
        move();
        return outstack.peek();
    }
    
    public boolean empty() {
        return instack.isEmpty() && outstack.isEmpty();
    }

    private void move(){
        if(outstack.isEmpty()){
            while(!instack.isEmpty()){
                outstack.push(instack.pop());
            }
        }
    }
}

}
