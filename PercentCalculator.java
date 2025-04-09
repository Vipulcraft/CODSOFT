import java.util.Scanner;

public class PercentCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Obtained Marks (out of 100):");
        System.out.println("In Maths: ");
        int Maths = sc.nextInt();
        System.out.println("In Java: ");
        int Java = sc.nextInt();
        System.out.println("In Operating System: ");
        int OS = sc.nextInt();
        System.out.println("In Data Science: ");
        int DS = sc.nextInt();
        System.out.println("In Computer Networks: ");
        int CN = sc.nextInt();
        System.out.println("Subject Marks:-");
        System.out.println("Maths: " + Maths);
        System.out.println("Java: " + Java);
        System.out.println("Operatin System: " + OS);
        System.out.println("Data Science: " + DS);
        System.out.println("Computer Networks: " + CN);
        double TotalMarks = Maths + Java + OS + DS + CN;
        double Percent = (TotalMarks / 500) * 100;
        System.out.println("Total Marks: " + TotalMarks);
        System.out.println("Percentage: " + Percent + "%");
        if (Percent >= 90) {
            System.out.println("A+ Grade");
        }
         else if (Percent >= 80) {
            System.out.println("A Grade");
        }
         else if (Percent >= 70) {
            System.out.println("B Grade");
        }
         else if (Percent >= 60) {
            System.out.println("C Grade");
        }
         else if (Percent >= 50) {
            System.out.println("D Grade");
        }
        sc.close();
    }
}