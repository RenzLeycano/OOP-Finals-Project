import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Resume_Builder_Analyzer {
    static Scanner input = new Scanner(System.in);

    public static void main(String[]args){
        
        ArrayList<Resume> sections = new ArrayList<>(List.of(
            new PersonalInfo_Builder(),
            new Summary_Builder(),
            new Education_Builder(),
            new WorkXP_Builder(),
            new Skills_Builder(),
            new OptionalParts_Builder()
        ));

        System.out.println("===============================RESUME BUILDER AND ANALYZER===============================\n\n");

        for(Resume build : sections) {
            build.input();
        }

        System.out.println("=====================================RESUME PREVIEW======================================\n");

        for(Resume build : sections) {
            build.display();
        }

        // QA_Analyzer analyze;
        
        
        
    }
}
