import java.util.Scanner;

class Subject {
    private String subjectName;
    private int subjectCode;

    public Subject(String subjectName, int subjectCode) {
        this.subjectName = subjectName;
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getSubjectCode() {
        return subjectCode;
    }
}

class Semester {
    private Subject[] subjects;

    public Semester(Subject[] subjects) {
        this.subjects = subjects;
    }

    public Subject[] getSubjects() {
        return subjects;
    }
}

class AcademicYear {
    private Semester[] semesters;

    public AcademicYear(Semester[] semesters) {
        this.semesters = semesters;
    }

    public Semester[] getSemesters() {
        return semesters;
    }
}

class Student {
    private String name;
    private String indexNumber;
    private AcademicYear[] academicYears;

    public Student(String name, String indexNumber, AcademicYear[] academicYears) {
        this.name = name;
        this.indexNumber = indexNumber;
        this.academicYears = academicYears;
    }

    public String getName() {
        return name;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public AcademicYear[] getAcademicYears() {
        return academicYears;
    }
}

public class UniversityGPACalculatorOOP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student index number: ");
        String indexNumber = scanner.nextLine();

        AcademicYear[] academicYears = createAcademicYears();

        Student student = new Student(studentName, indexNumber, academicYears);

        double finalGPA = calculateFinalGPA(student);

        System.out.println("\nStudent Name: " + student.getName());
        System.out.println("Index Number: " + student.getIndexNumber());

        for (int i = 0; i < academicYears.length; i++) {
            System.out.println("\nAcademic Year " + (i + 1) + ":");

            AcademicYear academicYear = academicYears[i];

            for (int j = 0; j < academicYear.getSemesters().length; j++) {
                System.out.println("\nSemester " + (j + 1) + ":");
                Semester semester = academicYear.getSemesters()[j];
                double semesterGPA = calculateSemesterGPA(semester);
                System.out.println("Semester GPA: " + semesterGPA);
            }
        }

        System.out.println("\nFinal GPA: " + finalGPA);

        scanner.close();
    }

    private static AcademicYear[] createAcademicYears() {
        // Create subjects
        Subject[] subjects = new Subject[8];
        subjects[0] = new Subject("Subject1", 101);
        subjects[1] = new Subject("Subject2", 102);
        subjects[2] = new Subject("Subject3", 103);
        subjects[3] = new Subject("Subject4", 104);
        subjects[4] = new Subject("Subject5", 105);
        subjects[5] = new Subject("Subject6", 106);
        subjects[6] = new Subject("Subject7", 107);
        subjects[7] = new Subject("Subject8", 108);

        // Create semesters
        Semester[] semesters = new Semester[8];
        semesters[0] = new Semester(new Subject[]{subjects[0], subjects[1]});
        semesters[1] = new Semester(new Subject[]{subjects[2], subjects[3]});
        semesters[2] = new Semester(new Subject[]{subjects[4], subjects[5]});
        semesters[3] = new Semester(new Subject[]{subjects[6], subjects[7]});
        semesters[4] = new Semester(new Subject[]{subjects[0], subjects[2]});
        semesters[5] = new Semester(new Subject[]{subjects[4], subjects[6]});
        semesters[6] = new Semester(new Subject[]{subjects[1], subjects[3]});
        semesters[7] = new Semester(new Subject[]{subjects[5], subjects[7]});

        // Create academic years
        AcademicYear[] academicYears = new AcademicYear[4];
        academicYears[0] = new AcademicYear(new Semester[]{semesters[0], semesters[1]});
        academicYears[1] = new AcademicYear(new Semester[]{semesters[2], semesters[3]});
        academicYears[2] = new AcademicYear(new Semester[]{semesters[4], semesters[5]});
        academicYears[3] = new AcademicYear(new Semester[]{semesters[6], semesters[7]});

        return academicYears;
    }

    private static double calculateSemesterGPA(Semester semester) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (Subject subject : semester.getSubjects()) {
            int subjectCode = subject.getSubjectCode();
            int credit = subjectCode % 10; // Extract last digit for credit
            totalCredits += credit;

            // For simplicity, assuming grade as 'A' for all subjects
            double gradePoints = getGradePoints('A');
            totalGradePoints += gradePoints * credit;
        }

        return totalGradePoints / totalCredits;
    }

    private static double calculateFinalGPA(Student student) {
        double totalCredits = 0;
        double totalGradePoints = 0;

        for (AcademicYear academicYear : student.getAcademicYears()) {
            for (Semester semester : academicYear.getSemesters()) {
                for (Subject subject : semester.getSubjects()) {
                    int subjectCode = subject.getSubjectCode();
                    int credit = subjectCode % 10; // Extract last digit for credit
                    totalCredits += credit;

                    // For simplicity, assuming grade as 'A' for all subjects
                    double gradePoints = getGradePoints('A');
                    totalGradePoints += gradePoints * credit;
                }
            }
        }

        return totalGradePoints / totalCredits;
    }

    private static double getGradePoints(char grade) {
        // Implement your grading logic here
        switch (grade) {
            case 'A':
                return 4.0;
            // Add more cases for other grades as needed
            default:
                return 0.0;
        }
    }
}
