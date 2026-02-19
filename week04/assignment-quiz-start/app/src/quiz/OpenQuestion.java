package quiz;

class OpenQuestion extends Question{
    
   
    public OpenQuestion ( String question , String answer , int score){
        super(question, answer, score);
    }
    
    public OpenQuestion ( String question , String answer ){
        super(question, answer, 3);
    }

    @Override
    public boolean isCorrect ( String answer ){
        return answer.equalsIgnoreCase(this.answer);
    }

    @Override
    public String correctAnswer (){
        return answer;

    }
    
    @Override
    public String toString() {
        return question;
    }
}