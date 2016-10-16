/**
 * Created by Adrian on 10/6/2016.
 */
import java.util.ArrayList;

public class Question {
    // The actual question being asked.
    private String question;
    // The list of answers to this question.
    private ArrayList<String> ansList = new ArrayList<String>();

    public Question(String question,ArrayList<String> ansL){
        this.question=question;
        this.ansList=ansL;
    }

    /**
     * Returns question
     * @return The string question
     */
    public String getQuestion(){
        return question;
    }

    /**
     * Gets the list of answers
     * @return The ArrayList of answers.
     */
    public ArrayList<String> getAnswers(){
        return ansList;
    }

}
