import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Adrian on 10/7/2016.
 */
public class QuestionGenerator {
    private Random rand;
    // Int determining the type of question being created
    private int qType;

    public QuestionGenerator(){
        rand = new Random();
        qType=-1;
    }

    /**
     * Generates the number 1 or 2 and creates a question string based on that.
     * @return The question
     */
    public String generateQuestion(){
        qType = rand.nextInt(2);
        if (qType ==0)
            return "Multiple choice question.";
        else
            return "Single choice question.";
    }

    /**
     * Generates default answers based on question
     * @return The list of answers for the question
     */
    public ArrayList<String> generateAnswers(){
        ArrayList<String> ans;
            if(qType==0){
                ans = new ArrayList(Arrays.asList("A","B","C","D","E"));
            }
            else{
                ans = new ArrayList(Arrays.asList("Choice 1","Choice 2"));
            }
            return ans;
    }
}
