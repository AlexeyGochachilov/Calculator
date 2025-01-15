import java.util.Scanner;

public class Calculator {

    public static double calc(double operand1, char operation, double operand2) {
        double resalt = 0;
        switch (operation) {
            case '+':
                resalt = operand1 + operand2;
                break;
            case '-':
                resalt = operand1 - operand2;
                break;
            case '*':
                resalt = operand1 * operand2;
                break;
            case '/':
                if (operand2 == 0) {
                    System.out.println("На ноль делить нельзя");
                    operand2 = 1;
                }
                resalt = operand1 / operand2;
                break;
            default:
                System.out.println("Введено не известное действие");
        }
        return resalt;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println("Вводите числа и операции над числами через пробел или с новой строки.");
        System.out.println("      Для перезапуска процесса подсчета введите 'C' (латиница)");
        System.out.println("                Для выхода из программы введите 's'");
        Scanner scanner = new Scanner(System.in);
        OUTER:
        while (true) {
            double operand1 = scanner.nextDouble();
            char operation = scanner.next().charAt(0);
            double operand2 = scanner.nextDouble();
            double resalt = calc(operand1, operation, operand2);
            System.out.println("= " + resalt);
            INNER:
            while (true) {
                operation = scanner.next().charAt(0);
                if (operation == 'C') {
                    break INNER;
                } else if (operation == 's') {
                    break OUTER;
                } else {
                    operand2 = scanner.nextDouble();
                    resalt = calc(resalt, operation, operand2);
                    System.out.println("= " + resalt);
                }
            }
        }
    }
}
