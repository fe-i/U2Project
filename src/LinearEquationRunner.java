import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Linear Equation Calculator!");

        System.out.print("Enter coordinate 1: ");
        String coord1 = scanner.nextLine();
        int x1 = Integer.parseInt(coord1.substring(1, coord1.indexOf(", ")));
        int y1 = Integer.parseInt(coord1.substring(coord1.indexOf(", ") + 2, coord1.length() - 1));

        System.out.print("Enter coordinate 2: ");
        String coord2 = scanner.nextLine();
        int x2 = Integer.parseInt(coord2.substring(1, coord2.indexOf(", ")));
        int y2 = Integer.parseInt(coord2.substring(coord2.indexOf(", ") + 2, coord2.length() - 1));

        System.out.println();

        if (x1 == x2) {
            System.out.println("These points are on a vertical line: x = " + x1);
        }
        else {
            LinearEquation le = new LinearEquation(x1, y1, x2, y2);
            System.out.println(le.lineInfo());
            System.out.println();
            System.out.print("Enter a value for x: ");
            double x = scanner.nextDouble();
            System.out.println();
            System.out.println("The point on the line is: " + le.coordinateForX(x));
            System.out.println();
        }
    }
}