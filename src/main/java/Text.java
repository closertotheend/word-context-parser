import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Text{
    private List<Sentence> sentences;

    public Text(String text) {
        SentenceDetectorME sentenceDetector = new SentenceDetectorME(getSentenceModel());
        String sentences[] = sentenceDetector.sentDetect(text);
        this.sentences = asList(sentences).stream().map(Sentence::new).collect(toList());
    }

    private SentenceModel getSentenceModel() {
        try (InputStream modelIn = new FileInputStream("en-sent.bin")){
            return new SentenceModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }
}
