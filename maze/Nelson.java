import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nelson here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nelson extends Actor
{
    int collect = 0;
    /**
     * Act - do whatever the Nelson wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        moveAround();
        hitWall();
        hitTest();
    }
    
    public void moveAround()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 3, getY());
            if (hitWall() == true)
            {
                setLocation(getX() - 3, getY());
            }
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX() - 3, getY());
            if (hitWall() == true)
            {
                setLocation(getX() + 3, getY());
            }
        }
        if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(), getY() - 3);
            if (hitWall() == true)
            {
                setLocation(getX() , getY() + 3);
            }
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(), getY() + 3);
            if (hitWall() == true)
            {
                setLocation(getX() , getY() - 3);
            }
        }
        youLose();
        youWin();
        hitEnemy();
        hitTest();
        hitEnemy2(); 
    }
    public boolean hitWall()    
    {
        if (isTouching(libBlock.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean hitEnemy()    
    {
        if (isTouching(Enemy.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean hitEnemy2()    
    {
        if (isTouching(Enemy2.class))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public void youLose()
    {
        if (hitEnemy())
        {
            getWorld().addObject(new youLose(),275,275);
            Greenfoot.stop();
        }
        if (hitEnemy2())
        {
            getWorld().addObject(new youLose(),275,275);
            Greenfoot.stop();
        }
    }
    public void hitTest()    
    {
        if (getOneIntersectingObject(test.class) != null)
        {
            collect++;
            getWorld().removeObject(getOneIntersectingObject(test.class));
        }
    }  
    public void youWin()    
    {
        if (isTouching(canva.class) && collect == 7)
        {
            getWorld().addObject(new youWin(),275,275);
            Greenfoot.stop();
        }
    }  
    }
    


