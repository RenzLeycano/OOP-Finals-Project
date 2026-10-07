import java.util.ArrayList;

public interface Strategy {
    public Result evaluate(ArrayList<Resume> sections, Job_Description jobDescription);
}
