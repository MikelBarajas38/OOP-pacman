import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    
    public static final int TILESIZE = 20;
    
    private Pacman player;
    
    Map map;
    
    public MyWorld() throws java.io.IOException {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(WIDTH, HEIGHT, 1);
        setPaintOrder(Pacman.class, Ghost.class); //paint at front
        map = new Map(this, "maps/test.csv", 20); //generate map from csv tilemap
        buildGrid(map);
    }
    
    public void act() {
        handleHUD();
        if(player.gameOver()) {
            showText("Game Over", getWidth()/2, 40);
            Greenfoot.stop();
        }
    }
    
    public void buildGrid(Map map) {
        
        int offset = TILESIZE / 2;
        
        for(int i = 0; i < map.getHeight(); i++){
            
            int currentY = i * TILESIZE + offset;
            
            for(int j = 0; j < map.getWidth(); j++) {
                
                int currentX = j * TILESIZE + offset;
                
                Actor actor = map.getMapObject(map.tileMap.get(i).get(j));
                if(actor.getClass() == Pacman.class){
                    player = (Pacman) actor;
                }
                addObject(actor, currentX, currentY);
                
            }

        }
    }
    
    public void handleHUD() {
        showText("PAMAC", 100, 40);
        showText("Score: " + player.getScore(), getWidth() - 100, 40);
    }
    
}
