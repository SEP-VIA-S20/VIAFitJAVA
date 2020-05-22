package saves;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class TextFileIO
{
  private void write(String filename, String data, boolean append) throws FileNotFoundException
  {
    PrintWriter writeToFile = null;
    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(filename, append);
      writeToFile = new PrintWriter(fileOutStream);
      writeToFile.println(data);
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }

  private void write(String filename, String[] data, boolean append) throws FileNotFoundException
  {
    PrintWriter writeToFile = null;
    try
    {
      FileOutputStream fileOutStream = new FileOutputStream(filename, append);
      writeToFile = new PrintWriter(fileOutStream);
      for (int i = 0; i < data.length; i++)
      {
        writeToFile.println(data[i]);
      }
    }
    finally
    {
      if (writeToFile != null)
      {
        writeToFile.close();
      }
    }
  }

  public void writeToFile(String fileName, String data) throws FileNotFoundException
  {
    write(fileName, data, false);
  }

  public void appendToFile(String fileName, String data) throws FileNotFoundException
  {
    write(fileName, data, true);
  }

  public void writeToFile(String fileName, String[] strings) throws FileNotFoundException
  {
    write(fileName, strings, false);
  }

  public void appendToFile(String fileName, String[] strings) throws FileNotFoundException
  {
    write(fileName, strings, true);
  }

  public String readStringFromFile(String filename) throws FileNotFoundException
  {
    Scanner read = null;
    String response = "";
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      read = new Scanner(fileIn);
      while (read.hasNext())
      {
        response += read.nextLine() + "\n";
      }
    }
    finally
    {
      if (read != null)
      {
        read.close();
      }
    }
    return response;
  }

  public String readFirstLineFromFile(String filename) throws FileNotFoundException
  {
    Scanner read = null;
    String response = "";
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      read = new Scanner(fileIn);
      response = read.nextLine();
    }
    finally
    {
      if (read != null)
      {
        read.close();
      }
    }
    return response;
  }

  public String[] readArrayFromFile(String filename) throws FileNotFoundException
  {
    Scanner read = null;
    String arr[] = new String[getNumberOfLines(filename)];
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      read = new Scanner(fileIn);
      int pos =0;
      while (read.hasNext())
      {
        arr[pos] = read.nextLine();
        pos ++;
      }

    }finally
    {
      if (read != null)
      {
        read.close();
      }
    }
    return arr;
  };

  public int getNumberOfLines(String filename)
  {
    int numberOfLines = 0;
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      Scanner read = new Scanner(fileIn);
      while (read.hasNext())
      {
        read.nextLine();
        numberOfLines++;
      }
      read.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + filename + " not found");
      System.exit(1);
    }
    return numberOfLines;
  }
}
