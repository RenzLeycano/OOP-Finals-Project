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
        System.out.print("Enter your Technical Skills: ");
        this.techSkills = input.nextLine(); input.nextLine();

        System.out.print("Enter your Soft Skills: ");
        this.softSkills = input.nextLine(); input.nextLine();

        System.out.print("Enter your Languages: ");
        this.languages = input.nextLine(); input.nextLine();
    }
    public void edit(){
        System.out.print("Re-enter your Technical Skills: ");
        this.techSkills = input.nextLine(); input.nextLine();

        System.out.print("Re-enter your Soft Skills: ");
        this.softSkills = input.nextLine(); input.nextLine();

        System.out.print("Re-enter your Languages: ");
        this.languages = input.nextLine(); input.nextLine();
    }
    public void display(){
        System.out.println("Technical Skills");
        System.out.println(techSkills);
        System.out.println("Soft Skills");
        System.out.println(softSkills);
        System.out.println("Languages");
        System.out.println(languages);
    }
}
