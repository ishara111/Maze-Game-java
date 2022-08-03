/**
 * pickedkeysmsg.java                    
 * returns the picked key list as a message                  
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.messages;

import java.util.List;

public class PickedKeysMsg extends Message
{
    private List<String> pickedKeys;
    public PickedKeysMsg(Msg next,List<String> pickedKeys)
    {
        super(next);
        this.pickedKeys=pickedKeys;
    }

    @Override
    public String getMsg()  //returns the picked key list as a message 
    {
        String msg="";
        for (String k : pickedKeys)
        {
            msg=msg+""+k+"╕\033[m ";
        }

        return next.getMsg()+"Keys Picked Up: "+msg+"\n";
    }
}
