import opennlp.tools.namefind.TokenNameFinderModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SentenceAnalyzer {

    private TokenNameFinderModel getNameModel() {
        try (InputStream modelIn = new FileInputStream("en-ner-person.bin")){
            return new TokenNameFinderModel(modelIn);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
