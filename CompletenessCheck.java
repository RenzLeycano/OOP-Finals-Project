import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CompletenessCheck implements  Strategy {
    private static final int REQUIRED_SECTIONS = 5;

    @Override 
    public Result evaluate(ArrayList<Resume> sections, Job_Description jobDescription){
        ArrayList<String> matchedKeywords = new ArrayList<>();
        ArrayList<String> missingKeywords = new ArrayList<>();
        ArrayList<String> suggestions = new ArrayList<>();
        int filled = 0; int requiredFound = 0;

        for (Resume section : sections) {
            if (section instanceof OptionalParts_Builder) {
                continue;
            }
            requiredFound++;

            if (isFilled(captureDisplay(section))) {
                filled++;
            } else {
                suggestions.add("Complete the " + section.getClass().getSimpleName() + " section");
            }
        }

        if (requiredFound < REQUIRED_SECTIONS){
            suggestions.add("Some required sections have not been added to the resume");
        }

        int score = Math.min((int) ((filled / (double)REQUIRED_SECTIONS) * 100), 100);

        if (suggestions.isEmpty()) {
            suggestions.add("All required sections are present");
        }

        

        return new Result(score, matchedKeywords, missingKeywords, suggestions);
    }

    private boolean isFilled(String content){
        if (content.contains("Unknown") || content.contains("Empty")) {
            return false;
        }

        int lineCount = 0;
        for (String line: content.split("\n")){
            if (!line.trim().isEmpty()){
                lineCount++;
            }
        }
        return lineCount > 1;
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
