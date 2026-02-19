package student;

public class Group {
    private Student[] all;
    private int numStud;
    
    public Group(int amount) {
        all = new Student[amount];
        numStud = 0;
    }
    
    public void addStudent (Student name, int place) {
        all[place] = name;
        numStud ++;
    }

    public void pgroup(){
        for(int j = 0; j < all.length; j++){
           all[j].pstudent();
        }
        
    }

    public Student[] getstudents(){
        return all;
    }

    public void updateStudents(Student[] s){
        all = s;
    }

}
