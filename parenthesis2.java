import java.util.Map;
import java.util.Stack;

public class parenthesis2 {

    public static void main(String[] args) {
        String str1 = "a+(d*3)";
        String str2 = "[a+(1*3)";
        String str3 = "[6+(3*3)]";
        String str4 = "{a+]}{(d*3)}";

        System.out.println(" => " + check(str1));
        System.out.println(" => " + check(str2));
        System.out.println(" => " + check(str3));
        System.out.println(" => " + check(str4));
    }

    public static boolean check(String str) {
        System.out.print(str);

        Stack<Character> stack = new Stack<>();
        Map<Character, Character> characterMap = Map.of(
                '(', ')',
                '[', ']',
                '{','}');

        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (characterMap.containsKey(symbol)) { // если среди ключей есть проверяемый символ
                stack.push(symbol); // кладем символ в стак
            } 
            else if (characterMap.containsValue(symbol)) { // если среди значений есть проверяемый символ
                if (stack.isEmpty() || characterMap.get(stack.pop()) != symbol){ // берем значение по ключу верхнему в стаке и сравниваем с проверяемым символом
                    return false;
                }
            }
        }
        if (stack.empty()){ // проверка на случай, если останется открытая скобка
            return true;
        }
        return false;
    }

}
