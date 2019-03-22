import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        HamletTranslator hamletTranslator = new HamletTranslator();

        String hamletText = hamletParser.getHamletData();
        String translatedHamlet = hamletTranslator.translateText(hamletText);

        try {
            File file = new File("/Users/kylecarter/Dev/Projects/Regex-Hamlet-Parser/src/main/resources/translatedHamlet.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(translatedHamlet);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
