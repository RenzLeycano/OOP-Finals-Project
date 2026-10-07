import java.util.ArrayList;
import java.util.Arrays;

public class Job_Description {
    private ArrayList<String> keywords;
    private String description;

    public Job_Description(String description) {
        this.description = description;
        this.keywords = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void extractKeywords() {
        keywords.clear();

        ArrayList<String> stopWords = new ArrayList<>(Arrays.asList("the", "and", "with", "for", "are", "you", "our",
                "will", "have", "has", "this", "that", "job", "role", "work"));

        String[] words = description.toLowerCase().split("[^a-zA-Z]+");

        for (String word : words) {
            if (word.length() > 3 && !stopWords.contains(word)) {
                keywords.add(word);
            }
        }
    }

}
