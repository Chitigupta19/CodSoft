import java.util.Scanner;

public class StudentGradeCalculator {
    public StudentGradeCalculator() {
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total number of subjects:");
        int numberOfSubjects = sc.nextInt();
        int totalMarks = 0;
        int[] marks = new int[numberOfSubjects];

        for(int i = 0; i < numberOfSubjects; ++i) {
            System.out.println("Enter the marks of " + (i + 1) + " subject (out of 100) :");
            marks[i] = sc.nextInt();
            totalMarks += marks[i];
        }

        System.out.println("Total marks :" + totalMarks);
        double avgPercentage = (double)totalMarks / (double)numberOfSubjects;
        System.out.println("Average Percentage:" + avgPercentage + "%");
        char grade;
        if (avgPercentage >= 90.0) {
            grade = 'A';
        } else if (avgPercentage >= 75.0) {
            grade = 'B';
        } else if (avgPercentage >= 60.0) {
            grade = 'C';
        } else if (avgPercentage >= 50.0) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        System.out.println("Grade:" + grade);
    }
}