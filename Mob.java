import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Mob extends Actor
{
    protected static final int RIGHT = 0;
    protected static final int DOWN = 1;
    protected static final int LEFT = 2;
    protected static final int UP = 3;
    protected int direction;
    
    private static final int ANIMATION_FRAMERATE = 3;
    private int frameCooldown = ANIMATION_FRAMERATE;
    protected String[][] animationFrames;
    private int currentFrame = 0;
    protected static int size;
    
    protected int movementSpeed;
    
    public Mob(int movementSpeed, int size) {
        this.movementSpeed = movementSpeed;
        this.size = size;
        animationFrames = new String[4][];
    }
    
    public void act() {
        handleDirection();
        handleMovement();
        handleAnimation();
        handleCollisions();
    }
    
    protected abstract void handleDirection();
    
    protected abstract void handleCollisions();
    
    private void handleMovement() {
        switch (direction) {
                case LEFT:
                    setLocation(getX() - movementSpeed, getY());
                    break;
                
                case DOWN:
                    setLocation(getX(), getY() + movementSpeed);
                    break;
                
                case RIGHT:
                    setLocation(getX() + movementSpeed, getY());
                    break;
                
                case UP:
                    setLocation(getX(), getY() - movementSpeed);
                    break;
        }
    }
    
    private void handleAnimation() {
        frameCooldown--;
        if(frameCooldown <= 0) {
            currentFrame = (currentFrame + 1) % animationFrames[direction].length;
            setImage(animationFrames[direction][currentFrame]);
            frameCooldown = ANIMATION_FRAMERATE;
        }
    }
    
    protected boolean canChangeDirection(){
        return getX() % (size/2) == 0 && getY() % (size/2) == 0 && getX() % size != 0 && getY() % size != 0;
    }
}
