/**
 * Created by Adrian on 10/6/2016.
 */
public class Student {
    // The students unique student ID
    private String studentID;
    // The vote being submitted by the student
    private char vote;

    public Student(String studentID,char vote){
        this.studentID=studentID;
        this.vote=vote;
    }

    /**
     * Changes the student's vote
     * @param vote
     */
    public void changeVote(char vote){
        this.vote=vote;
    }

    /**
     * Gets the students vote
     * @return The students vote
     */
    public char getVote(){
        return vote;
    }

    /**
     * Gets the students ID
     * @return The students ID
     */
    public String getSID(){
        return studentID;
    }
}
