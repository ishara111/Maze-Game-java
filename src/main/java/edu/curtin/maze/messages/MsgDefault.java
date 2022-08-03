/**
 * msgdefault.java                    
 * returns the default message                 
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;

public class MsgDefault implements Msg 
{

    private String msg;
    public MsgDefault() 
    {
        this.msg="";
    }

    @Override
    public String getMsg()
    {
        return msg;
    }
    
    
}
