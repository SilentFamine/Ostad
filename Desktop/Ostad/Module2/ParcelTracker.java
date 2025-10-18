import java.util.Scanner;

public class ParcelTracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the 5-digit tracking ID: ");
        int currentTrackingId = scanner.nextInt();

        System.out.print("Enter the parcel weight (e.g., 25.87): ");
        double currentWeight = scanner.nextDouble();

        scanner.close();

        int nextTrackingId = currentTrackingId + 1;
        int weightWithoutDecimal = (int) currentWeight;

        System.out.println("Next tracking id: " + nextTrackingId);
        System.out.println("Weight without decimal point: " + weightWithoutDecimal);
    }
}