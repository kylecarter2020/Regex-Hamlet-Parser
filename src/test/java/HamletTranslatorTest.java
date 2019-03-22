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
    public void testChangeHamletToLeonUpper() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect HAMLET to change";
        Integer startIndex = 9;
        Integer endIndex = 14;
        String expected = "I expect LEON to change";

        //when
        String actual = translator.changeHamletToLeon(text, startIndex);

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testChangeHoratioToTariqUpper() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "I expect HORATIO to change";
        Integer startIndex = 9;
        Integer endIndex = 15;
        String expected = "I expect TARIQ to change";

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
        String text = "I expect to find Hamlet";

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
                "I also expect Hamlet and HAMLET to change\n";
        String expected = "I expect Tariq and TARIQ to change\n" +
                "I also expect Leon and LEON to change\n";

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
        String text = "Horatio!\nYes HAMLET?\nLet's go Horatio!\n";
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0,30));

        //when
        ArrayList<Integer> actual = translator.getHoratioStartIndices(text);

        //then
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getHamletStartIndices() {
        //given
        HamletTranslator translator = new HamletTranslator();
        String text = "Horatio!\nYes Hamlet?\nLet's go HORATIO!\n";
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(13));

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