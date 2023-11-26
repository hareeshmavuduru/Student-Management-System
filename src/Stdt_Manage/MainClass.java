package Stdt_Manage;
import java.util.Scanner;
public class MainClass {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);

        StudentInterface dao=new StudentData();
        System.out.println("Welcome to Student Management application");
        while(true){
            System.out.println("\nPress 1 - Add Student" +
                    "\nPress 2 - Show All Students" +
                    "\nPress 3 - Get student based on roll number" +
                    "\nPress 4 - Delete Student"+
                    "\nPress 5 - Update Student" +
                    "\nPress 6 - Exit");
            System.out.print("\nEnter Your Option : ");
            int ch=sc.nextInt();
            switch (ch){
                case 1:
                    System.out.println("\n1.Add Student");
                    System.out.print("\nEnter ID : ");
                    int rollNum=sc.nextInt();
                    System.out.print("\nEnter Student Name : ");
                    String name=sc.next();
                    System.out.print("\nEnter Student College Name : ");
                    String clgName=sc.next();
                    System.out.print("\nEnter City : ");
                    String city=sc.next();
                    System.out.print("\nEnter Percentage : ");
                    double percentage=sc.nextDouble();
                    Student st=new Student(rollNum,name,clgName,city,percentage);
                    boolean ans=dao.insertStudent(st);
                    if(ans)
                        System.out.println("\nRecord inserted Successfully!!!");
                    else
                        System.out.println("\nsomething went wrong, please try again");

                    break;
                case 2:
                    System.out.println("\n2.Show All Students ");
                    dao.showAllStudent();

                    break;
                case 3:
                    System.out.println("\n3.Get Student based on Rollnumber");
                    System.out.print("Enter roll number : ");
                    int roll=sc.nextInt();
                  boolean f=  dao.showStudentById(roll);
                  if(!f)
                      System.out.println("Student with this id is not available in our system");

                    break;
                case 4:
                    System.out.println("\n4.Delete Student");
                    System.out.print("\nEnter roll number to delete : ");
                    int rollnum=sc.nextInt();
                    boolean ff=dao.delete(rollnum);
                    if(ff)
                        System.out.println("\nRecord deleted successfully...");
                    else
                        System.out.println("\nSomething went wrong");
                    break;
                case 5:
                    System.out.print("\n5.Update the student");
                    System.out.println("\n1.Update name\n2.Update clgName");
                    System.out.println("\nEnter your choice");
                    int choice=sc.nextInt();
                    if(choice==1){
                        System.out.println("\nEnter roll number");
                        int rnum=sc.nextInt();
                        System.out.println("\nEnter new name");
                        String sname=sc.next();
                        Student std=new Student();
                        std.setName(sname);
                      boolean flag=  dao.update(rnum,sname,choice,std);
                      if(flag)
                          System.out.println("\nName updated successfully");
                      else
                          System.out.println("\nSomething went wrong...");
 }
                    break;
                case 6:
                    System.out.println("\nThank You fro using Student management application!!!");
                    System.exit(0);
                default:
                    System.out.println("\nPlease enter valid choice..");
            }
        }

	}
	
}
