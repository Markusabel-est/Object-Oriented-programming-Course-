package quiz;



class MultipleChoiceQuestion extends Question{
    
    protected String[] answers;
    int correctAnswer;

    public MultipleChoiceQuestion ( String question , String [] answers, int correctAnswer , int score){
        super(question, answers[correctAnswer], score);
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }
    public MultipleChoiceQuestion ( String question , String [] answers, int correctAnswer ){
        super(question, answers[correctAnswer], 3);
        this.answers = answers;
    }
    
    @Override
    public boolean isCorrect ( String answer ){
        String correctLetter = String.valueOf((char) ('a' + correctAnswer));
        return correctLetter.equalsIgnoreCase(answer); 
    }

    @Override
    public String correctAnswer (){
        return String.valueOf((char) ('a' + correctAnswer));
    }

    @Override
    public String toString(){
        String result = "";
        result += question + "\n";
        for(int i = 0; i < answers.length; i++){
            result += (char)('a' + i) + ")" + answers[i] + "\n";
        }
        return result;
    }

}