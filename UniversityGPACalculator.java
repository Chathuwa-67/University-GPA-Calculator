import java.util.Scanner;

class Student {
    private String name;
    private int indexNumber;

    public Student(String name, int indexNumber) {
        this.name = name;
        this.indexNumber = indexNumber;
    }

    public String getName() {
        return name;
    }

    public int getIndexNumber() {
        return indexNumber;
    }
}

class AcademicYear {
    private int year;

    public AcademicYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }
}

class Semester {
    private int semester;

    public Semester(int semester) {
        this.semester = semester;
    }

    public int getSemester() {
        return semester;
    }
}

class Subject {
    private static final String[][] subjectNames = {
            {"Essentials of ICT", "Mathematics for Technology", "Fundamentals of Computer Programming", "Fundamentals of Web Technologies ", "Principles of Management ", "English Language I "},
            {"SubjectA2", "SubjectB2", "SubjectC2", "SubjectD2", "SubjectE2", "SubjectF2"},
            {"SubjectA3", "SubjectB3", "SubjectC3", "SubjectD3", "SubjectE3", "SubjectF3"},
            {"SubjectA4", "SubjectB4", "SubjectC4", "SubjectD4", "SubjectE4", "SubjectF4"}
    };

    private static final int[][] subjectCodes = {
            {1114, 1123, 1134, 1142, 1152, 1110},
            {201, 202, 203, 204, 205, 206},
            {301, 302, 303, 304, 305, 306},
            {401, 402, 403, 404, 405, 406}
    };

    public String getSubjectName(int year, int semester, int subjectIndex) {
        return subjectNames[year][semester * 2 + subjectIndex];
    }

    public int getSubjectCode(int year, int semester, int subjectIndex) {
        return subjectCodes[year][semester * 2 + subjectIndex];
    }

    public int getSubjectCredit(int subjectCode) {
        return subjectCode % 10;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("########################################################");
        System.out.println();
        System.out.println("--------Welcome to the University of Vavuniya---------");
        System.out.println();
        System.out.println(" ----------Faculty of Technological Studies----------");
        System.out.println();
        System.out.println(" Department of Information and Communication Technology ");
        System.out.println();
        System.out.println("\t\tGPA Calculator ");
        System.out.println();
        System.out.println("########################################################");

        // Get student information
        System.out.print("\nEnter student name: ");
        String studentName = scanner.nextLine();
        System.out.print("\nEnter student index number: ");
        int indexNumber = scanner.nextInt();

        Student student = new Student(studentName, indexNumber);

        // Get academic year
        System.out.print("\nSelect academic year (1-4): ");
        int selectedYear = scanner.nextInt();
        AcademicYear academicYear = new AcademicYear(selectedYear - 1);

        // Get semester
        System.out.print("\nSelect semester (1-2): ");
        int selectedSemester = scanner.nextInt();
        Semester semester = new Semester(selectedSemester - 1);

        // Display subjects
        Subject subjects = new Subject();
        for (int i = 0; i < 6; i++) {
            String subjectName = subjects.getSubjectName(selectedYear - 1, selectedSemester - 1, i);
            int subjectCode = subjects.getSubjectCode(selectedYear - 1, selectedSemester - 1, i);
            int subjectCredit = subjects.getSubjectCredit(subjectCode);

           // System.out.println("Enter result for " + subjectName + " (Credit: " + subjectCredit + "): ");
            // Get user input for results (grades, etc.)
            // You can implement this part based on your requirements
        }

        // Calculate GPA and display results
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (int i = 0; i < 6; i++) {
            String subjectName = subjects.getSubjectName(selectedYear - 1, selectedSemester - 1, i);
            int subjectCode = subjects.getSubjectCode(selectedYear - 1, selectedSemester - 1, i);
            int subjectCredit = subjects.getSubjectCredit(subjectCode);

            System.out.print("\nEnter grade for " + subjectName + ": ");
            String grade = scanner.next();

            double gradePoint = calculateGradePoint(grade);
            totalCredits += subjectCredit;
            totalGradePoints += gradePoint * subjectCredit;
        }

        // Calculate GPA
        double gpa = totalGradePoints / totalCredits;

        // Display results
        
        System.out.println("########################################################");
        System.out.println();
        System.out.println("\nStudent Information:");
        System.out.println("\nName: " + student.getName());
        System.out.println("\nIndex Number: " + student.getIndexNumber());
        System.out.println("\nAcademic Year: " + academicYear.getYear()+1);
        System.out.println("\nSemester: " + semester.getSemester()+1);
        

        // System.out.println("\nSubject-wise GPA:");

        // for (int i = 0; i < 6; i++) {
        //     String subjectName = subjects.getSubjectName(selectedYear - 1, selectedSemester - 1, i);
        //     int subjectCode = subjects.getSubjectCode(selectedYear - 1, selectedSemester - 1, i);
        //     int subjectCredit = subjects.getSubjectCredit(subjectCode);

        //     System.out.println(subjectName + ": " + calculateGradePoint(scanner.next()));
        // }

        System.out.println("\nTotal GPA: " + gpa);
        System.out.println("########################################################");
        System.out.println();

        scanner.close();
    }

    private static double calculateGradePoint(String grade) {
        switch (grade) {
            case "A+":
                return 4.0;
            case "A":
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
                System.out.println("Invalid grade. Assuming grade point as 0.0.");
                return 0.0;
        }
    }
}
