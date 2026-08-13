class Solution {
    public boolean backspaceCompare(String s, String t) {
        return compare(s).equals(compare(t));
    }

    private String compare(String s){
        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()){
            if(ch != '#'){
                stack.push(ch);
            }
            else if(!stack.isEmpty()){
                stack.pop();
            }
        }

        for(char ch : stack){
            str.append(ch);
        }

        return str.toString();
    }
}
