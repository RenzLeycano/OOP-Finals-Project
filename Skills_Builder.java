public class Skills_Builder implements Resume {
    private String techSkills;
    private String softSkills;
    private String languages;
    
    public Skills_Builder(){
        this.techSkills = "Empty";
        this.softSkills = "Empty";
        this.languages = "Empty";
    }

    public void input(){
        System.out.println("=========================================SKILLS==========================================\n");
        System.out.print("Enter your Technical Skills: ");
        this.techSkills = input.nextLine();
        
        System.out.print("Enter your Soft Skills: ");
        this.softSkills = input.nextLine(); 

        System.out.print("Enter your Languages: ");
        this.languages = input.nextLine();
    }
    public void edit(){
        System.out.print("Re-enter your Technical Skills: ");
        this.techSkills = input.nextLine();

        System.out.print("Re-enter your Soft Skills: ");
        this.softSkills = input.nextLine();

        System.out.print("Re-enter your Languages: ");
        this.languages = input.nextLine();
    }
    public void display(){
        System.out.println("Technical Skills:\t" + techSkills);
        System.out.println("Soft Skills\t:\t" + softSkills);
        System.out.println("Languages\t:\t" + languages);
    }
}
