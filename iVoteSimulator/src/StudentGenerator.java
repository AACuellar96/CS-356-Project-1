import java.util.Random;

/**
 * Created by Adrian on 10/7/2016.
 */
public class StudentGenerator {
    // The list of randomly generated student ID's
    private String[] stIDList;

    public StudentGenerator() {
    }

    /**
     * Creates a list of student ID's to use
     * @return The new list containing all the student ID's.
     */
    public String[] generateList(){
        Random rng = new Random();
        int num = rng.nextInt(100)+1;
        if (num <= 10)
            num *= 10;
        else if (num <= 30)
            num *= 2;
        stIDList = new String[num];
        for (int place = 0; place < stIDList.length; place++) {
            int id = 0;
            for (int times = 0; times < 9; times++) {
                id += Math.pow(10, times) * rng.nextInt(10);
            }
            stIDList[place] += id;
        }
        return stIDList;
    }
}
