import java.util.ArrayList;
import java.util.Arrays;

public class Education_Builder implements Resume {
    private String finishedEduc;
    private ArrayList<String> degree;
    private ArrayList<String> school;
    private ArrayList<Integer> startYear;
    private ArrayList<Integer> gradYear;
    private ArrayList<String> acadAchievements;
    private ArrayList<String> coursework;
    
    public Education_Builder(){
        this.finishedEduc = "Unknown";
        this.degree = null;
        this.school = null;
        this.startYear = 0;
        this.gradYear = 0;
        this.acadAchievements = null;
        this.coursework = null;
    }

    public void input(){

        // finishedEduc - Education Attainment
        System.out.println("What is your highest education attainment?");
        System.out.println("\t[1] Junior High School\n\t[2] Senior High School\n\t[3] College Undergraduate\n\t[4] Bachelor's Degree\n\t[5]\n\t[6] Doctorate's Degree");

        // Initializes a variable to keep the loop running if input is invalid

        boolean validChoice = true;
        String educChoice;
        do {
            System.out.print("Enter a value (1 - 6):");
            educChoice = input.nextLine();

            // Provides finishedEduc based on user input

            switch (educChoice) {
                case "1":
                    this.finishedEduc = "Junior High School";
                    break;
                case "2":
                    this.finishedEduc = "Senior High School";
                    break;
                case "3":
                    this.finishedEduc = "College Undergraduate";
                    break;
                case "4":
                    this.finishedEduc = "Bachelor's Degree";
                    break;
                case "5":
                    this.finishedEduc = "Master's Degree";
                    break;
                case "6":
                    this.finishedEduc = "Doctorate's Degree";
                    break;
                default:
                    System.out.println("Please enter a number between 1 - 6 ONLY.");
                    validChoice = !validChoice;
                    break;
            } 
        } while(!validChoice);

        // Prevents the user from entering a degree if they are not in college
        if(isCollege()){
            // degree - Attained or Ongoing Degree/Program
            for(int i = 3; i <= Integer.parseInt(educChoice); i++ ) {
                if(i == 3)
            }





            if(finishedEduc.equals("Bachelor's Degree")){
                System.out.print("Enter your Bachelor's degree: ");
            } else {
                System.out.print("Enter your degree: ");
            }
            degree.add(input.nextLine());
            System.out.print("Enter your university: ");
            school.add(input.nextLine());

            // if the user has a Master's Degree
            if(finishedEduc.equals("Master's Degree")){
                System.out.print("Enter your Master's degree: ");
                degree.add(input.nextLine());
                System.out.print("Enter your university: ");
                school.add(input.nextLine());
            }

            // if the user has a Doctorate's Degree
            if(finishedEduc.equals("Doctorate's Degree")){
                System.out.print("Enter your Doctorate's degree: ");
                degree.add(input.nextLine());
                System.out.print("Enter your university: ");
                school.add(input.nextLine());
            }

        } else {
            System.out.print("Enter your school: ");
            school.add(input.nextLine());
        }
        

        // startYear - Year of when the user began studying on their highest education attainment
        System.out.print("Enter the year you started your highest education attainment: ");
        this.startYear = input.nextInt();

        // gradYear - Year of when the user graduated or when is expected to graduate
        System.out.print("Enter your completion or expected graduation year: ");
        this.gradYear = input.nextInt();
        input.nextLine();

        // acadAchievements - User's achievements in academics
        System.out.print("Enter your academic achievements (comma-separated): ");
        this.acadAchievements = new ArrayList<>(Arrays.asList(input.nextLine().split(",")));

        // courseWork - User's course work, only asked if the user went to college
        if(isCollege()){
            System.out.print("Enter your relevant course work (comma-separated): ");
            this.coursework = new ArrayList<>(Arrays.asList(input.nextLine().split(",")));
        }
    }
    public void edit(){
        boolean stopEditing = false;
        boolean listEdit = false;
        String listMod;
        int index;

        while (!stopEditing) {
            System.out.println("Please type the corresponding number of the information you want to edit:");
            System.out.println("\t[1] Education Attainment\n\t[2] Degree \n\t[3] Start Year\n\t[4] Completion/Expected Graduation Year\n\t[5] Academic Achievements\n\t[6] Relevant Coursework\n\t[7] Exit Editing");

            System.out.print("Edit: ");
            String editChoice = input.nextLine();

            switch (editChoice) {
                // edit finishedEduc - Education Attainment
                case "1":
                    String choice;
                    System.out.println("Re-enter your highest education attainment:");
                    System.out.println("\t[1] Junior High School\n\t[2] Senior High School\n\t[3] College Undergraduate\n\t[4] Bachelor's Degree\n\t[5]\n\t[6] Doctorate's Degree");

                    // Initializes a variable to keep the loop running if input is invalid

                    boolean validChoice = true;
                    do {
                        System.out.print("Re-enter a value (1 - 6):");
                        choice = input.nextLine();

                        // Provides finishedEduc based on user input

                        switch (choice) {
                            case "1":
                                this.finishedEduc = "Junior High School";
                                break;
                            case "2":
                                this.finishedEduc = "Senior High School";
                                break;
                            case "3":
                                this.finishedEduc = "College Undergraduate";
                                break;
                            case "4":
                                this.finishedEduc = "Bachelor's Degree";
                                break;
                            case "5":
                                this.finishedEduc = "Master's Degree";
                                break;
                            case "6":
                                this.finishedEduc = "Doctorate's Degree";
                                break;
                            default:
                                System.out.println("Please enter a number between 1 - 6 ONLY.");
                                validChoice = !validChoice;
                                break;
                        } 
                    } while(!validChoice);
                    break;
                case "2":
                    if(isCollege()){
                        // degree - Attained or Ongoing Degree/Program
                        System.out.print("Re-enter your degree: ");
                        this.degree = input.nextLine();
                    }
                    else {
                        System.out.println("A degree cannot be added for your selected highest education attainment.");
                    }
                    break;

                // edit startYear - Year of when the user began studying on their highest education attainment
                case "3":
                    System.out.print("Re-enter the year you started your highest education attainment: ");
                    this.startYear = input.nextInt();
                    input.nextLine();
                    break;

                // edit gradYear - Year of when the user graduated or when is expected to graduate
                case "4":
                    System.out.print("Re-enter your completion or expected graduation year: ");
                    this.gradYear = input.nextInt();
                    input.nextLine();
                    break;
                
                // edit acadAchievements - User's achievements in academics
                case "5":
                    while (!listEdit) {
                        //Display the achievements first
                        System.out.println("Your current inputted academic achievements:");
                        for(int i = 1; i < (acadAchievements.size()) + 1; i++){
                            System.out.println("\t[i] " + acadAchievements.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add an achievement: ");
                                acadAchievements.add(input.nextLine());
                                break;
                            case "e":
                                System.out.print("Enter the number of an achievement: ");
                                index = input.nextInt();
                                input.nextLine();

                                System.out.print("Edit the achievement: ");
                                acadAchievements.set((index - 1), input.nextLine());
                                break;
                            case "d":
                                System.out.print("Delete an achievement: ");
                                acadAchievements.remove(input.nextLine());
                                break;
                            case "q":
                                listEdit = true;
                                break;
                            default:
                                System.out.println("Please try again.");
                                break;
                        }
                        
                    }
                    break;

                // edit courseWork - User's course work, only asks the user to input if they went to college
                case "6":
                    if(isCollege()){
                        // Modify the ArrayList by elements
                        while (!listEdit) {
                            //Display the achievements first
                            System.out.println("Your current inputted course work:");
                            for(int i = 1; i < (coursework.size()) + 1; i++){
                                System.out.println("\t[i] " + coursework.get(i-1));
                            }

                            System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                            listMod = input.nextLine().toLowerCase();

                            switch (listMod) {
                                case "a":
                                    System.out.print("Add a course work: ");
                                    coursework.add(input.nextLine());
                                    break;
                                case "e":
                                    System.out.print("Enter the number of a course work: ");
                                    index = input.nextInt();
                                    input.nextLine();

                                    System.out.print("Edit the course work: ");
                                    coursework.set((index - 1), input.nextLine());
                                    break;
                                case "d":
                                    System.out.print("Delete a course work: ");
                                    coursework.remove(input.nextLine());
                                    break;
                                case "q":
                                    listEdit = true;
                                    break;
                                default:
                                    System.out.println("Please try again.");
                                    break;
                            }
                        }
                        break;
                    }

                case "7":
                    stopEditing = true;
                    break;
                default:
                    System.out.println("Error: Please enter proper value.");
                    break;
            }
        }
    }
    public void display(){
        System.out.println("Education:");
        if(isCollege()) {
            
        }

    }

    public boolean isCollege() {
        if(finishedEduc.equals("College Undergraduate") || finishedEduc.equals("Bachelor's Degree") || finishedEduc.equals("Master's Degree") || finishedEduc.equals("Doctorate's Degree")) {
            return true;
        } else {
            return false;
        }        
    }
}
