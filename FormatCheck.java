import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FormatCheck implements Strategy{
    private static final int MIN_SECTION_LENGTH = 15;

    @Override 
    public Result evaluate(ArrayList<Resume> sections, Job_Description jobDescription){
        ArrayList<String> matchedKeywords = new ArrayList<>();
        ArrayList<String> missingKeywords = new ArrayList<>();
        ArrayList<String> suggestions = new ArrayList<>();
        int score = 100;

        for (Resume section: sections) {
            String content = captureDisplay(section);

            if (content.trim().length() < MIN_SECTION_LENGTH) {
                score -= 10;
                suggestions.add("Consider expanding the section with more detail");
            }
        }

        score = Math.max(score, 0);
        return new Result(score, matchedKeywords, missingKeywords, suggestions);
    }

    private String captureDisplay(Resume section) {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(buffer));
        section.display();
        System.setOut(original);
        return buffer.toString();
    }
}
