import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public class Sentence {
    private List<Word> words;

    public Sentence(String words) {
        Tokenizer tokenizer = new TokenizerME(getTokenModel());
        this.words = asList(tokenizer.tokenize(words)).stream().map(Word::new).collect(toList());
    }

    private TokenizerModel getTokenModel() {
        try (InputStream modelIn = new FileInputStream("en-token.bin")){
            return new TokenizerModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Word> getWords() {
        return words;
    }

}
