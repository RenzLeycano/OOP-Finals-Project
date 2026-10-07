public class Summary_Builder implements Resume{
    private String summary;
    
    public Summary_Builder() {
        this.summary = "Empty";
    }
    public void input(){
        System.out.print("Enter your Resume Summary: ");
        this.summary = input.nextLine();
    }
    public void edit(){
        System.out.print("Re-enter your Resume Summary: ");
        this.summary = input.nextLine();
    }
    public void display(){
        System.out.println("Summary:");
        System.out.println(summary);
    }
}
