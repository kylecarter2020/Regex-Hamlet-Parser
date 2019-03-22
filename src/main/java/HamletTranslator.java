
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HamletTranslator {

    public ArrayList<String> getSingleLines(String text){
        ArrayList<String> result = new ArrayList<>();

        Pattern pattern = Pattern.compile("[a-zA-Z](.*?)\n");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            result.add(matcher.group());
        }

        return result;
    }

    public String translateText(String text){
        List<String> singleLines = getSingleLines(text);
        String translatedText = "";

        for (String s : singleLines) {
            translatedText += translateLine(s);
        }

        return translatedText;
    }

    public String translateLine(String lineOfText){
        Integer leonOffset = "hamlet".length() - "leon".length();
        Integer tariqOffset = "horatio".length() - "tariq".length();
        String result = lineOfText;
        List<Integer> indices;
        if(findHamlet(result)){
            indices = getHamletStartIndices(result);
            for (int i = 0; i < indices.size(); i++) {
                result = changeHamletToLeon(result, indices.get(i)-(leonOffset*i));
            }
        }
        if(findHoratio(result)){
            indices = getHoratioStartIndices(result);
            for (int i = 0; i < indices.size(); i++) {
                result = changeHoratioToTariq(result, indices.get(i)-(tariqOffset*i));
            }
        }

        return result;
    }

    public Boolean findHoratio(String text){
        Pattern pattern = Pattern.compile(".*?((?i)horatio(?-i)).*?");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public Boolean findHamlet(String text){

        Pattern pattern = Pattern.compile(".*?((?i)hamlet(?-i)).*?");
        Matcher matcher = pattern.matcher(text);
        if(matcher.find()){
            return true;
        }
        return false;
    }

    public String changeHoratioToTariq(String text, Integer startIndex){
        StringBuilder result = new StringBuilder(text.substring(0, startIndex));
        if(allCaps(text, startIndex)){
            result.append("TARIQ");
        } else {
            result.append("Tariq");
        }
        result.append(text.substring(startIndex+"horatio".length()));

        return result.toString();
    }

    public String changeHamletToLeon(String text, Integer startIndex){
        StringBuilder result = new StringBuilder(text.substring(0, startIndex));
        if(allCaps(text, startIndex)){
            result.append("LEON");
        } else {
            result.append("Leon");
        }
        result.append(text.substring(startIndex+"hamlet".length()));

        return result.toString();
    }

    public Boolean allCaps(String text, Integer startIndex){
        if(Character.isUpperCase(text.charAt(startIndex+1))){
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getHoratioStartIndices(String text) {
        ArrayList<Integer> result = new ArrayList<>();
        //Pattern pattern = Pattern.compile(".*?((?i)horatio(?-i)).*?");
        Pattern pattern = Pattern.compile("((?i)horatio(?-i))");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            result.add(matcher.start());
        }
        return result;
    }

    public ArrayList<Integer> getHamletStartIndices(String text) {
        ArrayList<Integer> result = new ArrayList<>();
        Pattern pattern = Pattern.compile("((?i)hamlet(?-i))");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()){
            result.add(matcher.start());
        }
        return result;
    }
}
