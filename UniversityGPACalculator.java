import java.util.Scanner;

public class UniversityGPACalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("#####################################################");
        System.out.println();
        System.out.println("--------Welcome to the University of Vavuniya---------");
        System.out.println();
        System.out.println(" ----------Faculty of Technological Studies----------");
        System.out.println();
        System.out.println(" Department of Information and Communication Technology ");
        System.out.println();
        System.out.println(" GPA Calculator ");
        System.out.println();
        System.out.println("#####################################################");
        System.out.println();
        
        
        System.out.print("Enter the number of subjects: ");
        int numOfSubjects = scanner.nextInt();

        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 1; i <= numOfSubjects; i++) {
            System.out.println("\nSubject " + i + ":");

            System.out.print("Enter the subject name: ");
            String subjectName = scanner.next();

            System.out.print("Enter the number of credits for " + subjectName + ": ");
            int credits = scanner.nextInt();
            totalCredits += credits;

            System.out.print("Enter the grade for " + subjectName + " (A+,A, A-, B+, B, B-, C+, C, C-, D+, D, D-, E): ");
            String grade = scanner.next().toUpperCase();

            double gradePoints = getGradePoints(grade);
            totalGradePoints += gradePoints * credits;
        }

        double gpa = totalGradePoints / totalCredits ; 
        

        System.out.println("\nYour GPA is: " + gpa);

        scanner.close();
    }

    private static double getGradePoints(String grade) {
        switch (grade) {
            case "A+" :
                return 4.0;
            case "A" :
                return 4.0;
            case "A-":
                return 3.7;
            case "B+":
                return 3.3;
            case "B":
                return 3.0;
            case "B-":
                return 2.7;
            case "C+":
                return 2.3;
            case "C":
                return 2.0;
            case "C-":
                return 1.7;
            case "D+":
                return 1.3;
            case "D":
                return 1.0;
            case "D-":
                return 0.7;
            case "E":
                return 0.0;
            default:
                System.out.println("Invalid grade. Assuming grade as E (0.0)");
                return 0.0;
        }
    }
}
