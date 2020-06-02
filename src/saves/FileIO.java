package saves;

import java.io.*;
import java.util.ArrayList;

public class FileIO
{
  public void writeToFile(String filename, Object obj)
      throws FileNotFoundException, IOException
  {
    ObjectOutputStream write = null;
    try
    {
      FileOutputStream fileIn = new FileOutputStream(filename);
      write = new ObjectOutputStream(fileIn);

      write.writeObject(obj);
    }
    finally
    {
      if (write != null)
      {
        try
        {
          write.close();
        }
        catch (IOException e)
        {
          System.out.println("Error closing file " + filename);
        }
      }
    }
  }

  public void writeToFile(String filename, Object[] obj)
      throws FileNotFoundException, IOException
  {
    ObjectOutputStream write = null;
    try
    {
      FileOutputStream fileIn = new FileOutputStream(filename);
      write = new ObjectOutputStream(fileIn);
      for (int i = 0; i < obj.length; i++)
      {
        write.writeObject(obj[i]);
      }
      write.close();
    }
    finally
    {
      if (write != null)
      {
        try
        {
          write.close();
        }
        catch (IOException e)
        {
          System.out.println("Error closing file " + filename);
        }
      }
    }
  }

  public Object readObjectFromFile(String filename)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    Object returned = null;
    ObjectInputStream read = null;
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      read = new ObjectInputStream(fileIn);
      try
      {
        returned = read.readObject();
      }
      catch (EOFException e)
      {
        System.out.println("Done reading");
      }
    }
    finally
    {
      if (read != null)
      {
        try
        {
          read.close();
        }
        catch (IOException e)
        {
          System.out.println("Cannot close file " + filename);
        }
      }
    }
    return returned;
  }

  public static int getNumberOfObjects(String filename)
  {
    int objectsNr = 0;
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      ObjectInputStream read = new ObjectInputStream(fileIn);
      while (true)
      {
        try
        {
          read.readObject();
          objectsNr++;
        }
        catch (EOFException e)
        {
          break;
        }
      }
      read.close();
    }
    catch (FileNotFoundException e)
    {
      System.out.println("File " + filename + " not found");
      System.exit(1);
    }
    catch (IOException e)
    {
      System.out.println("Cannot write to " + filename);
      System.exit(1);
    }
    catch (ClassNotFoundException e)
    {
      System.out.println("Class not found");
      System.exit(1);
    }
    return objectsNr;
  }

  ;

  public Object[] readArrayFromFile(String filename)
      throws FileNotFoundException, IOException, ClassNotFoundException
  {
    ArrayList<Object> returned = new ArrayList<Object>();
    ObjectInputStream read = null;
    try
    {
      FileInputStream fileIn = new FileInputStream(filename);
      read = new ObjectInputStream(fileIn);
      while (true)
      {
        try
        {
          returned.add(read.readObject());
        }
        catch (EOFException e)
        {
          // done reading
          break;
        }
      }
    }
    finally
    {
      if (read != null)
      {
        try
        {
          read.close();
        }
        catch (IOException e)
        {
          System.out.println("Cannot close file " + filename);
        }
      }
    }
    return returned.toArray();
  }
}
