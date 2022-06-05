package calc;

import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public class CalculatorService {

    public Double evaluate(String expr) {

        String[] tabChars = expr.split(" ");

        LinkedList<Double> stack = new LinkedList<>();

        if (expr.isEmpty())
            return 0.;

        for (int i = 0; i < tabChars.length; i++) {

            if (Character.isDigit(tabChars[i].charAt(0))) {
                stack.add(Double.valueOf(tabChars[i]));
            } else {
                if (tabChars[i].equals("+")) {
                    stack.add(getLastStack(stack) + getLastStack(stack));
                } else if (tabChars[i].equals("-")) {
                    Double x = getLastStack(stack);
                    stack.add(getLastStack(stack) - x);
                } else if (tabChars[i].equals("*")) {
                    stack.add(getLastStack(stack) * getLastStack(stack));
                } else if (tabChars[i].equals("/")) {
                    Double x = getLastStack(stack);
                    stack.add(getLastStack(stack) / x);
                }
            }
        }
        return stack.get(0);
    }

    Double getLastStack(LinkedList linkedList) {
        var number = linkedList.getLast();
        linkedList.removeLast();
        return (Double) number;
    }

}





