public class PersonalInfo_Builder implements Resume {
    private String resumeWriter;
    private int age;
    private String phoneNo;
    private String emailAddr;
    Validator valid = new Validator();

    public PersonalInfo_Builder() {
        this.resumeWriter = "Unknown";
        this.age = 0;
        this.phoneNo = "Unknown";
        this.emailAddr = "Unknown";
    }

    public void input(){
        System.out.println("==================================PERSONAL INFORMATION===================================\n");
        try {

            while (true) {
                System.out.print("Enter your name: ");
                this.resumeWriter = input.nextLine();
                break;
            }
            while (true) {
                try {
                    System.out.print("Enter your age: ");
                    this.age = input.nextInt(); input.nextLine();
                    valid.validate(age);
                    break;
                } catch (InvalidAgeException e) {
                    System.out.println("Error: " + e.getMessage() + "\n");
                } catch (Exception e) {
                    System.out.println("Error: Try Again. Please enter a number.\n");
                    input.nextLine();
                } 
            }
            while (true) {
                try {
                    System.out.print("Enter your phone number: ");
                    this.phoneNo = input.nextLine();
                    valid.validate(phoneNo, null);
                    break;
                } catch(InvalidContactInfoException e) {
                    System.out.println("Error: " + e.getMessage() + "\n");
                }
                
            }
            while (true) {
                try {
                    System.out.print("Enter your email address: ");
                    this.emailAddr = input.nextLine();
                    valid.validate(phoneNo, emailAddr);
                    break;
                } catch(InvalidContactInfoException e) {
                    System.out.println("Error: " + e.getMessage() + "\n" );
                }
            }
        } catch(Exception e) {
            System.out.println("Error: Please try again.\n");
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
                        try {
                            System.out.print("Re-enter your age: ");
                            this.age = input.nextInt(); input.nextLine();
                            valid.validate(age);
                            break;
                        } catch (InvalidAgeException e){
                            System.out.println("Error: " + e.getMessage() + "\n");
                        } catch (Exception e) {
                            System.out.println("Error: Try again. Please enter a number.\n");
                            input.nextLine();
                        }
                    }
                    break;

                case "3":
                    while (true) {
                        try {
                            System.out.print("Re-enter your phone number: ");
                            this.phoneNo = input.nextLine();
                            valid.validate(phoneNo, emailAddr);
                            break;
                        } catch (InvalidContactInfoException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                        }
                    }
                    break;
                case "4":
                    while (true) {
                        try {
                            System.out.print("Re-enter your email address: ");
                            this.emailAddr = input.nextLine();
                            valid.validate(phoneNo, emailAddr);
                            break;
                        } catch (InvalidContactInfoException e) {
                            System.out.println("Error: " + e.getMessage() + "\n");
                        }
                    }
                    break;
                case "5":
                    stopEditing = true;
                    break;
                default:
                    System.out.println("Error: Please enter proper value.\n");
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
