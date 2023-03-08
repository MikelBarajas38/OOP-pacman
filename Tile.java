import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Tile extends Actor
{
    public static final int SIZE = 20;
    
    public Tile() {
        //empty tile
    }
    
    public Tile(String sprite) {
        setImage(sprite);
    }
    
    public int getSize() {
        return SIZE;
    }
}
