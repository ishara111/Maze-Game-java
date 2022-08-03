/**
 * main.java                    
 * main method of maze               
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze;
import java.util.*;
import java.util.logging.Logger;

public class Main 
{
    private static Logger logger = Logger.getLogger(Main.class.getName());
    private static Scanner input = new Scanner(System.in);
    private static MazeMap m=new MazeMap();
    private static Control c=new Control();
    public static void main(String[] args)  //main method
    {
        boolean choice;
        String fileName;
        System.out.println("Enter Input File Name"); //getting file name
        fileName=input.nextLine();
        Read read =new Read();

        read.findMapSize(m, fileName);     //getting the correct size of map

        choice=read.checkFile(fileName);
        if(choice==false)
        {
            logger.info("file valid");
            read.readFile(fileName, m);   //reading file

            m.initMap();
            m.createBorder();        //creating map
            m.createMap();
            logger.info("map created");
            System.out.print("\033[2J");           //clearing screen and changing position of pointer
            System.out.print("\033[H");
    
            m.printMap();
            c.findMessage(m.getObjList(),c.findCurrX(m),c.findCurrY(m)); //search for message in location
    
            c.controlMovement(m);     //controls the movemnt
        }
        
        input.close();
        logger.info("ended");
    }
    
}
