import java.util.ArrayList;

public class WorkXP_Builder implements Resume {
    private ArrayList<String> experiences;
    
    public WorkXP_Builder(){
        this.experiences = new ArrayList<>();
    }
    public void input(){
        System.out.println("Enter your job description/s below: \n(job title, required skills and qualifications) \nType 'END' on a new line when finished.");
        while(true) {
            System.out.print("- "); String XP = input.nextLine();
            if(XP.equalsIgnoreCase("END")) {
                break;
            } else {
                experiences.add(XP);
            }
        }
    }
    public void edit(){
        boolean stopEditing = false;
        String listMod;
        int index;

        while (!stopEditing) {
            //Display the starting years first
            System.out.println("\nYour current inputted work experience/s:");
            for(int i = 1; i < (experiences.size()) + 1; i++){
                System.out.println("\t[" + i + "] " + experiences.get(i-1));
            }

            System.out.println("Add, Edit, Delete, or Quit editing? (A / E / D / Q): ");
            listMod = input.nextLine().toLowerCase();

            switch (listMod) {
                case "a":
                    System.out.println("Type 'END' on a new line when finished.");
                    while(true) {
                        System.out.print("- "); String XP = input.nextLine();
                        if(XP.equalsIgnoreCase("END")) {
                            break;
                        }
                        else if(XP.trim().equals("")){
                            continue;
                        }
                        else {
                            experiences.add(XP);
                        }
                    }
                    break;
                case "e":
                    while (true) {
                        try {
                            System.out.print("Enter the corresponding number of the experience to edit: ");
                            index = input.nextInt(); input.nextLine();
                            System.out.print("Replace with: ");
                            experiences.set(index, input.nextLine());
                            break;
                        } catch(Exception e) {
                            System.out.println("Try again. Enter a proper input.");
                        }
                    }
                    break;
                case "d":
                    while (true) {
                        try {
                            System.out.print("Enter the corresponding number of the experience to delete: ");
                            index = input.nextInt(); input.nextLine();
                            experiences.remove(index);
                            break;
                        } catch(IndexOutOfBoundsException e) {
                            System.out.println("Try again. The number you entered is not on the list.");
                        } catch(Exception e) {
                            System.out.println("Try again. Enter a number.");
                        } 
                    }
                    break;
                case "q":
                    stopEditing = !stopEditing;
                    break;
                default:
                    System.out.println("Please try again.");
            }
        }
    }
    public void display(){
        System.out.println("Work Experience: ");
        for(String XP : experiences){
            if(XP.trim().isEmpty()) {
                continue; // Checks if the experience inputted is empty or only contains whitespaces
            }
            System.out.println("\t- " + XP);
        }
    }
}
