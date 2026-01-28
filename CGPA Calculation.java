import java.util.Scanner;

public class StudentCGPACalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Student ID: ");
        String studentID = sc.nextLine();

        System.out.print("No. of Courses: ");
        int n = sc.nextInt();

        int totalCredits = 0;
        int totalEarnedCredits = 0;
        double totalGradePoints = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("C" + i + ":");

            System.out.print("Credit (Max 3): ");
            int credit = sc.nextInt();

            System.out.print("CT (Max 30): ");
            int ct = sc.nextInt();

            System.out.print("AT (Max 10): ");
            int at = sc.nextInt();

            System.out.print("FE (Max 60): ");
            int fe = sc.nextInt();

            int totalMarks = ct + at + fe;
            double percentage = (totalMarks * 100.0) / 100;
            double gradePoint = 0;

            if (percentage >= 90) gradePoint = 4.0;
            else if (percentage >= 85) gradePoint = 3.7;
            else if (percentage >= 80) gradePoint = 3.5;
            else if (percentage >= 75) gradePoint = 3.0;
            else if (percentage >= 70) gradePoint = 2.7;
            else if (percentage >= 65) gradePoint = 2.3;
            else if (percentage >= 60) gradePoint = 2.0;
            else if (percentage >= 50) gradePoint = 1.0;
            else gradePoint = 0;

            totalCredits += credit;
            if (gradePoint > 0) totalEarnedCredits += credit;

            totalGradePoints += gradePoint * credit;
        }

        double cgpa = totalGradePoints / totalCredits;
        String grade = "";

        if (cgpa >= 3.7) grade = "A";
        else if (cgpa >= 3.5) grade = "A-";
        else if (cgpa >= 3.0) grade = "B+";
        else if (cgpa >= 2.7) grade = "B";
        else if (cgpa >= 2.3) grade = "B-";
        else if (cgpa >= 2.0) grade = "C+";
        else if (cgpa >= 1.0) grade = "C";
        else grade = "F";

        System.out.println("\nStudent ID: " + studentID);
        System.out.println("Credit Taken: " + totalCredits);
        System.out.println("Credit Earned: " + totalEarnedCredits);
        System.out.printf("CGPA: %.2f\n", cgpa);
        System.out.println("Grade: " + grade);

        sc.close();
    }
}
