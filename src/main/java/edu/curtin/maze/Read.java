/**
 * read.java                    
 * contains all the methods to read file                  
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Read 
{
    private Logger logger = Logger.getLogger(Read.class.getName());
    private Scanner input = new Scanner(System.in);
    
    public void findMapSize(MazeMap m,String fileName)  //finding map size
    {
        int x,y,newX,newY;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            String[] data = line.split(" ");

            x=Integer.parseInt(data[0]);
            y=Integer.parseInt(data[1]);
            newX=x+(x+1);
            newY=y*3+(y+1);
            m.setMapX(newX);
            m.setMapY(newY);
        }catch (IOException e) {
            System.out.println(e);
            logger.warning("file not found");
        }
    }

    public int getCurrX(String fileName)   //get current x
    {
        int x=0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            String[] data = line.split(" ");

            x=Integer.parseInt(data[0]);

        }catch (IOException e) {
            System.out.println(e);
            logger.warning("file not found");
        }
        return x;
    }

    public int getCurrY(String fileName)   //get current y
    {
        int y=0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            String[] data = line.split(" ");

            y=Integer.parseInt(data[1]);

        }catch (IOException e) {
            System.out.println(e);
            logger.warning("file not found");
        }
        return y;
    }




    public void readFile(String fileName,MazeMap m) //adds all the data from input file to list
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            reader.readLine();
            String line = reader.readLine();
            while(line != null)
            {
                Objs obj=new Objs();
                String[] data = line.split(" ");
                
                if(data.length==3)
                {
                    int x,y;
                    x=Integer.parseInt(data[1]);
                    y=Integer.parseInt(data[2]);
                    if(data[0].equals("S"))
                    {
                        obj.setType("S");
                        obj.setSymbol("P");
                        obj.setX(x);
                        obj.setY(y);
                        m.getObjList().add(obj);
                    }
                    else if (data[0].equals("E"))
                    {
                        obj.setType("E");
                        obj.setSymbol("E");
                        obj.setX(x);
                        obj.setY(y);
                        m.getObjList().add(obj);
                    }
                    else if (data[0].equals("WV"))
                    {
                        obj.setType("WV");
                        obj.setSymbol("│");
                        obj.setX(x);
                        obj.setY(y);
                        m.getObjList().add(obj);
                    }
                    else if (data[0].equals("WH"))
                    {
                        obj.setType("WH");
                        obj.setSymbol("─");
                        obj.setX(x);
                        obj.setY(y);
                        m.getObjList().add(obj);
                    }


                }
                else if(data.length==4)
                {
                    if (data[0].equals("DV"))
                    {
                        obj.setType("DV");
                        obj.setSymbol("▒");
                        obj.setX(Integer.parseInt(data[1]));
                        obj.setY(Integer.parseInt(data[2]));
                        obj.setColor(Integer.parseInt(data[3]));
                        m.getObjList().add(obj);
                    }
                    else if (data[0].equals("DH"))
                    {
                        obj.setType("DH");
                        obj.setSymbol("▒");
                        obj.setX(Integer.parseInt(data[1]));
                        obj.setY(Integer.parseInt(data[2]));
                        obj.setColor(Integer.parseInt(data[3]));
                        m.getObjList().add(obj);

                    }
                    else if (data[0].equals("K"))
                    {
                        obj.setType("K");
                        obj.setSymbol("╕");
                        obj.setX(Integer.parseInt(data[1]));
                        obj.setY(Integer.parseInt(data[2]));
                        obj.setColor(Integer.parseInt(data[3]));
                        m.getObjList().add(obj);
                    }
                }
                else if(data.length>4) 
                {
                    if (data[0].equals("M"))
                    {
                        String tmp;
                        String msg="";
                        for (int i = 3; i < data.length; i++) 
                        {
                            tmp=("" +data[i]+" ");
                            msg=msg+""+tmp;
                        }
                        obj.setMessage(msg);
                        obj.setType("M");
                        obj.setX(Integer.parseInt(data[1]));
                        obj.setY(Integer.parseInt(data[2]));
                        m.getObjList().add(obj);
                    }
                }


                line = reader.readLine();
            }
            logger.info("file read successful and data added to list");
        }catch (IOException e) {
            System.out.println(e);
            logger.warning("file not found");
        }
    }

    public boolean checkFile(String fileName) //checks for file validity
    {
        String res;
        boolean choice=false;
        if(getCount("S", fileName)==0 || getCount("S", fileName)>1 || getCount("E", fileName)==0)
        {
            System.out.println("starting element or ending element not found (or multiple starting elements");
            System.out.println();
            System.out.println("do you want to continue [y] or [n]");
            res=input.nextLine();
            input.close();
            if(res.equals("y"))
            {
                choice=false;
            }
            if(res.equals("n"))
            {
                choice=true;
            }
        }
        return choice;
    }

    public int getCount(String symbol,String fileName) //gets counts of specified item
    {
        int count=0;
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line = reader.readLine();
            while (line!=null) 
            {
                String[] data = line.split(" ");

                if(data[0].equals(symbol))
                {
                    count=count+1;
                }
                line = reader.readLine();
            }
        }catch (IOException e) {
            System.out.println(e);
            logger.warning("file not found");
        }
        return count;
    }
}
