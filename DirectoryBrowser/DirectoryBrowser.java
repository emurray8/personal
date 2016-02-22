

import java.io.File;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author evan
 */
public class FileBrowser {

    public static void main(String[] args) {
        new FileBrowser().go();
    }
    
    private File file;
    private String selection;

    
    public void go(){
       Scanner in = new Scanner(System.in);
       file = new File(System.getProperty("user.dir"));
<<<<<<< HEAD
       System.out.println("Welcome to My Directory Browser!");
       selection = "";
       while(!selection.equalsIgnoreCase("e")){
           System.out.print("DirectoryBrowser>");
=======
       System.out.println("Welcome to My File Browser!");
       selection = "";
       while(!selection.equalsIgnoreCase("e") && !selection.equalsIgnoreCase("exit")){
           System.out.print("FileBrowser>");
>>>>>>> c99daf692f72622f303c26ed132bc54464aa42a6
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
            String newPathName = "";
            if(path.length == 1){
                System.out.println("Example: d directoryName or: down directoryName");
            }else if(path.length > 2){
                for(int i = 1; i < path.length-1; i++){
                    newPathName+= path[i] + " ";
                }
                newPathName+= path[path.length-1];
                File temp = new File(file.getPath()+"/"+newPathName);
                if(!temp.isDirectory())
                    System.out.println(temp.getName() + " is not a directory.");
                else{
                    file = temp;
                    System.out.println(temp.getPath());
                }
            }else{
                File temp = new File(file.getPath()+"/"+path[1]);
                if(!temp.isDirectory())
                    System.out.println(temp.getName() + " is not a directory.");
                else{
                    file = temp;
                    System.out.println(temp.getPath());
                }
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
