import java.util.ArrayList;

public class QA_Analyzer {
    private ArrayList<Resume> sections;
    private  Job_Description jobDescription;
    private  ArrayList<Strategy> strategies;
    private int overallScore;

    public  QA_Analyzer(ArrayList<Resume> sections, Job_Description jobDescription){
        this.sections = sections;
        this.jobDescription = jobDescription;
        this.strategies = new ArrayList<>();
        strategies.add(new KeywordCheck());
        strategies.add(new FormatCheck());
        strategies.add(new CompletenessCheck());
        
    }

    public void analyzer(){
        jobDescription.extractKeywords();
        ArrayList<String> allMatched = new ArrayList<>();
        ArrayList<String> allMissing = new ArrayList<>();
        ArrayList<String> allSuggestions = new ArrayList<>();
        int totalScore = 0;

        for (Strategy strategy : strategies){
            Result result = strategy.evaluate(sections, jobDescription);
            System.out.println("------------------------------------------");
            result.display();

            totalScore += result.getScore();
            allMatched.addAll(result.getMatchedKeywords());
            allMissing.addAll(result.getMissingKeywords());
            allSuggestions.addAll(result.getSuggestions());
        }

        overallScore = totalScore / strategies.size();

        Result overallResult = new Result(overallScore, allMatched, allMissing, allSuggestions);
        System.out.println("-----------------------------------------");
        System.out.println("OVERALL RESULT");
        overallResult.display();
    }
}
