import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;   

public class Ghost extends Mob
{
    Random random = new Random();
    
    private static final int DIRECTION_DURATION = 5;
    private int directionChangeCooldown = DIRECTION_DURATION;
    
    public Ghost() {
        super(2, 20);    
        
        animationFrames[RIGHT] = new String[] {
            "images/blinkyR.png"
        };
        
        animationFrames[DOWN] = new String[] {
            "images/blinkyD.png"
        };
        
        animationFrames[LEFT] = new String[] {
            "images/blinkyL.png"
        };
        
        animationFrames[UP] = new String[] {
            "images/blinkyU.png"
        };
        
        direction = LEFT;
        
    }
    
    public void act()
    {
        super.act();
    }
    
    protected void handleDirection() {
        if(canChangeDirection()) {
            directionChangeCooldown--;
            if(directionChangeCooldown <= 0) {
                direction = random.nextInt(4);
                directionChangeCooldown = DIRECTION_DURATION;
            }
        }
    }
    
    protected void handleCollisions() {
        Wall wall = (Wall)getOneIntersectingObject(Wall.class);
        if(wall != null) {
            switch (direction) {
                case LEFT:
                    setLocation(getX() + movementSpeed, getY());
                    break;
                
                case DOWN:
                    setLocation(getX(), getY() - movementSpeed);
                    break;
                
                case RIGHT:
                    setLocation(getX() - movementSpeed, getY());
                    break;
                
                case UP:
                    setLocation(getX(), getY() + movementSpeed);
                    break;
            }
        }
        
    }
    
}
