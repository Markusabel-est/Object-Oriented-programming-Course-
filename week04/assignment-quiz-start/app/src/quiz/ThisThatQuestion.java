package quiz;

class ThisThatQuestion extends MultipleChoiceQuestion{
    
    public ThisThatQuestion ( String question , String answer1 , String answer2 , int correctAnswer , int score){
        super(question, new String[]{answer1, answer2} , correctAnswer, score);
    }

    public ThisThatQuestion ( String question , String answer1 , String answer2 , int correctAnswer ){
        super(question,new String[]{answer1, answer2}, correctAnswer, 3 );
    }
    
    @Override
    public boolean isCorrect(String answer) {
        return answer.equalsIgnoreCase(this.answer);
    }

    @Override
    public String correctAnswer() {
        return answer;
    }

    @Override
    public String toString() {
        return answers[1] + " or " + answers[2] + " : " + question;
    }
}