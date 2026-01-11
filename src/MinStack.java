import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private int minValue = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        if (val < minValue){
            minValue = val;
        }
    }
    
    public void pop() {
        this.stack.pop();
        if (stack.isEmpty()){
            minValue = Integer.MAX_VALUE;
        }else{
            minValue = Integer.MAX_VALUE;
            for (Integer val: stack){
                if (val < minValue){
                    minValue = val;
                }
            }
        }
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return minValue;
    }
}