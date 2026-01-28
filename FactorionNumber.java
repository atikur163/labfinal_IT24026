import java.util.Scanner;

public class FactorionNumber {
    // Pre-computed factorials for digits 0-9 for efficiency
    private static final int[] FACTORIALS = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
    
    // Method to check if a number is a factorion
    public static boolean isFactorion(int number) {
        int originalNumber = number;
        int sum = 0;
        while (number > 0) {
            int digit = number % 10;
            sum += FACTORIALS[digit];  // Use pre-computed factorial [web:46]
            number /= 10;
        }
        return sum == originalNumber;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the lower bound of the range: ");
        int lowerBound = scanner.nextInt();
        System.out.print("Enter the upper bound of the range: ");
        int upperBound = scanner.nextInt();
        
        System.out.println("Factorion numbers in the range:");
        boolean found = false;
        
        // Find factorion numbers in the given range
        for (int i = lowerBound; i <= upperBound; i++) {
            if (isFactorion(i)) {
                System.out.println(i);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No factorion numbers found in the given range.");
        }
        scanner.close();
    }
}
