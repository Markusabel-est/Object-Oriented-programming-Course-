package quiz;

import java.util.*;

public class Game{
    private ArrayList<Question> questions;
    ArrayList<Question> incorrectQuestions;
    private int roundOneScore;
    private int roundTwoScore;
    private Scanner scanner;

    public Game(ArrayList<Question> questions){
        this.questions = questions;
        roundOneScore = 0;
        roundTwoScore = 0;
    }
    
    public void playRound1(){
        scanner = new Scanner(System.in);
        incorrectQuestions = new ArrayList<>();
        System.out.println("Round 1");
        for(Question question : questions){
            System.out.println(question);
            System.out.println("Answer:");

            String answer = scanner.nextLine();
            
            if(question.isCorrect(answer)){
               roundOneScore += question.getScore();
               System.out.println("Answer is correct.");
            }
            else{
                incorrectQuestions.add(question);
                System.out.println("Answer is incorrect.");
            }
            
        }
        scanner.close();
    }

    public void playRound2(){
        scanner = new Scanner(System.in);
        System.out.println("Round 2");
        for(Question question : incorrectQuestions){
            System.out.println(question);
            System.out.println("Answer:");
            String answer = scanner.nextLine();
            
            if(question.isCorrect(answer)){
               roundTwoScore += question.getScore();
            }
            else{
                System.out.println("Answer is incorrect.");
                System.out.println("Answer is correct.");
            }
        }
        System.out.println("Correct answers for each question.");
        for(int i = 0; i < questions.size(); i++){
            System.out.println(i + ") " + questions.get(i).correctAnswer());
        }
        System.out.println("Final round scores: Round 1 - " + roundOneScore);
        System.out.println("Final round scores: Round 2 - " + roundTwoScore);
        int total = roundOneScore + roundTwoScore;
        System.out.println("Total score - " + total);
        scanner.close();
    }
}