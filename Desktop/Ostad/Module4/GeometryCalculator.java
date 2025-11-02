

import java.util.Scanner;

public class GeometryCalculator {
    public static double getPositiveInput(Scanner sc,String message){
        double value;
        while (true) {
            System.out.print(message);
            value = sc.nextDouble();
            if (value >= 0) {
                break;
            }
            else{
                System.out.println("Value must be positive!Try again.");
            }
        }
        return value;
    }

    public static double calculate(String type, double length, double width){
        if (type.equalsIgnoreCase("area")) {
            return length*width;
        }
        else{
            return 2*(length+width);
        }
    }

    public static void dislayResult(double length, double width, double area, double perimeter){
        System.out.println("\n--------Rectangle Result--------");
        System.out.printf("Length   :%.2f\n ", length);
        System.out.printf("Width    :%.2f\n", width);
        System.out.printf("Area     : %.2f\n",area);
        System.out.printf("Perimeter :%.2f",perimeter);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double length = getPositiveInput(sc, "Enter Length : ");
        double Width = getPositiveInput(sc, "Enter Width : ");

        double area = calculate("area", length, Width);
        double perimeter = calculate("perimeter", length, Width);

        dislayResult(length, Width, area, perimeter);

        sc.close();
   }
}
