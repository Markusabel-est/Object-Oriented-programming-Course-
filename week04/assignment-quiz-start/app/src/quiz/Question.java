package quiz;

abstract class Question{
    
    private int score;
    protected String question;
    protected String answer;

    public Question(String question, String answer, int score){
        this.question = question;
        this.answer = answer;
        this.score = score;

    }
    
    public abstract String toString();

    public abstract boolean isCorrect(String answer); 

    public abstract String correctAnswer();

    public int getScore (){
        return score;
    }

    public void setScore (int val){
        if (!(val <= 5) || !(val >= 1)){
            this.score = 3;
        } 
    }
}