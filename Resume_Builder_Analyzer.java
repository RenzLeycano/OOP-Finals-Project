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
        
        System.out.print("\nWould you like to edit any section? (Y/N): ");
        char choice = Character.toUpperCase(input.next().charAt(0));input.nextLine();

        if (choice == 'Y') {
            Boolean editSection = true;
            while (editSection) {
                System.out.println("Please type the corresponding number of the information you want to edit:");
                System.out.println("\t[1] Personal Information\n\t[2] Resume Summary \n\t[3] Education\n\t[4] Work Experience\n\t[5] Skills\n\t[6] Optional Section (projects, certifications, awards, training/seminars, volunteer experience, and references) \n\t[7] Preview Resume \n\t[8] Exit Editing");

                System.out.print("Edit: ");
                switch(input.nextLine()) {
                    case "1":
                        sections.get(0).edit();
                        break;
                    case "2":
                        sections.get(1).edit();
                        break;
                    case "3":
                        sections.get(2).edit();
                        break;
                    case "4":
                        sections.get(3).edit();
                        break;
                    case "5":
                        sections.get(4).edit();
                        break;
                    case "6":
                        sections.get(5).edit();
                        break;
                    case "7":
                        for(Resume build : sections) {
                            build.display();
                        }
                        break;
                    case "8":
                        editSection = false;
                        break;
                }
            }
            
        }
        
        System.out.print("\nWould you like to analyze this resume against a job description? (Y/N): ");
        char analyze_choice = Character.toUpperCase(input.next().charAt(0));input.nextLine();
        
        if (analyze_choice == 'Y') {
            System.out.println("===================================JOB DESCRIPTION=======================================\n");
            System.out.println("Paste or type the job description below.");
            System.out.println("(e.g. copied directly from a job posting on Linkedin, etc");
            System.out.println("Type 'END' on a new line when finished.\n");

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
        System.out.println("\nThank you for using Resume Builder and Analyzer.");

    }
}
