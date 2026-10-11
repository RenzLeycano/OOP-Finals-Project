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
        
        System.out.println("Would you like to edit any section? (Y/N)");
        char choice = Character.toUpperCase(input.next().charAt(0));input.nextLine();

        if (choice == 'Y') {
            for(Resume change : sections){
                change.edit();
                change.display();
            }
        }
        
        System.out.println("Would you like to analyze this resume against a job description? (Y/N)");
        char analyze_choice = Character.toUpperCase(input.next().charAt(0));input.nextLine();
        
        if (analyze_choice == 'Y') {
            System.out.println("===================================JOB DESCRIPTION=======================================\\n");
            System.out.println("Paste or type the job description below.");
            System.out.println("Type 'END' on a new line when finished.");

            StringBuilder text = new StringBuilder();
            while (true) {
                String line = input.nextLine();
                if (line.trim().equalsIgnoreCase("END")) {
                    break;
                }
                text.append(line).append("\n");
            }
            Job_Description jobDescription = new Job_Description(text.toString());
            QA_Analyzer analyze = new QA_Analyzer(sections, jobDescription);
            analyze.analyzer();
        }

    }
}
