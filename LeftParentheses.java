public class LeftParentheses {
    public static void main(String[] args) {
        Stack<String> integerStack = new Stack<>();
        Stack<String> operandStack = new Stack<>();

        // LeftParentheses x = new LeftParentheses();
        // x.stringParser(args[0], integerStack, operandStack);


        // String result = stringParser(args[0], integerStack, operandStack);
        // infixToPostfixConverter(result);

        String res = infixToPostfixConverter(args[0]);
        res = evaluateInfix(res);
        

    }

    public static String stringParser(String args, Stack<String> integerStack,
                                      Stack<String> operandStack) {
        for (int x = 0; x < args.length(); x++) {
            String i = args.substring(x, x + 1);
            // StdOut.println("I is " + i);
            if (isInteger(i)) {
                integerStack.push(i);
                // StdOut.println("I :" + i + " has been pushed to the integer stack.");
            }
            else if (isOperator(i)) {
                operandStack.push(i);
                // StdOut.println("I : " + i + " has been pushed to the operand stack.");
            }
            else if (i.equals(")")) {
                String num2 = integerStack.pop();
                String num1 = integerStack.pop();
                // StdOut.println("Num 1 : " + num1);
                // StdOut.println("Num 2 : " + num2);
                String result = "( " + num1 + " " + operandStack.pop() + " " + num2 + " )";
                // StdOut.println("Result : " + result);
                integerStack.push(result);
            }
            else if (i.equals(" ")) continue;

            // StdOut.println("Peeking in the stacks");
            // StdOut.println(integerStack.peek());
            // StdOut.println(operandStack.peek());

        }
        String result = integerStack.pop();
        StdOut.println(result);
        return result;
    }

    public static String evaluateInfix(String args) {
        Stack<Integer> integerstack = new Stack<>();

        for (int i = 0; i < args.length(); i++) {
            String x = args.substring(i, i + 1);
            if (isOperator(x)) {
                int num2 = integerstack.pop();
                int res = evaluateExpression(integerstack.pop(), num2, x);
                integerstack.push(res);
            }
            else if (isInteger(x)) integerstack.push(Integer.parseInt(x));
        }
        int res = integerstack.pop();
        StdOut.println(res);
        return Integer.toString(res);
    }

    public static String infixToPostfixConverter(String args) {
        StdOut.println("Inside infix and args " + args);
        Stack<String> integerstack = new Stack<>();
        Stack<String> operatorstack = new Stack<>();

        for (int i = 0; i < args.length(); i++) {
            String x = args.substring(i, i + 1);
            if (isOperator(x) || isLeftEnclosingBrace(x)) {
                operatorstack.push(x);
            }
            else if (isInteger(x)) integerstack.push(x);
            else if (isRightEnclosingBrace(x)) {
                String y = operatorstack.pop();
                while (!isLeftEnclosingBrace(y)) {
                    String num2 = integerstack.pop();
                    String result = integerstack.pop() + " " + num2 + " " + y;
                    integerstack.push(result);
                    y = operatorstack.pop();
                }
                if (!isProperClosure(y, x)) {
                    StdOut.println("Improper closure of brackets.");
                }
            }
        }
        while (!operatorstack.isEmpty()) {
            if (integerstack.size() < 2) {
                StdOut.println("Integer Stack Underflow");
                break;
            }
            String x = operatorstack.pop();
            String num2 = integerstack.pop();
            String result = integerstack.pop() + " " + num2 + " " + x;
            integerstack.push(result);
        }
        String res = integerstack.pop();
        StdOut.println(res);
        return res;
    }

    public static boolean isInteger(String x) {

        try {
            int i = Integer.parseInt(x);
            return true;
        }

        catch (Exception e) {
            return false;
        }
    }

    public static boolean isOperator(String x) {
        if (x.length() > 1) {
            return false;

        }
        else if (x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/")) return true;
        else return false;
    }

    public static boolean isLeftEnclosingBrace(String x) {
        if (x.length() > 1) return false;
        else if (x.equals("{") || x.equals("[") || x.equals("(")) return true;
        else return false;
    }

    public static boolean isRightEnclosingBrace(String x) {
        if (x.length() > 1) return false;
        if (x.equals("}") || x.equals("]") || x.equals(")")) return true;
        else return false;
    }

    public static boolean isProperClosure(String x, String y) {
        if (x.equals("{")) {
            if (y.equals("}")) return true;
            else return false;
        }
        else if (x.equals("[")) {
            if (y.equals("]")) return true;
            else return false;
        }
        else if (x.equals("(")) {
            if (y.equals(")")) return true;
            else return false;
        }
        return false;
    }

    public static int evaluateExpression(int x, int y, String operator) {
        if (operator.equals("+")) return x + y;
        else if (operator.equals("-")) return x - y;
        else if (operator.equals("*")) return x * y;
        else if (operator.equals("/")) return x / y;
        else return -1;
    }

}

