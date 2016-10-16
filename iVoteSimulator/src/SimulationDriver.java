/**
 * Created by Adrian on 10/6/2016.
 */
import java.util.Random;

public class SimulationDriver{

    public static void main(String args[]){
        IVoteService iVS = new IVoteService();

        StudentGenerator sG = new StudentGenerator();
        String[] stIDList = sG.generateList();
        QuestionGenerator qG = new QuestionGenerator();
        iVS.createQuestion(qG.generateQuestion(),qG.generateAnswers());

        for(int size=0;size<stIDList.length;size++) {
            Random rand = new Random();
            char ans = 'A';
            ans += rand.nextInt(iVS.getAnsList().size());
            iVS.submitVote(stIDList[size],ans);
        }
        System.out.println("There are " + stIDList.length + " students voting for the question :" + iVS.getQuestion());
        iVS.voteTally();

    }
}
