/**
 * incorrectmovemsg.java                    
 * returns the incorrevt move message                  
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;

public class IncorrectMoveMsg extends Message
{
    public IncorrectMoveMsg(Msg next)
    {
        super(next);
    }

    @Override
    public String getMsg() //returns the incorrevt move message
    {
        return next.getMsg()+"Incorrect Move (Try Again)";
    }

    
}
