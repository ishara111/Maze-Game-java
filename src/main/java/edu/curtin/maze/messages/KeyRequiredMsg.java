/**
 * keyrequiredmsg.java                    
 * returns if key is wrong                 
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;


public class KeyRequiredMsg extends Message
{

    public KeyRequiredMsg(Msg next)
    {
        super(next);
    }

    @Override
    public String getMsg()
    {
        return next.getMsg()+"Correct Key Required";
    }
}
