/**
 * masginlocation.java                    
 * returns message in maze                  
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;

import java.util.List;

import edu.curtin.maze.Objs;

public class MsgInLocation extends Message
{
    private List<Objs> objList;
    private int x;
    private int y;
    public MsgInLocation(Msg next,List<Objs> objList,int x,int y)
    {
        super(next);
        this.objList=objList;
        this.x=x;
        this.y=y;
    }

    @Override
    public String getMsg()   //returns message in maze 
    {
        String msg="";
        for (Objs obj : objList)
        {
            if (obj.getX()==x && obj.getY()==y)
            {
                msg=msg+""+obj.getMessage()+"\n";
            }
        }

        return next.getMsg()+""+msg;
    }
}
