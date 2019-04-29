import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bug here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bug extends Actor
{
    private int mScore;
    private int mHealth;
    boolean mIsAtEdge;
    boolean mSceneStarted = false;
    
    public Bug(int health)
    {
        mScore = 0;
        mHealth = health;
        mIsAtEdge = false;
    }
    /**
     * Act - do whatever the Bug wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(!mSceneStarted)
        {
            updateScore();
            updateHealth();
            mSceneStarted = true;
        }
        if(mHealth > 0)
             play();
    }
    
    public void play()
    {
        move(5);
        if(Greenfoot.isKeyDown("left"))
             turn(-5);
        if(Greenfoot.isKeyDown("right"))
             turn(5);
        eatCherry();
        if(isAtEdge())
        {
             if(!mIsAtEdge)
             {
                  mIsAtEdge = true;
                  updateHealth();
             }
        }
        else 
             mIsAtEdge = false;
    }
    
    public void eatCherry()
    {
        if(isTouching(Cherry.class))
        {
             removeTouching(Cherry.class);
             updateScore();
        }
    }
    
    public void updateScore()
    {
        if(mSceneStarted)
             mScore++;
        getWorld().showText("Current Score: " + mScore,100,550);
    }
    
    public void updateHealth()
    {
        if(mSceneStarted)
             mHealth--;
        getWorld().showText("Current Health: " + mHealth,700,550);
        if(mHealth == 0 )
             getWorld().showText("Game Over",400,300);
    }
        
   
}
