/**
 * movedown.java                    
 * moves the P down                  
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze.movement;

import java.util.List;

import edu.curtin.maze.Control;
import edu.curtin.maze.MazeMap;
import edu.curtin.maze.Objs;

public class MoveDown implements Move
{
    private Control c;
    private List<String> pickedKeys;
    public MoveDown(List<String> pickedKeys)
    {
        c =new Control();
        this.pickedKeys=pickedKeys;
    }

    @Override
    public int move(MazeMap m)
    {
        int x,y,res;
        boolean have;
        res=0;
        Objs[][] map=m.getMap();
        x=c.findCurrX(m);
        y=c.findCurrY(m);
        if(map[x+1][y].getSymbol().equals("─"))
        {
            res=1;
        }else if(map[x+1][y].getSymbol().equals("▒"))
        {
            have=c.haveKey(m,x+1,y,pickedKeys);
            if(have==true)
            {
                map[x][y].setType("space");
                map[x][y].setSymbol(" ");
                Objs s1 =new Objs();
                s1.setType("space");
                s1.setSymbol(" ");
                map[x][y+1]=s1;
                Objs s2 =new Objs();
                s2.setType("space");
                s2.setSymbol(" ");
                map[x][y-1]=s2;
                Objs obj =new Objs();
                obj.setType("S");
                obj.setSymbol("P");
                obj.setX(x+2);
                obj.setY(y);
                map[x+2][y]=obj;
            }
            else
            {
                res=3;
            }
        }
        else if(map[x+2][y].getSymbol().equals("E"))
        {
            map[x][y].setType("space");
            map[x][y].setSymbol(" ");
            Objs s1 =new Objs();
            s1.setType("space");
            s1.setSymbol(" ");
            map[x][y+1]=s1;
            Objs s2 =new Objs();
            s2.setType("space");
            s2.setSymbol(" ");
            map[x][y-1]=s2;

            Objs u1 =new Objs();
            u1.setType("space");
            u1.setSymbol(" ");
            map[x+2][y+1]=u1;
            Objs u2 =new Objs();
            u2.setType("space");
            u2.setSymbol(" ");
            map[x+2][y-1]=u2;

            Objs obj =new Objs();
            obj.setType("S");
            obj.setSymbol("P");
            obj.setX(x+2);
            obj.setY(y);
            map[x+2][y]=obj;
            res=2;
        }else
        {
            map[x][y].setType("space");
            map[x][y].setSymbol(" ");
            Objs s1 =new Objs();
            s1.setType("space");
            s1.setSymbol(" ");
            map[x][y+1]=s1;
            Objs s2 =new Objs();
            s2.setType("space");
            s2.setSymbol(" ");
            map[x][y-1]=s2;
            
            Objs u1 =new Objs();
            u1.setType("space");
            u1.setSymbol(" ");
            map[x+2][y+1]=u1;
            Objs u2 =new Objs();
            u2.setType("space");
            u2.setSymbol(" ");
            map[x+2][y-1]=u2;

            Objs obj =new Objs();
            obj.setType("S");
            obj.setSymbol("P");
            obj.setX(x+2);
            obj.setY(y);
            map[x+2][y]=obj;
            c.pickUpKeys(m.getObjList(), c.findCurrX(m), c.findCurrY(m),m,pickedKeys);
        }
        return res;
    }
}
