import java.util.ArrayList;
import java.util.Arrays;

public class OptionalParts_Builder implements Resume {
    private ArrayList<String> projects;
    private ArrayList<String> certs;
    private ArrayList<String> awards;
    private ArrayList<String> training;
    private ArrayList<String> volunteerXP;
    private ArrayList<String> reference;

    public OptionalParts_Builder() {
        this.projects = new ArrayList<>();
        this.certs = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.training = new ArrayList<>();
        this.volunteerXP = new ArrayList<>();
        this.reference = new ArrayList<>();
    }
    
    public void input(){
        String checkerIfNA;

        System.out.println("Type 'None' if not applicable");

        // projects - User's certifications
        System.out.print("Enter projects (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.projects = (!checkerIfNA.equalsIgnoreCase("None")) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();

        // certs - User's certifications
        System.out.print("Enter certifications (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.certs = (!checkerIfNA.equalsIgnoreCase("None")) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();

        // awards - User's awards
        System.out.print("Enter awards (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.awards = (!checkerIfNA.equalsIgnoreCase("None")) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();

        // training - Seminars and training the user attended/participated on
        System.out.print("Enter training/seminars (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.training = (!checkerIfNA.equalsIgnoreCase("None")) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();

        // volunteerXP - User's volunteering experience
        System.out.print("Enter volunteer experiences (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.volunteerXP = (!checkerIfNA.equalsIgnoreCase("None")) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();

        // references - User's reference
        System.out.println("\nNOTE: ONLY ENTER REFERENCES IF YOU HAVE TO OR THE JOB DESCRIPTION REQUIRES IT.");
        System.out.print("Enter references (comma-separated): ");
        checkerIfNA = input.nextLine();
        this.reference = (!checkerIfNA.equalsIgnoreCase(checkerIfNA)) ? new ArrayList<>(Arrays.asList(checkerIfNA.split(","))) : new ArrayList<>();
    }
    public void edit(){
        boolean stopEditing = false;
        String listMod;
        int index;

        while (!stopEditing) {
            boolean listEdit = false;


            System.out.println("\nPlease type the corresponding number of the information you want to edit:");
            System.out.println("\t[1] Projects\n\t[2] Certifications \n\t[3] Awards\n\t[4] Training/Seminars Attended\n\t[5] Volunteer experiences\n\t[6] References\n\t[7] Exit Editing");

            System.out.print("Edit: ");
            String editChoice = input.nextLine();
            switch (editChoice) {
                case "1":
                    while (!listEdit) {
                        //Display the projects first
                        System.out.println("\nYour current inputted academic achievements:");
                        for(int i = 1; i < (projects.size()) + 1; i++){
                            System.out.println("\t[i] " + projects.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add a project: ");
                                projects.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of a project: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > projects.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the project: ");
                                projects.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of a project to delete: ");
                                if(projects.remove(input.nextLine())) {
                                    System.out.println("Project does not exist.");
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
                
                case "2":
                    while (!listEdit) {
                        //Display the certifications first
                        System.out.println("\nYour current inputted certifications:");
                        for(int i = 1; i < (certs.size()) + 1; i++){
                            System.out.println("\t[i] " + certs.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add a certificate: ");
                                certs.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of a certificate: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > certs.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the certificate: ");
                                certs.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of a certificate to delete: ");
                                if(!certs.remove(input.nextLine())) {
                                    System.out.println("Certification does not exist.");
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
                
                case "3":
                    while (!listEdit) {
                        //Display the awards first
                        System.out.println("\nYour current inputted awards:");
                        for(int i = 1; i < (awards.size()) + 1; i++){
                            System.out.println("\t[i] " + awards.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add an award: ");
                                projects.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of an award: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > awards.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the award: ");
                                awards.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of an award to delete: ");
                                if(!awards.remove(input.nextLine())) {
                                    System.out.println("Award does not exist");
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

                case "4":
                    while (!listEdit) {
                        //Display the training/seminar experience first
                        System.out.println("\nYour current inputted trainings/seminars:");
                        for(int i = 1; i < (training.size()) + 1; i++){
                            System.out.println("\t[i] " + training.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add a training/seminar experience: ");
                                training.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of a training/seminar experience: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > training.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the training/seminar experience: ");
                                training.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of a training/seminar experience to delete: ");
                                if(!training.remove(input.nextLine()))
                                {
                                    System.out.println("Training/seminar does not exist.");
                                    break;
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

                case "5":
                    while (!listEdit) {
                        //Display the volunteer experience first
                        System.out.println("\nYour current inputted volunteer experience:");
                        for(int i = 1; i < (volunteerXP.size()) + 1; i++){
                            System.out.println("\t[i] " + volunteerXP.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add a volunteer experience: ");
                                volunteerXP.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of a volunteer experience: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > volunteerXP.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the volunteer experience: ");
                                volunteerXP.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of a volunteer experience to delete: ");
                                if(!volunteerXP.remove(input.nextLine()))
                                {
                                    System.out.println("The volunteer experience does not exist.");
                                    break;
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
                case "6":
                    while (!listEdit) {
                        //Display the references first
                        System.out.println("\nYour current inputted references:");
                        for(int i = 1; i < (reference.size()) + 1; i++){
                            System.out.println("\t[i] " + reference.get(i-1));
                        }

                        System.out.println("Add, edit, delete, or quit editing? (A / E / D / Q): ");
                        listMod = input.nextLine().toLowerCase();

                        switch (listMod) {
                            case "a":
                                System.out.print("Add a reference: ");
                                reference.add(input.nextLine());
                                break;

                            case "e":
                                System.out.print("Enter the number of a reference: ");
                                index = input.nextInt();
                                input.nextLine();

                                if(index <= 0 || index > reference.size()) {
                                    System.out.println("Input does not exist.");
                                    break;
                                }

                                System.out.print("Edit the reference: ");
                                reference.set((index - 1), input.nextLine());
                                break;

                            case "d":
                                System.out.print("Enter the number of a reference to delete: ");
                                if(!reference.remove(input.nextLine()))
                                {
                                    System.out.println("The reference does not exist.");
                                    break;
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
        // Check first if the lists are not empty, otherwise they won't be printed.
        if(!projects.isEmpty()){
            System.out.println("Projects");
            for(String proj : projects) {
                System.out.println("- " + proj.trim());
            }
        }
        if(!certs.isEmpty()){
            System.out.println("Certifications");
            for(String cert : certs) {
                System.out.println("- " + cert.trim());
            }
        }
        if(!awards.isEmpty()){
            System.out.println("Awards");
            for(String award : awards) {
                System.out.println("- " + award.trim());
            }
        }
        if(!training.isEmpty()){
            System.out.println("Training / Seminar Attended");
            for(String xp : training) {
                System.out.println("- " + xp.trim());
            }
        }
        if(!volunteerXP.isEmpty()){
            System.out.println("Volunteering Experience");
            for(String volunteer : volunteerXP) {
                System.out.println("- " + volunteer.trim());
            }
        }
        if(!reference.isEmpty()){
            System.out.println("References");
            for(String ref : reference) {
                System.out.println("- " + ref.trim());
            }
        }
    }
}