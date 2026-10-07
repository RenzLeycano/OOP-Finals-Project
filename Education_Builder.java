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
    private final int currentYear = 2026;
    
    public Education_Builder(){
        this.finishedEduc = "Unknown";
        this.degree = new ArrayList<>();
        this.school = new ArrayList<>();
        this.startYear = new ArrayList<>();
        this.gradYear = new ArrayList<>();
        this.acadAchievements = new ArrayList<>();
        this.coursework = new ArrayList<>();
    }

    public void input(){

        // finishedEduc - Education Attainment
        System.out.println("What is your highest education attainment?");
        System.out.println("\t[1] Junior High School\n\t[2] Senior High School\n\t[3] College Undergraduate\n\t[4] Bachelor's Degree\n\t[5] Master's Degree\n\t[6] Doctor's Degree");

        // Initializes a variable to keep the loop running if input is invalid

        boolean validChoice;
        String educChoice;
        do {
            validChoice = false;
            System.out.print("Enter a value (1 - 6): ");
            educChoice = input.nextLine();

            // Provides finishedEduc based on user input

            switch (educChoice) {
                case "1":
                    this.finishedEduc = "Junior High School";
                    validChoice = !validChoice;
                    break;
                case "2":
                    this.finishedEduc = "Senior High School";
                    validChoice = !validChoice;
                    break;
                case "3":
                    this.finishedEduc = "Undergraduate";
                    validChoice = !validChoice;
                    break;
                case "4":
                    this.finishedEduc = "Bachelor's Degree";
                    validChoice = !validChoice;
                    break;
                case "5":
                    this.finishedEduc = "Master's Degree";
                    validChoice = !validChoice;
                    break;
                case "6":
                    this.finishedEduc = "Doctor's Degree";
                    validChoice = !validChoice;
                    break;
                default:
                    System.out.println("Please enter a number between 1 - 6 ONLY.");
                    break;
            } 
        } while(!validChoice);

        // Prevents the user from entering a degree if they are not in college
        if(isCollege()){
            // degree - Attained or Ongoing Degree/Program
            for(int i = 3; i <= Integer.parseInt(educChoice); i++ ) {
                if(Integer.parseInt(educChoice) > 3 && i == 3) {
                    i++; //If the user has a bachelor's degree or higher, this will prevent the loop from asking for an undergraduate degree input.
                }
                if(i == 4) {
                    System.out.println("\nBachelor's Degree");
                }
                if(i == 5) {
                    System.out.println("\nMaster's Degree");
                }
                if(i == 6) {
                    System.out.println("\nDoctor's Degree");
                }

                // User inputs their degree, university, and the years they started and graduated
                System.out.print("Enter your degree: ");
                degree.add(input.nextLine());
                System.out.print("Enter your university: ");
                school.add(input.nextLine());
                while(true) {
                    try {
                        System.out.print("Enter the year you started: ");
                        startYear.add(input.nextInt()); input.nextLine();

                        System.out.print("Enter your completion or expected graduation year: ");
                        gradYear.add(input.nextInt()); input.nextLine();
                        break;
                    }
                    catch (Exception e) {
                        System.out.println("Try again, enter a proper year");
                    }
                }
            }
        } else {
            // If the user didn't pursue higher education
            System.out.print("\nEnter your school: ");
            school.add(input.nextLine());
            while (true) {
                try {
                    System.out.print("Enter the year you started: ");
                    startYear.add(input.nextInt()); input.nextLine();

                    System.out.print("Enter your completion or expected graduation year: ");
                    gradYear.add(input.nextInt()); input.nextLine();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Try again, enter a proper year");
                }
            }
            
            
        }
        // acadAchievements - User's achievements in academics
        System.out.print("\nEnter your academic achievements (comma-separated): ");
        this.acadAchievements = new ArrayList<>(Arrays.asList(input.nextLine().split(",")));

        // courseWork - User's course work, only asked if the user went to college
        if(isCollege()){
            System.out.print("\nEnter your relevant course work (comma-separated): ");
            this.coursework = new ArrayList<>(Arrays.asList(input.nextLine().split(",")));
        }
    }
    public void edit(){
        boolean stopEditing = false;
        String listMod;
        int index;

        while (!stopEditing) {
            boolean listEdit = false;

            System.out.println("\nPlease type the corresponding number of the information you want to edit:");
            System.out.println("\t[1] Education Attainment\n\t[2] Degree \n\t[3] Start Year\n\t[4] Completion/Expected Graduation Year\n\t[5] Academic Achievements\n\t[6] Relevant Coursework\n\t[7] Exit Editing");

            System.out.print("Edit: ");
            String editChoice = input.nextLine();

            switch (editChoice) {
                // edit finishedEduc - Education Attainment
                case "1":
                    String choice;
                    System.out.println("\nRe-enter your highest education attainment:");
                    System.out.println("\t[1] Junior High School\n\t[2] Senior High School\n\t[3] College Undergraduate\n\t[4] Bachelor's Degree\n\t[5] Master's Degree\n\t[6] Doctor's Degree");

                    // Initializes a variable to keep the loop running if input is invalid

                    boolean validChoice = false;
                    do {
                        System.out.print("Re-enter a value (1 - 6):");
                        choice = input.nextLine();

                        // Provides finishedEduc based on user input

                        switch (choice) {
                            case "1":
                                this.finishedEduc = "Junior High School";
                                validChoice = !validChoice;
                                degree = null;
                                clearExcess(startYear, 1);
                                clearExcess(gradYear, 1);
                                clearExcess(school, 1);
                                break;
                            case "2":
                                this.finishedEduc = "Senior High School";
                                validChoice = !validChoice;
                                degree = null;
                                clearExcess(startYear, 1);
                                clearExcess(gradYear, 1);
                                clearExcess(school, 1);
                                break;
                            case "3":
                                this.finishedEduc = "Undergraduate";
                                validChoice = !validChoice;
                                clearExcess(degree, 1);
                                clearExcess(startYear, 1);
                                clearExcess(gradYear, 1);
                                clearExcess(school, 1);
                                break;
                            case "4":
                                this.finishedEduc = "Bachelor's Degree";
                                validChoice = !validChoice;
                                clearExcess(degree, 1);
                                clearExcess(startYear, 1);
                                clearExcess(gradYear, 1);
                                clearExcess(school, 1);
                                break;
                            case "5":
                                this.finishedEduc = "Master's Degree";
                                validChoice = !validChoice;
                                clearExcess(degree, 2);
                                clearExcess(startYear, 2);
                                clearExcess(gradYear, 2);
                                clearExcess(school, 2);
                                break;
                            case "6":
                                this.finishedEduc = "Doctor's Degree";
                                validChoice = !validChoice;
                                break;
                            default:
                                System.out.println("Please enter a number between 1 - 6 ONLY.");
                                break;
                        } 
                    } while(validChoice);
                    break;
                case "2":
                    if(isCollege()){
                        // degree - Attained or Ongoing Degree/Program
                        while (!listEdit) {
                            //Display the degrees first
                            System.out.println("\nYour current inputted degree/s:");
                            for(int i = 1; i < (degree.size()) + 1; i++){
                                System.out.println("\t[i] " + degree.get(i-1));
                            }

                            System.out.println("Add, Edit, or Quit editing? (A / E / Q): ");
                            listMod = input.nextLine().toLowerCase();

                            switch (listMod) {
                                case "a":
                                    if(
                                        (degree.size() == 1 && (finishedEduc.equals("Undergraduate") || finishedEduc.equals("Bachelor's Degree"))) ||
                                        (degree.size() == 2 && finishedEduc.equals("Master's Degree")) ||
                                        (degree.size() == 3 && finishedEduc.equals("Doctor's Degree"))
                                    ) {
                                        System.out.println("You can't add any more degrees due to your inputted highest education attainment.");
                                    }
                                    else {
                                        System.out.print("Add a degree: ");
                                        degree.add(input.nextLine());
                                    }
                                    break;
                                case "e":
                                    System.out.print("Enter the corresponding number of the degree to edit: ");
                                    index = input.nextInt();
                                    input.nextLine();

                                    System.out.print("Edit the course work: ");
                                    degree.set((index - 1), input.nextLine());
                                    break;
                                case "q":
                                    listEdit = true;
                                    break;
                                default:
                                    System.out.println("Please try again.");
                                    break;
                            }
                        }
                    }
                    else {
                        System.out.println("A degree cannot be added for your selected highest education attainment.");
                    }
                    break;

                // edit startYear - Year of when the user began studying on their highest education attainment
                case "3":
                    while (!listEdit) {
                        //Display the starting years first
                        System.out.println("\nYour current inputted starting year/s:");
                        for(int i = 1; i < (startYear.size()) + 1; i++){
                            System.out.println("\t[" + i + "] " + startYear.get(i-1));
                        }

                        System.out.println("Add, Edit, or Quit editing? (A / E / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                if(
                                    (startYear.size() == 1 && (!isCollege() || finishedEduc.equals("Undergraduate") || finishedEduc.equals("Bachelor's Degree"))) ||
                                    (startYear.size() == 2 && finishedEduc.equals("Master's Degree")) ||
                                    (startYear.size() == 3 && finishedEduc.equals("Doctor's Degree"))
                                ) {
                                    System.out.println("You can't add any more due to your inputted highest education attainment.");
                                }
                                else {
                                    while (true) {
                                        try {
                                            System.out.print("Add a year: ");
                                            startYear.add(input.nextInt()); input.nextLine();
                                            break;
                                        } catch(Exception e) {
                                            System.out.println("Try again. Enter a proper year.");
                                        }
                                    }
                                    break;
                                }
                                break;
                            case "e":
                                while (true) {
                                    try {
                                        System.out.print("Enter the corresponding number of the year to edit: ");
                                        index = input.nextInt();
                                        input.nextLine();

                                        System.out.print("Edit the starting year: ");
                                        startYear.set((index - 1), input.nextInt()); input.nextLine();
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Try again. Enter a number.");
                                    }
                                }
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

                // edit gradYear - Year of when the user graduated or when is expected to graduate
                case "4":
                    while (!listEdit) {
                        //Display the graduation years first
                        System.out.println("\nYour current inputted completion/graduation year/s:");
                        for(int i = 1; i < (gradYear.size()) + 1; i++){
                            System.out.println("\t[" + i + "] " + gradYear.get(i-1));
                        }

                        System.out.println("Add, Edit, or Quit editing? (A / E / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                if(
                                    (gradYear.size() == 1 && (!isCollege() || finishedEduc.equals("Undergraduate") || finishedEduc.equals("Bachelor's Degree"))) ||
                                    (gradYear.size() == 2 && finishedEduc.equals("Master's Degree")) ||
                                    (gradYear.size() == 3 && finishedEduc.equals("Doctor's Degree"))
                                ) {
                                    System.out.println("You can't add any more due to your inputted highest education attainment.");
                                }
                                else {
                                    while (true) {
                                        try {
                                            System.out.print("Add a year: ");
                                            gradYear.add(input.nextInt());
                                            break;
                                        } catch(Exception e) {
                                            System.out.println("Try again. Enter a proper year.");
                                        }
                                    }
                                }
                                break;
                            case "e":
                                System.out.print("Enter the corresponding number of the year to edit: ");
                                index = input.nextInt();
                                input.nextLine();

                                while (true) {
                                    try {
                                        System.out.print("Edit the completion/graduation year: ");
                                        degree.set((index - 1), input.nextLine());
                                        break;
                                    } catch (Exception e) {
                                        System.out.println("Try again. Enter a number.");
                                    }
                                }
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
                
                // edit acadAchievements - User's achievements in academics
                case "5":
                    while (!listEdit) {
                        //Display the achievements first
                        System.out.println("\nYour current inputted academic achievements:");
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
                            System.out.println("\nYour current inputted course work:");
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
        System.out.println("\nEducation:");
        if(isCollege()) {
            for(int i = 0; i < degree.size(); i++) {
                try {
                    System.out.println(degree.get(i));
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Unknown");
                }
                try {
                    System.out.println(school.get(i));
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Unknown");
                }
                try {
                    if(gradYear.get(i) > currentYear) {
                    System.out.println("Expected " + gradYear.get(i) + "\n");
                    } else {
                        System.out.println(startYear.get(i) + " - " + gradYear.get(i) + "\n");
                    }
                } catch(IndexOutOfBoundsException e) {
                    System.out.println("Unknown");
                }
            }
        } else {
            System.out.println(school.get(0));
            try {
                if(gradYear.get(0) > currentYear) {
                System.out.println("Expected " + gradYear.get(0) + "\n");
                } else {
                    System.out.println(startYear.get(0) + " - " + gradYear.get(0) + "\n");
                }
            } catch(IndexOutOfBoundsException e) {
                System.out.println("Unknown");
            }
            
        }
        System.out.println("Achievements: ");
        for(String achievement : acadAchievements){
            System.out.println("- " + achievement);
        }
        if(isCollege()) {
            System.out.println("Course Work: ");
            for(String courses : coursework){
                System.out.println("- " + courses);
            }
        }
    }

    public boolean isCollege() {
        if(finishedEduc.equals("Undergraduate") || finishedEduc.equals("Bachelor's Degree") || finishedEduc.equals("Master's Degree") || finishedEduc.equals("Doctor's Degree")) {
            return true;
        } else {
            return false;
        }        
    }

    public void clearExcess(ArrayList info, int level) {
        // Removes excess info if the education attainment is edited
        if (info.size() > level) {
            info.subList(level, info.size()).clear();
        }
    }
}
