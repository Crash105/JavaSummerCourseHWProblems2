import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GameSettings {

    private FileWriter writer;
    private File myObj;
    private int difficulty;
    private int maxstrikes;
    private String filename;

    public GameSettings() {

        Scanner input = new Scanner(System.in);
        System.out.println("What is your name");

        String playerName = input.nextLine();

        filename = playerName
                + "_save.dat";

        System.out.println(
                "Pick you level of difficulty:\n1 for Easy: 7 Strikes \n2 for Medium: 5 Strikes \n3 for Hard: 3 Strikes \n4 for Expert:  1 Strike");

        difficulty = input.nextInt();
        maxStrikes();
        setFileName();

    }

    public void setFileName() {
        try {

            String filepath = "C:\\Users\\Brian\\NumberGuesserJAVA\\JavaSummerCourseHWProblems2\\";

            myObj = new File(filepath, filename);
            // Create the file if it doesn't exist
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());

            } else {
                System.out.println("File already exists.");
                char c = (char) readFile();
                int charCode = Character.getNumericValue(c);
                maxstrikes = charCode;

            }
        } catch (IOException e) {
            System.out.println("An error occurred while creating the file.");
            e.printStackTrace();
        }

    }

    public void writeMethod(String name) {

        try {
            writer = new FileWriter(myObj);
            writer.write(name);
            writer.flush();

        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public int readFile() {

        int data = -1;

        try {
            FileReader fileReader = new FileReader(myObj);
            data = fileReader.read();
            return data;

        } catch (Exception e) {
            System.out.println(e);
        }

        return data;

    }

    private void maxStrikes() {

        if (difficulty == 1) {
            maxstrikes = 7;
        } else if (difficulty == 2) {
            maxstrikes = 5;
        } else if (difficulty == 3) {
            maxstrikes = 3;
        } else if (difficulty == 4) {
            maxstrikes = 1;
        }

    }

    public int getMaxStrikes() {
        return maxstrikes;
    }

}
