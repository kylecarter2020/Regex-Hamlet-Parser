import java.util.ArrayList;
import java.util.List;

public class HamletTranslator {
    private HamletParser hamletParser;
    private String hamletText;
    private List<String> singleHamletLines;
    private StringBuilder translatedText;

    public HamletTranslator(){
        hamletParser = new HamletParser();
        hamletText = hamletParser.getHamletData();
        singleHamletLines = new ArrayList<>();
        translatedText = new StringBuilder();
    }

    public ArrayList<String> getSingleLines(String text){
        return null;
    }

    public String translateText(String text){
        return null;
    }

    public String translateLine(String lineOfText){
        return null;
    }

    public void writeResultsToFile(String text){

    }

    public Boolean findHoratio(String text){
        return null;
    }

    public Boolean findHamlet(String text){
        return null;
    }

    public List<Integer> getStartAndEndIndex(String word){
        return null;
    }

    public String changeHoratioToTariq(String text, Integer startIndex){
        return null;
    }

    public String changeHamletToLeon(String text, Integer startIndex){
        return null;
    }

    public Boolean allCaps(String text, Integer startIndex){
        return false;
    }

    public ArrayList<Integer> getHoratioStartIndices(String text) {
        return null;
    }

    public ArrayList<Integer> getHamletStartIndices(String text) {
        return null;
    }
}
