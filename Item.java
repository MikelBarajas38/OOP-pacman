import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Item extends Actor
{
    
    protected int points;
    private GreenfootSound soundEffect;
    
    public Item(int points) {
        this.points = points;
    }
    
    public Item(int points, String soundFile) {
        this.points = points;
        soundEffect = new GreenfootSound(soundFile);
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public int getPoints() {
        return points;
    }
    
    public void setSoundEffect(GreenfootSound soundEffect) {
        this.soundEffect = soundEffect;
    }
    
    public void playSoundEffect() {
        soundEffect.play();
    }
}
