package org.test.fun.testfun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class CppCreator {
  public static String inputDirectory = "D:\\cpp_files\\input\\";
  public static String outputDirectory = "D:\\cpp_files\\output\\";
  public static String currentDirectoryName = null;
  public static void main(String[] args) {
    try{
      final File folder = new File(inputDirectory);
      listFilesForFolder(folder);
    }catch(Exception e){
      e.printStackTrace();
    }
    
    System.out.println("done...");
  }
  
  public static void listFilesForFolder(final File folder) {
    for (final File fileEntry : folder.listFiles()) {
        if (fileEntry.isDirectory()) {
            currentDirectoryName = fileEntry.getName();
            (new File(outputDirectory+ currentDirectoryName)).mkdir();
            listFilesForFolder(fileEntry);
        } else {
            System.out.println("reading..." + fileEntry.getName());
            String outputFilePath = outputDirectory +"/" + currentDirectoryName + "/";
            createCppFile(getCppContents(fileEntry.getAbsoluteFile().toString()), outputFilePath + fileEntry.getName());
        }
    }
}
  public static String getCppContents(String input){
    BufferedReader br = null;
    StringBuilder contents = new StringBuilder();
    try{
      br = new BufferedReader(new FileReader(new File(input)));
      String line = null;
      String appender = "";
      while((line = br.readLine()) != null){
        contents.append(appender).append(line);
        appender = "\n";
      }
      br.close();
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      if(br != null){
        try{br.close();}catch(Exception e){}
      }
    }
    
    return contents.toString();
  }
  /**
   * 
   * @param contents
   * @param input
   * @param output
   */
  public static void createCppFile(String contents, String output){
    BufferedWriter br = null;
    try{
      File cppFile = new File(output);
      cppFile.createNewFile();
      br = new BufferedWriter(new FileWriter(cppFile));
      br.write(contents);
    }catch(Exception e){
      e.printStackTrace();
    }finally{
      if(br != null){
        try{br.close();}catch(Exception e){}
      }
    }
  }

}
