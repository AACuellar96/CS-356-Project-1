import java.util.ArrayList;

public class IVoteService {
    // The current question being asked
    private Question question;
    // The amount of submissions or votes for each answer
    private int[] submissions;
    // The list of students currently answering the question.
    private HashTable studList;

    public IVoteService(){
        studList=new HashTable();
    }

    /**
     * Submits a vote from a student
     * @param studentID The student submitting a vote
     * @param vote The students answer or vote.
     */
    public void submitVote(String studentID,char vote){
        if(question==null)
            return;
        if(studList.get(studentID)!=null) {
            char prevAns=studList.get(studentID).getVote();
            studList.get(studentID).changeVote(vote);
            int dec=prevAns-65;
            int inc=vote-65;
            submissions[dec]--;
            submissions[inc]++;
        }
         else {
            Student student = new Student(studentID,vote);
            studList.put(studentID, student);
            int inc= vote-65;
            submissions[inc]++;
        }
    }

    /**
     * Gets the question being asked.
     * @return The string question
     */
    public String getQuestion(){
        return question.getQuestion();
    }

    /**
     *  'Creates' a question and processes it.
     * @param question The question being created
     * @param ansL The list of answers to question.
     */
    public void createQuestion(String question,ArrayList<String> ansL){
        this.question = new Question(question,ansL);
        submissions = new int[ansL.size()];
        studList.wipe();

    }

    /**
     *  Tallies the amounts of votes in submissions for each answer and prints them.
     */
    public void voteTally(){
        ArrayList<String> ans = question.getAnswers();
        for(int size=0;size<submissions.length;size++) {
            System.out.println( ans.get(size) + " -- " + submissions[size]);
        }
    }

    /**
     * Gets the list of answers.
     * @return The ArrayList of the answers to question.
     */
    public ArrayList<String> getAnsList(){
        return question.getAnswers();
    }

}
