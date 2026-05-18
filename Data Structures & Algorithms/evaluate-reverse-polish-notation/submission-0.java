class Solution {
    public int evalRPN(String[] tokens) {
        // Initialize list of operator chars, integer stack, and set currentNum as the first num
        List<Character> operators = Arrays.asList('+', '-', '*', '/');
        Stack<Integer> RPNStack = new Stack<>();
        int currentNum = Integer.parseInt(tokens[0]);
        
        // Loop until all strings are handled
        for (String currentToken : tokens) {
            char current = currentToken.charAt(0);

            // If the current string is an operator character, call on the operation (depending on how we need to call it), update currentNum, then add it to the stack
            if (operators.contains(current) && currentToken.length() == 1) {
                // If we have more than 2 nums in the stack, pop both out then use the operation
                if (RPNStack.size() >= 2) {
                    int num2 = RPNStack.pop(), num1 = RPNStack.pop();
                    currentNum = operation(num1, current, num2);
                    RPNStack.add(currentNum);
                }
                // Otherwise, pop one out then use the operation with currentNum
                else {
                    int num2 = RPNStack.pop();
                    currentNum = operation(num2, current, currentNum);
                    RPNStack.add(currentNum);
                }
            }

            // If the current string is a number, add it to the integer stack
            else {
                int num = Integer.parseInt(currentToken);
                RPNStack.add(num);
            }
        }

        // Return currentNum when done parsing through the strings
        return currentNum;
    }
    // Helper function for handling operations
    private int operation(int num1, char operator, int num2) {
        int result = 0;        
        switch (operator) {
            case '+':
                result = num1 + num2; break;
            case '-':
                result = num1 - num2; break;
            case '*':
                result = num1 * num2; break;
            case '/':
                result = num1 / num2; break;
        }
        return result;
    }
}