public class Parentheses {
    public static void main(String[] args) {
        String test = args[0];
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < args[0].length(); i++) {
            char x = test.charAt(i);
            StdOut.println(x);
            if (x == '(' || x == '{' || x == '[') {
                StdOut.println("Inside push");
                stack.push(x);
            }
            else if (x == '}' || x == ']' || x == ')') {
                Character popped = stack.pop();
                if (x == '}') {
                    if (popped == '{') continue;
                    else {
                        StdOut.println("Improper closure of brackets.");
                    }
                }
                else if (x == ')') {
                    if (popped == '(') continue;
                    else {
                        StdOut.println("Improper closure of brackets.");
                    }
                }
                else if (x == ']') {
                    if (popped == '[') continue;
                    else {
                        StdOut.println("Improper closure of brackets.");
                    }
                }
            }
            else {
                StdOut.println("Improper Input");
            }
        }

    }
}
