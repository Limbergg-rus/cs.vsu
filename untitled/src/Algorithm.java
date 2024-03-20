import java.util.Stack;

public class Algorithm {
//    public static int reversePolishNotation(String[] arr) {
//        Stack stc = new Stack();
//        for (String item: arr){
//            switch (item) {
//                case "+":
//                    stc.push(stc.pop() + stc.pop());
//                    break;
//                case "-":
//                    stc.push(- stc.pop() + stc.pop());
//                    break;
//                case "*":
//                    stc.push(stc.pop() * stc.pop());
//                    break;
//                case "/":
//                    stc.push(stc.pop() / stc.pop());
//                    break;
//                default:
//                    stc.push(Integer.parseInt(item));
//            }
//        }
//        return stc.peek();
//    }

    public static int reversePolishNotationSecond(String[] arr) {
        Stack<Integer> stc = new Stack<>();
        for (String item: arr){
            switch (item) {
                case "+":
                    stc.push(stc.pop() + stc.pop());
                    break;
                case "-":
                    stc.push( - stc.pop() + stc.pop());
                    break;
                case "*":
                    stc.push(stc.pop() * stc.pop());
                    break;
                case "/":
                    stc.push(stc.pop() / stc.pop());
                    break;
                default:
                    stc.push(Integer.parseInt(item));
            }
        }
        return stc.peek();
    }

}
