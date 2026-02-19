// Markus Abel s1148847
// Björn Smith s1135336

package student;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        welcome();
    }
    
    public static void welcome() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome, how big do you want the group to be?");
        int size = scan.nextInt();

        Group myGroup = new Group(size);


        Student nstudent;
        for(int j = 0; j < size; j++){
            System.out.println("Please enter student number");
            int snumber = scan.nextInt();

            System.out.println("Please enter student first name");
            String sfname = scan.next();

            System.out.println("Please enter student last name");
            String slname = scan.next();

            nstudent = new Student(sfname, slname, snumber);

            myGroup.addStudent(nstudent, j);
        }
        myGroup.pgroup();

       int snum = 0;
       Student[] newarr = myGroup.getstudents();
       boolean foundstud;
        while (snum >= 0 ){
            foundstud = false;
            System.out.println("Please enter a student number");
            snum = scan.nextInt();
            if(snum >= 0){
                System.out.println("Please enter a new student first name");
                String snfname = scan.next();

                System.out.println("Please enter new student last name");
                String snlname = scan.next();
                
                for(int j = 0; j < size; j++){
                    if (newarr[j].getstnum() == snum ) {
                        newarr[j].changeNames(snfname, snlname);
                        foundstud = true;
                        myGroup.updateStudents(newarr);
                    }
                }

                if (foundstud==false){
                    System.out.println("Cant find student");
                }
               

            }

            myGroup.pgroup();
                
        }
        
    }

    
}
