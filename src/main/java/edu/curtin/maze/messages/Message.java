/**
 * message.java                    
 * the abstract class for the decorator                 
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;

public abstract class Message implements Msg
{
    protected Msg next;

    public Message(Msg next)
    {
        this.next=next;
    }

    @Override
    public String getMsg()
    {
        return next.getMsg();
    }
    
}
