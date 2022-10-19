import java.util.ArrayList;
import java.util.Scanner;

public class LinearEquationRunner {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome!");

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

            System.out.print("Enter a value for x: ");
            double x = scanner.nextDouble();
            System.out.println("tbd");
        }*/

        int[] x1 = {-1, 2, -6, 1,0,-1,6,4,6,1,7,-1,-1,-2,7,16};
        int[] y1 = {5, 10, -2,4,0,4,3,0,2,-10,14,3,2,-2,12,-2};
        int[] x2 = {3, -1, 1,7,4,-7,-1,6,8,-3,5,2,-3,4,3,3};
        int[] y2 = {10, 3,-1,12,5,12,4,10,-12,2,10,6,4,4,12,-2};
        for (int i = 0; i < x1.length; i++) {
            LinearEquation equation = new LinearEquation(x1[i], y1[i], x2[i], y2[i]);
            System.out.println("Equation: " + equation.equation());
            System.out.println("Slope: " + equation.slope());
            System.out.println("y-intercept: " + equation.yIntercept());
            System.out.println("Distance: " + equation.distance());
            System.out.println();
            System.out.println("----- Line info -----");
            System.out.println(equation.lineInfo());
            System.out.println();
            double testX = 4;
            System.out.println("Coordinate for x: " + equation.coordinateForX(testX));
        }
    }
}
