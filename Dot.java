import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Dot extends Item
{
    
    private static boolean soundTurn = false;
    private GreenfootSound munchOne;
    private GreenfootSound munchTwo;

    
    public Dot(){
        super(10);
        munchOne = new GreenfootSound("sounds/munch1.wav");
        munchTwo = new GreenfootSound("sounds/munch2.wav");
    }
    
    public void act()
    {
        // Add your action code here.
    }
    
    public void playSoundEffect() {
        if(soundTurn) {
            setSoundEffect(munchOne);
        } else {
            setSoundEffect(munchTwo);
        }
        super.playSoundEffect();
        soundTurn = !soundTurn;
    }
}
