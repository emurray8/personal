package quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import javax.swing.ImageIcon;

/**
 *
 * @author evan
 */
public class Question {
    private ImageIcon image;
    private String correctAnswer;
    private List<String> information = new ArrayList<>();
    public Question(List<String> strAry){
        information = strAry;
        image = new ImageIcon(information.get(0));
        correctAnswer = information.get(5);
    }
    public List<String> getInfo(){
        return information;
    }
    public ImageIcon getImage(){
        return image;
    }
    public String getImageName(){
        return information.get(0);
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public String getQuestion(){
        return information.get(1);
    }
    public List<String> getIncorrectAnswers(){
        List<String> temp = new ArrayList<>();
        temp.add(information.get(2));
        temp.add(information.get(3));
        temp.add(information.get(4));
        Collections.shuffle(temp);
        return temp;
    }
}
