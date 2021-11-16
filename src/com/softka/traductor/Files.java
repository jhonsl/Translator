package com.softka.traductor;

import java.io.*;

public class Files
{
    public void Create(String path)
    {
        try {
            File file = new File(path);

            if (!file.exists())
                file.createNewFile();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void Read(String path)
    {
        try{
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String text = "<<Translator>>";

            while(text != null) {
                System.out.println(text);
                text = br.readLine();
            }
            br.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void Write(String path,String text)
    {
        try{
            FileWriter fw = new FileWriter(path,true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.newLine();
            bw.append(text);
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public String Find(String word,String path)
    {
        String translation = "";
        try
        {
            FileReader fr = new FileReader(path);
            BufferedReader br = new BufferedReader(fr);
            String[] line;

            while(true)
            {
                 line = br.readLine().split(": ");
                 if(line[0].equals(word))
                 {
                     translation = line[1];
                     break;
                 }
                 else if(line == null)
                     break;
            }
            br.close();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return translation;
    }
}
