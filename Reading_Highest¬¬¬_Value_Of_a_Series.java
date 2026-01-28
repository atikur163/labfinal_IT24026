import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Lab2 {
    public static void main(String[] args) {
        int highest = Integer.MIN_VALUE;
        String[] numbers = null;

        try (Scanner input = new Scanner(new File("Input.txt"))) {
            if (input.hasNextLine()) {
                String line = input.nextLine();
                numbers = line.split(",\\s*");  
                for (String numStr : numbers) {
                    int num = Integer.parseInt(numStr.trim());
                    if (num > highest) {
                        highest = num;
                    }    }     }
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid numbers in input file");
            return;
        }
        try (PrintWriter output = new PrintWriter("Output.txt")) {
            for (int i = 0; i < numbers.length; i++) {
                output.print(numbers[i]);
                if (i < numbers.length - 1) {
                    output.print(", "); 
                } }
            output.println();  
        } catch (IOException e) {
            System.out.println("Error writing output file");
        }
        System.out.println("Highest value: " + highest);
    }
}
