import java.io.File;
import java.util.Scanner;

/**
 *
 * @author evan
 */
public class DirectoryBrowser {

    public static void main(String[] args) {
        new DirectoryBrowser().go();
    }
    
    private File file;
    private String selection;

    
    public void go(){
       Scanner in = new Scanner(System.in);
       file = new File(System.getProperty("user.dir"));
       System.out.println("Welcome to Seashell!");
       selection = "";
       while(!selection.equalsIgnoreCase("e") && !selection.equalsIgnoreCase("exit")){
           System.out.print("Seashell>");
           selection = in.nextLine();
           doTask(selection);
       }
       
    }
    public void printMenu(){
        System.out.println(
        "(l)ist: lists contents of current directory\n" +
        "(d)own [dir]: moves into the specified child directory\n" +
        "(u)p: moves to the parent directory\n" +
        "(w)ai: prints the current directory\n" +
        "(e)xit: exits the shell\n" +
        "(h)elp: prints a list of the supported commands");
    }
    public void doTask(String selection){
        if(selection.equalsIgnoreCase("l") || selection.equalsIgnoreCase("list")){
            String[] names = file.list();
            File[] files = file.listFiles();
            for(int i = 0; i < names.length; i++){
                if(files[i].isFile())
                System.out.println("(f) " + names[i]);
                if(files[i].isDirectory())
                System.out.println("(d) "+ names[i]);
            }
        }
        else if(selection.startsWith("d") || selection.startsWith("down")){
            String[] path = selection.split(" ");
            File temp = new File(file.getPath()+"/"+path[1]);
            if(!temp.isDirectory())
                System.out.println(temp.getName() + " is not a directory.");
            else{
                file = temp;
                System.out.println(temp.getPath());
            }
        }
        else if(selection.equalsIgnoreCase("u") || selection.equalsIgnoreCase("up")){
            if(file.getParentFile() == null){
                System.out.println("Can't go up anymore!");
            }else{
                File temp = file.getParentFile();
                System.out.println(temp.getPath());
                file = temp;
            }
        }
        else if(selection.equalsIgnoreCase("w") || selection.equalsIgnoreCase("wai")){
            System.out.println(file.getPath());
        }
        else if(selection.equalsIgnoreCase("e") || selection.equalsIgnoreCase("exit")){
            System.out.println("Bye!");
        }
        else if(selection.equalsIgnoreCase("h") || selection.equalsIgnoreCase("help")){
            printMenu();
        }else{
            printMenu();
        }
    }
    
}
