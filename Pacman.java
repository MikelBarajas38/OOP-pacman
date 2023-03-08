import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Pacman extends Mob
{
    private int score = 0;
    private boolean isAlive;
    
    private GreenfootSound deathSound;
    
    public Pacman() {
        super(2, 20);    
        
        animationFrames[RIGHT] = new String[] {
            "images/pacR1.png",
            "images/pacR2.png",
            "images/pacR3.png",
            "images/pacR4.png",
            "images/pacR2.png",
            "images/pacR1.png"
        };
        
        animationFrames[DOWN] = new String[] {
            "images/pacD1.png",
            "images/pacD2.png",
            "images/pacD3.png",
            "images/pacD4.png",
            "images/pacD2.png",
            "images/pacD1.png"
        };
        
        animationFrames[LEFT] = new String[] {
            "images/pacL1.png",
            "images/pacL2.png",
            "images/pacL3.png",
            "images/pacL4.png",
            "images/pacL2.png",
            "images/pacL1.png"
        };
        
        animationFrames[UP] = new String[] {
            "images/pacU.png"
        };
        
        deathSound = new GreenfootSound("sounds/death.wav");
        
        direction = RIGHT;
        isAlive = true;
    }
    
    public void act() {
    
        super.act();
        
    }
    
    protected void handleDirection() {
        if(canChangeDirection()) {
            if (Greenfoot.isKeyDown("left")) {
                direction = LEFT;
            } else if (Greenfoot.isKeyDown("down")) {
                direction = DOWN;
            } else if (Greenfoot.isKeyDown("right")) {
                direction = RIGHT;
            } else if (Greenfoot.isKeyDown("up")) {
                direction = UP;
            }
        }
    }
    
    protected void handleCollisions() {

        Item item = (Item)getOneIntersectingObject(Item.class);
        if(item != null) {
            score += item.getPoints();
            item.playSoundEffect();
            getWorld().removeObject(item);
        }
        
        
        Ghost ghost = (Ghost)getOneIntersectingObject(Ghost.class);
        if(ghost != null) {
            deathSound.play();
            isAlive = false;
        }
        
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
    
    public int getScore() {
        return score;
    }
    
    public boolean gameOver() {
        return !isAlive;
    }
    
}
