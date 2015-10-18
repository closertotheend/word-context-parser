import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TextTest {

    @Test
    public void shouldParseSentenceIntoWords1() {
        String mock = "Barack Obama went to China yesterday.";
        Text text = new Text(mock);
        assertEquals(1, text.getSentences().size());
        Sentence barackObama = text.getSentences().get(0);
        List<Word> words = barackObama.getWords();
        assertEquals(7, words.size());
        assertEquals("Barack", words.get(0).getWord());
        assertEquals("Obama", words.get(1).getWord());
        assertEquals(".", words.get(6).getWord());
    }

    @Test
    public void shouldParseSentenceIntoWords2() {
        String mock = "Barack Obama went to China yesterday. He lives in Grand Hyatt Beijing. This is a superb hotel.";
        Text text = new Text(mock);
        assertEquals(3, text.getSentences().size());
        Sentence barackObama = text.getSentences().get(0);
        assertEquals(7, barackObama.getWords().size());
    }

}