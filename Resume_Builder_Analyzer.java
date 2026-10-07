import java.util.ArrayList;
import java.util.Scanner;

public class Resume_Builder_Analyzer {
    static Scanner input = new Scanner(System.in);

    public static void main(String[]args){
        Resume build;
        ArrayList<Resume> sections;
        QA_Analyzer analyze;
        
        build = new Education_Builder();

        build.input();
        build.edit();
        build.display();
    }
}
