import java.util.ArrayList;
import java.util.Arrays;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class KeywordCheck implements Strategy {
    @Override
    public Result evaluate(ArrayList<Resume> sections, Job_Description jobDescription) {
        StringBuilder resumeText = new StringBuilder();
        for (Resume section : sections) {
            resumeText.append(captureDisplay(section).toLowerCase()).append(" ");
        }

        ArrayList<String> resumeWords = new ArrayList<>(Arrays.asList(resumeText.toString().split("[^a-zA-Z]+")));
        ArrayList<String> keywords = jobDescription.getKeywords();
        ArrayList<String> matchedKeywords = new ArrayList<>();
        ArrayList<String> missingKeywords = new ArrayList<>();
        ArrayList<String> suggestions = new ArrayList<>();

        for (String keyword : keywords) {
            if (resumeWords.contains(keyword)) {
                matchedKeywords.add(keyword);
            } else {
                missingKeywords.add(keyword);
            }
        }

        int score;
        if (keywords.isEmpty()) {
            score = 0;
        } else {
            score = (int) ((matchedKeywords.size() / (double) keywords.size()) * 100);

        }

        if (!missingKeywords.isEmpty()) {
            suggestions.add("Consider adding these words: " + String.join(", ", missingKeywords));
        }

        return new Result(score, matchedKeywords, missingKeywords, suggestions);
    }

    private String captureDisplay(Resume section) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try{
            System.setOut(new PrintStream(buffer));
        section.display();
        } catch (Exception e){

        } finally{
            System.setOut(original);
        }
        return buffer.toString();
    }
}
