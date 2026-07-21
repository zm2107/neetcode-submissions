class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> score = new Stack<>();
        for(int i = 0; i < operations.length; i++) {
            String op = operations[i];
            if(op.equals("+")) {
                int top = score.pop();
                int newtop = top + score.peek();
                score.push(top);
                score.push(newtop);
            }
            else if(op.equals("D")) {
                score.push(2 * score.peek());
            }
            else if(op.equals("C")) {
                score.pop();
            }
            else {
                score.push(Integer.valueOf(op));
            }
        }
        int total = 0;
        for(int s : score) total += s;
        return total;
    }
}