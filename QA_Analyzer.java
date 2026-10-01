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
        // strategies.add(new KeywordCheck());
        // strategies.add(new FormatCheck());
        // strategies.add(new CompletenessCheck());
        
    }
}
