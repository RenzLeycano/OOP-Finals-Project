import java.util.ArrayList;

public class Result {
    private int score;
    private ArrayList<String> matchedKeywords;
    private ArrayList<String> missingKeywords;
    private ArrayList<String> suggestions;

    public Result(int score, ArrayList<String> matchedKeywords, ArrayList<String> missingKeywords,
            ArrayList<String> suggestions) {
        this.score = score;
        this.matchedKeywords = matchedKeywords;
        this.missingKeywords = missingKeywords;
        this.suggestions = suggestions;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getMatchedKeywords() {
        return matchedKeywords;
    }

    public ArrayList<String> getMissingKeywords() {
        return missingKeywords;
    }

    public ArrayList<String> getSuggestions() {
        return suggestions;
    }

    public void display() {
        System.out.println("Score: " + score + "%");

        if (!matchedKeywords.isEmpty()) {
            System.out.println("Matched Keywords: " + String.join(", ", matchedKeywords));
        }

        if (!missingKeywords.isEmpty()) {
            System.out.println("Missing Keywords: " + String.join(",", missingKeywords));
        }

        if (!suggestions.isEmpty()) {
            System.out.println("Suggestions: ");
            for (String suggest : suggestions) {
                System.out.println(" " + suggest);
            }
        }
    }
}
