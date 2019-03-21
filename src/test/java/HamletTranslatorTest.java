import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class HamletTranslatorTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect Hamlet to change";
        Integer startIndex = 9;
        Integer endIndex = 14;
        String expected = "I expect Leon to change";

        //when
        String actual = translator.changeHamletToLeon(text, startIndex);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariq() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect Horatio to change";
        Integer startIndex = 9;
        Integer endIndex = 15;
        String expected = "I expect Tariq to change";

        //when
        String actual = translator.changeHoratioToTariq(text, startIndex);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testFindHoratio() {
        //given
        HamletTranslator translator = new HamletTranslator();

        //when
        String text = "I expect to find Horatio";

        //then
        Assert.assertTrue(translator.findHoratio(text));
    }

    @Test
    public void testFindHamlet() {
        //given
        HamletTranslator translator = new HamletTranslator();

        //when
        String text = "I expect to find Horatio";

        //then
        Assert.assertTrue(translator.findHamlet(text));
    }

    @Test
    public void testFindHoratioFalse() {
        //given
        HamletTranslator translator = new HamletTranslator();

        //when
        String text = "I expect not to find the word";

        //then
        Assert.assertFalse(translator.findHoratio(text));
    }

    @Test
    public void testFindHamletFalse() {
        //given
        HamletTranslator translator = new HamletTranslator();

        //when
        String text = "I expect not to find the word";

        //then
        Assert.assertFalse(translator.findHamlet(text));
    }

    @Test
    public void getSingleLinesText() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "This text\nhas multiple\nlines\n";
        String expected = "has multiple\n";

        //when
        String actual = translator.getSingleLines(text).get(1);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSingleLinesBySize() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "This text\nhas multiple\nlines\n";
        Integer expectedSize = 3;

        //when
        Integer actualSize = translator.getSingleLines(text).size();

        //then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void translateText() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect Horatio and HORATIO to change\n" +
                "I also expect Hamlet and HAMLET to change";
        String expected = "I expect Tariq and TARIQ to change\n" +
                "I also expect Leon and LEON to change";

        //when
        String actual = translator.translateText(text);

        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void translateLine() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect Horatio and HORATIO to change\n";
        String expected = "I expect Tariq and TARIQ to change\n";

        //when
        String actual = translator.translateLine(text);

        //then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void writeResultsToFile() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "This is the text I want in my file\n" +
                "if I dont see this text, I will be quite upset\n" +
                "because that means my test probably failed.";

        //when
        translator.writeResultsToFile(text);

        //then

    }

    @Test
    public void allCaps() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "HORATIO";

        //when
        Boolean result = translator.allCaps(text, 0);

        //then
        Assert.assertTrue(result);
    }

    @Test
    public void allCapsFalse() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "Hamlet";

        //when
        Boolean result = translator.allCaps(text, 0);

        //then
        Assert.assertFalse(result);
    }

    @Test
    public void getHoratioStartIndices() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "Horatio!\n" +
                "Yes HAMLET?\n" +
                "Let's go Horatio!\n";
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0,18));

        //when
        ArrayList<Integer> actual = translator.getHoratioStartIndices(text);

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getHamletStartIndices() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "Horatio!\n" +
                "Yes Hamlet?\n" +
                "Let's go HORATIO!\n";
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(15));

        //when
        ArrayList<Integer> actual = translator.getHamletStartIndices(text);

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getStartAndEndIndicesForOne() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "Hamlet! Let's go!\n";

    }
}