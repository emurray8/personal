import java.util.*;
import java.io.*;
public class Matrix{
  List<List<Integer>> list = new ArrayList<List<Integer>>();
  public Matrix(int rows, int cols){
    for(int i = 0; i < rows; i++){
      List<Integer> row = new ArrayList<Integer>();
      for(int j = 0; j< cols; j++){
        row.add(0);
      }
      list.add(row);
    }
  }
  public Matrix(String fileName)throws Exception{
    Scanner fileReader = new Scanner(new FileReader(fileName));

    while(fileReader.hasNextLine()){
      String line = fileReader.nextLine();
      List<Integer> row = new ArrayList<Integer>();
      for(String s : line.split(",")){
        row.add(Integer.parseInt(s.trim()));
      }
      list.add(row);
  }
}
  public int getCellTotal(){
    int result = 0;
    for(List<Integer> j : list){
      for (int i : j){
        result += i;
      }
    }
    return result;
  }
  public int getRows(){
    return list.size();
  }
  public int getCols(){
    return list.get(0).size();
  }
  public int getCell(int row,	int col){
    return list.get(row).get(col);
  }
  public void setCell(int row,	int col,	int value){
    list.get(row).set(col, value);
  }
  public String toString(){
    String s = "";
    for(List<Integer> j : list){
      for (int i : j){
        s += i + ",";
      }
      s += "\n";
    }
    return s;
  }
}
