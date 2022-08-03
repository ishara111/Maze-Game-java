/**
 * mazemap.java                    
 * contains all the methods needed for map creation                 
 *
 * Name : Ishara Gomes
 * ID   : 20534521
 *
 **/
package edu.curtin.maze;
import java.util.*;

public class MazeMap 
{
    private Objs[][] map;
    private List<Objs> borderWList;
    private List<Objs> objList;
    private List<Objs> moreList;
    private Map<Integer, String> colorMap;
    private int mapX;
    private int mapY;
    
    public MazeMap() 
    {
        objList = new ArrayList<>();
        borderWList = new ArrayList<>();
        moreList = new ArrayList<>();
        colorMap = new HashMap<>();
    }
    public int getMapX() 
    {
        return mapX;
    }
    public void setMapX(int mapX) 
    {
        this.mapX = mapX;
    }
    public int getMapY()
     {
        return mapY;
    }
    public void setMapY(int mapY) 
    {
        this.mapY = mapY;
    }

    public void initMap()
    {
        map=new Objs[mapX][mapY];
    }
    
    public Objs[][] getMap() 
    {
        return map;
    }
  
    public List<Objs> getObjList() 
    {
        return objList;
    }
    public Map<Integer, String> getColorMap()
    {
        return colorMap;
    }
    
    public void initBorder()  //initializing border of maze
    {
        Objs c1 =new Objs();
        c1.setType("corner1");
        c1.setSymbol("┌");
        borderWList.add(c1);

        Objs c2 =new Objs();
        c2.setType("corner2");
        c2.setSymbol("┐");
        borderWList.add(c2);

        Objs c3 =new Objs();
        c3.setType("corner3");
        c3.setSymbol("└");
        borderWList.add(c3);

        Objs c4 =new Objs();
        c4.setType("corner4");
        c4.setSymbol("┘");
        borderWList.add(c4);

        Objs bV =new Objs();
        bV.setType("borderV");
        bV.setSymbol("│");
        borderWList.add(bV);

        Objs bH =new Objs();
        bH.setType("borderH");
        bH.setSymbol("─");
        borderWList.add(bH);

        Objs spaces =new Objs();
        spaces.setType("space");
        spaces.setSymbol(" ");
        borderWList.add(spaces);
    }
    public void createBorder()         //creating border
    {
        initBorder();
        for (Objs obj : borderWList)
        {
            if(obj.getType().equals("corner1"))
            {
                map[0][0]=obj;
            }else if(obj.getType().equals("corner2"))
            {
                map[0][mapY-1]=obj;
            }else if(obj.getType().equals("corner3"))
            {
                map[mapX-1][0]=obj;
            }else if(obj.getType().equals("corner4"))
            {
                map[mapX-1][mapY-1]=obj;
            }else if(obj.getType().equals("borderV"))
            {
                for (int i = 1; i < mapX-1; i++)
                {
                    map[i][0]=obj;
                }
                for (int i = 1; i < mapX-1; i++)
                {
                    map[i][mapY-1]=obj;
                } 
            }else if(obj.getType().equals("borderH"))
            {
                for (int j = 1; j < mapY-1; j++)
                {
                    map[0][j]=obj;
                }
                for (int j = 1; j < mapY-1; j++)
                {
                    map[mapX-1][j]=obj;
                }
            }else if(obj.getType().equals("space"))
            {
                for (int i = 1; i < mapX-1; i++)
                {
                    for (int j = 1; j < mapY-1; j++)
                    {
                        map[i][j]=obj;
            
                    }
                }
            }
        }
    }

    public void fixCoordinates()     //changing coordinates to coorect coordinates
    {
        int x,y,newx,newY;
        for (Objs obj : objList)
        {
            if(obj.getType().equals("WV") || obj.getType().equals("DV"))
            {
                x=obj.getX();
                y=obj.getY();
                newx=(x+1)+x;                                 
                newY=((y+1)*3)+y-3;
                obj.setX(newx);
                obj.setY(newY);
            }else if(obj.getType().equals("WH") || obj.getType().equals("DH"))
            {
                x=obj.getX();
                y=obj.getY();
                newx=((x+1)+x)-1;                                 
                newY=((y+1)*3)+y-1;
                obj.setX(newx);
                obj.setY(newY);
            }
            else
            {
                x=obj.getX();
                y=obj.getY();
                newx=(x+1)+x;
                newY=((y+1)*3)+y-1; 
                obj.setX(newx);
                obj.setY(newY);
            }
        }
    }

    public void correctWallSymbol()        //correcting the wall symbol with the special symobols
    {
        for (Objs obj : objList)
        {
            int x,y;

            if(obj.getType().equals("WV")|| obj.getType().equals("DV"))
            {
                x=obj.getX();
                y=obj.getY();

                if(map[x-1][y-1].getSymbol().equals("─") || map[x-1][y-1].getSymbol().equals("▒"))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┐");   
                    map[x-1][y]=objN;
                }
                if(map[x+1][y-1].getSymbol().equals("─") || map[x+1][y-1].getSymbol().equals("▒"))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┘");               
                    map[x+1][y]=objN;
                }
                if(map[x-1][y+1].getSymbol().equals("─") || map[x-1][y+1].getSymbol().equals("▒"))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┌");          
                    map[x-1][y]=objN;
                }
                if(map[x+1][y+1].getSymbol().equals("─") || map[x+1][y+1].getSymbol().equals("▒"))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("└");      
                    map[x+1][y]=objN;
                }
                if((map[x-1][y-1].getSymbol().equals("─") || map[x-1][y-1].getSymbol().equals("▒")) && (map[x-1][y+1].getSymbol().equals("─") || map[x-1][y+1].getSymbol().equals("▒")))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┬");
                    map[x-1][y]=objN;
                }
                if((map[x+1][y-1].getSymbol().equals("─") || map[x+1][y-1].getSymbol().equals("▒")) && (map[x+1][y+1].getSymbol().equals("─") || map[x+1][y+1].getSymbol().equals("▒")))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┴");
                    map[x+1][y]=objN;
                }
                
            }
            if(obj.getType().equals("WH") || obj.getType().equals("DH"))
            {
                x=obj.getX();
                y=obj.getY();

                if((map[x-1][y-1].getSymbol().equals("│") || map[x-1][y-1].getSymbol().equals("▒")) && (map[x+1][y-1].getSymbol().equals("│") || map[x+1][y-1].getSymbol().equals("▒")))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("├");
                    map[x][y-1]=objN;
                }if((map[x-1][y+1].getSymbol().equals("│") || map[x-1][y+1].getSymbol().equals("▒")) && (map[x+1][y+1].getSymbol().equals("│") || map[x+1][y+1].getSymbol().equals("▒")))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┤");
                    map[x][y+1]=objN;
                }
            if(((y+2)<mapY-1))
            {
                if((map[x-1][y+1].getSymbol().equals("│")|| map[x-1][y+1].getSymbol().equals("▒")) && (map[x+1][y+1].getSymbol().equals("│")|| map[x+1][y+1].getSymbol().equals("▒")) && (map[x][y+2].getSymbol().equals("─")||map[x][y+2].getSymbol().equals("▒")))
                {
                    Objs objN =new Objs();
                    objN.setSymbol("┼");
                    map[x][y+1]=objN;
                }
            }
            }
        }


        }

    public void createMap()     //creating the map
    {
        fixCoordinates();
        addMore();

        for (Objs obj : objList)
        {
            if(obj.getType().equals("WH"))
            {
                map[obj.getX()][obj.getY()]=obj;
            }
            if(obj.getType().equals("WV"))
            {
                map[obj.getX()][obj.getY()]=obj;

            }
            if(obj.getType().equals("DV"))
            {
                map[obj.getX()][obj.getY()]=obj;

            }
            if(obj.getType().equals("DH"))
            {
                map[obj.getX()][obj.getY()]=obj;
            }
            if(obj.getType().equals("K"))
            {
                if(map[obj.getX()][obj.getY()].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()]=obj;
                }
                else if (map[obj.getX()][obj.getY()-1].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()-1]=obj;
                }
                else if (map[obj.getX()][obj.getY()+1].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()+1]=obj;
                }
            }
            if(obj.getType().equals("S"))
            {
                map[obj.getX()][obj.getY()]=obj;
            }
            if(obj.getType().equals("E"))
            {
                if(map[obj.getX()][obj.getY()].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()]=obj;
                }
                else if (map[obj.getX()][obj.getY()-1].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()-1]=obj;
                }
                else if (map[obj.getX()][obj.getY()+1].getSymbol().equals(" "))
                {
                    map[obj.getX()][obj.getY()+1]=obj;
                }
            }
        }
        correctWallSymbol();
    }

    public void addMore()      //adding the extra walls and doors
    {
        for (Objs obj : objList)
        {
            if(obj.getType().equals("WV")||obj.getType().equals("WH")||obj.getType().equals("DH"))
            {
                moreList.add(obj);
            }
        }
        for (Objs obj : moreList)
        {
            if(obj.getType().equals("WV"))
            {
                int x,y;
                x=obj.getX();
                y=obj.getY();
                if(x-1>0)
                {
                    Objs obj1=new Objs();
                    obj1.setType("WV");
                    obj1.setSymbol("│");
                    obj1.setX(x-1);
                    obj1.setY(y);
                    objList.add(obj1);
                }
                if(x+1<mapX-1)
                {
                    Objs obj2=new Objs();
                    obj2.setType("WV");
                    obj2.setSymbol("│");
                    obj2.setX(x+1);
                    obj2.setY(y);
                    objList.add(obj2);
                }
            }
            if(obj.getType().equals("WH"))
            {
                int x,y;
                x=obj.getX();
                y=obj.getY();
                if(y+1<mapY-1)
                {
                    Objs obj1=new Objs();
                    obj1.setType("WH");
                    obj1.setSymbol("─");
                    obj1.setX(x);
                    obj1.setY(y+1);
                    objList.add(obj1);
                }
                if(y+2<mapY-1)
                {
                    Objs obj2=new Objs();
                    obj2.setType("WH");
                    obj2.setSymbol("─");
                    obj2.setX(x);
                    obj2.setY(y+2);
                    objList.add(obj2);
                }
                if(y-1>0)
                {
                    Objs obj3=new Objs();
                    obj3.setType("WH");
                    obj3.setSymbol("─");
                    obj3.setX(x);
                    obj3.setY(y-1);
                    objList.add(obj3);
                }
                if(y-2>0)
                {
                    Objs obj4=new Objs();
                    obj4.setType("WH");
                    obj4.setSymbol("─");
                    obj4.setX(x);
                    obj4.setY(y-2);
                    objList.add(obj4);
                }
            }
            if(obj.getType().equals("DH"))
            {
                int x,y;
                int color;
                x=obj.getX();
                y=obj.getY();
                color=obj.getColor();
                if(y+1<mapY)
                {
                    Objs obj1=new Objs();
                    obj1.setType("DH");
                    obj1.setSymbol("▒");
                    obj1.setColor(color);
                    obj1.setX(x);
                    obj1.setY(y+1);
                    objList.add(obj1);
                }
                if(y-1>0)
                {
                    Objs obj3=new Objs();
                    obj3.setType("DH");
                    obj3.setSymbol("▒");
                    obj3.setColor(color);
                    obj3.setX(x);
                    obj3.setY(y-1);
                    objList.add(obj3);
                }
            }
        }
    }

    public void printMap()     //printing the map
    {
        for (int i = 0; i <  mapX; i++)
        {
            for (int j = 0; j < mapY; j++)
            {
                if(getcolor(i,j).equals(""))
                {
                    if(map[i][j].getSymbol()!="")
                    {
                        System.out.print(map[i][j].getSymbol());
                    }
                }else
                {
                    if(map[i][j].getSymbol()!="")
                    {
                        System.out.print(getcolor(i,j)+""+map[i][j].getSymbol()+"\033[m");
                    }
                }
            }
            System.out.println();
        }
    }

    public void initColorMap()       //initializing color map
    {
        colorMap.put(1, "\033[31m");
        colorMap.put(2, "\033[32m");
        colorMap.put(3, "\033[33m");
        colorMap.put(4, "\033[34m");
        colorMap.put(5, "\033[35m");
        colorMap.put(6, "\033[36m");
    }
    public String getcolor(int x, int y)        //method to get the color
    {
        initColorMap();
        String color="";
        if(map[x][y].getColor()!=0)
        {
            color=colorMap.get(map[x][y].getColor());
        }
        return color;
    }
}
