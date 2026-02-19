package student;

public class Student {
    private String firstName;
    private String lastName;
    private int stNumber;
    
    public Student (String fName, String lName, int sNum) {
        this.firstName = fName;
        this.lastName = lName;
        this.stNumber = sNum;
    }
    public void pstudent(){
        System.out.println(firstName + " " + lastName + ", s" + stNumber );
        
    }

    public int getstnum(){
        return stNumber;
    }
    public void changeNames(String s1, String s2 ){
        firstName = s1;
        lastName = s2;
    }
}
