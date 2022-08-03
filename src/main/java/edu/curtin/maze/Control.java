/**
 * control.java                    
 * contains everything to control the movement of P                 
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze;
import java.util.logging.Logger;
import java.util.*;

import edu.curtin.maze.messages.*;
import edu.curtin.maze.movement.*;


public class Control 
{
    private Logger logger = Logger.getLogger(Control.class.getName());
    private Scanner input;
    private List<String> pickedKeys;
    
    public Control() 
    {
        input = new Scanner(System.in);
        pickedKeys = new ArrayList<>();
    }
    public List<String> getPickedKeys()
    {
        return pickedKeys;
    }
    public void setPickedKeys(List<String> pickedKeys) 
    {
        this.pickedKeys = pickedKeys;
    }
    public void controlMovement(MazeMap m) //controls the movement
    {
        boolean win;
        win=false;
        while (!win) 
        {
            Msg msg;
            String choice;
            int res;
            System.out.println();
            System.out.println("Enter n , s , w , e");
            choice=input.nextLine();
            System.out.print("\033[2J");
            System.out.print("\033[H");
            if(choice.equals("n"))     //moving north
            {
                res=new MoveUp(pickedKeys).move(m);// calling using strategy method
                m.printMap(); // msg called using decorator
                msg=new MsgInLocation(new PickedKeysMsg(new MsgDefault(), pickedKeys), m.getObjList(), findCurrX(m), findCurrY(m));
                System.out.println(msg.getMsg());
                if(res==1)
                {
                    System.out.println();
                    msg=new IncorrectMoveMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                if(res==2)
                {
                    win=true;
                }
                if(res==3)
                {
                    System.out.println();
                    msg=new KeyRequiredMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                logger.info("moved north");

            }else if(choice.equals("s"))      //moving south
            {
                res=new MoveDown(pickedKeys).move(m);
                m.printMap();
                msg=new MsgInLocation(new PickedKeysMsg(new MsgDefault(), pickedKeys), m.getObjList(), findCurrX(m), findCurrY(m));
                System.out.println(msg.getMsg());
                if(res==1)
                {
                    System.out.println();
                    msg=new IncorrectMoveMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                if(res==2)
                {
                    win=true;
                }
                if(res==3)
                {
                    System.out.println();
                    msg=new KeyRequiredMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                logger.info("moved south");

            }else if(choice.equals("w"))      //moving west
            {
                res=new MoveLeft(pickedKeys).move(m);
                m.printMap();
                msg=new MsgInLocation(new PickedKeysMsg(new MsgDefault(), pickedKeys), m.getObjList(), findCurrX(m), findCurrY(m));
                System.out.println(msg.getMsg());
                if(res==1)
                {
                    System.out.println();
                    msg=new IncorrectMoveMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                if(res==2)
                {
                    win=true;
                }
                if(res==3)
                {
                    System.out.println();
                    msg=new KeyRequiredMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                logger.info("moved west");

            }else if(choice.equals("e"))    //moving east
            {
                res=new MoveRight(pickedKeys).move(m);
                m.printMap();
                msg=new MsgInLocation(new PickedKeysMsg(new MsgDefault(), pickedKeys), m.getObjList(), findCurrX(m), findCurrY(m));
                System.out.println(msg.getMsg());
                if(res==1)
                {
                    System.out.println();
                    msg=new IncorrectMoveMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                if(res==2)
                {
                    win=true;
                }
                if(res==3)
                {
                    System.out.println();
                    msg=new KeyRequiredMsg(new MsgDefault());
                    System.out.println(msg.getMsg());
                    System.out.println();
                }
                logger.info("moved east");

            }
            else
            {
                m.printMap();
                msg=new MsgInLocation(new PickedKeysMsg(new MsgDefault(), pickedKeys), m.getObjList(), findCurrX(m), findCurrY(m));
                System.out.println(msg.getMsg());
            }
        }
        input.close();
    }

    public boolean haveKey(MazeMap m,int x,int y,List<String> pickedKey)  //check if key is picked up
    {
        boolean have;
        have=false;
        for (String key : pickedKey)
        {
            if(m.getcolor(x, y).equals(key))
            {
                have=true;
            }
        }
        return have;
    }
    public void pickUpKeys(List<Objs> objList,int x,int y,MazeMap m,List<String> pickedKeys)  //adding keys to list when picked up
    {
        for (Objs obj : objList)
        {
            if (obj.getX()==x && obj.getY()==y && obj.getType().equals("K"))
            {
                pickedKeys.add(m.getColorMap().get(obj.getColor()));
            }
        }
        setPickedKeys(pickedKeys);
    }

    public void findMessage(List<Objs> objList,int x,int y)   //find message of location
    {
        for (Objs obj : objList)
        {
            if (obj.getX()==x && obj.getY()==y)
            {
                System.out.println(obj.getMessage());
            }
        }
    }

    public int findCurrX(MazeMap m)    //find cuurent x of P
    {
        int x;
        x=0;
        Objs[][] map =m.getMap();
        for (int i = 0; i <  m.getMapX(); i++)
        {
            for (int j = 0; j < m.getMapY(); j++)
            {
                if(map[i][j].getSymbol().equals("P"))
                {
                    x=map[i][j].getX();
                }
            }
        }
        return x;
    }

    public int findCurrY(MazeMap m)     //find current y of P
    {
        int y;
        y=0;
        Objs[][] map =m.getMap();
        for (int i = 0; i <  m.getMapX(); i++)
        {
            for (int j = 0; j < m.getMapY(); j++)
            {
                if(map[i][j].getSymbol().equals("P"))
                {
                    y=map[i][j].getY();
                }
            }
        }
        return y;
    }
}
