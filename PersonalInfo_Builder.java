public class PersonalInfo_Builder implements Resume {
    private String resumeWriter;
    private int age;
    private String phoneNo;
    private String emailAddr;

    public PersonalInfo_Builder() {
        this.resumeWriter = "Unknown";
        this.age = 0;
        this.phoneNo = "Unknown";
        this.emailAddr = "Unknown";
    }

    public void input(){
        try {
            while (true) {
                System.out.print("Enter your name: ");
                this.resumeWriter = input.nextLine();
                break;
            }
            while (true) {
                System.out.print("Enter your age: ");
                this.age = input.nextInt(); input.nextLine();
                //call validator here
                break;
            }
            while (true) {
                System.out.print("Enter your phone number: ");
                this.phoneNo = input.nextLine();
                // call validator here
                break;
            }
            while (true) {
                System.out.print("Enter your email address: ");
                this.emailAddr = input.nextLine();
                // call validator here
                break;
            }
        }
        catch(Exception e) {
            System.out.println("Error: Please try again.");
        }
    }
    public void edit(){
        boolean stopEditing = false;
        while (!stopEditing) {
            System.out.println("Please type the corresponding number of the information you want to edit:");
            System.out.println("\t[1] Name\n\t[2] Age \n\t[3] Phone Number\n\t[4] Email Address\n\t[5] Exit Editing");

            System.out.print("Edit: ");
            String choice = input.nextLine();
            switch (choice) {
                case "1":
                    while (true) {
                        System.out.print("Re-enter your name: ");
                        this.resumeWriter = input.nextLine();
                        break;
                    }
                    break;
                case "2":
                    while (true) {
                        System.out.print("Re-enter your age: ");
                        this.age = input.nextInt(); input.nextLine();
                        //call validator here
                        break;
                    }
                case "3":
                    while (true) {
                        try {
                            System.out.print("Re-enter your phone number: ");
                            this.phoneNo = input.nextLine();
                            // call validator here
                            break;
                        } catch (Exception e) {
                            // Switch out for InvalidAgeException
                        }
                        
                    }
                case "4":
                    while (true) {
                        try {
                            System.out.print("Re-enter your email address: ");
                            this.emailAddr = input.nextLine();
                            // call validator here
                            break;
                        } catch (Exception e) {
                            // Switch out for InvalidContactInfoException
                        }
                    }
                case "5":
                    stopEditing = true;
                    break;
                default:
                    System.out.println("Error: Please enter proper value.");
                    break;
            }
        }
    }
    
    public void display(){
        System.out.println("Name: " + resumeWriter);
        System.out.println("Age: " + age);
        System.out.println("Phone: " + phoneNo);
        System.out.println("Email Address: " + emailAddr);
    }
}
