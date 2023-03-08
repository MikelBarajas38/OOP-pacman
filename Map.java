import greenfoot.World;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import greenfoot.Actor;

public class Map  
{
    
    World world;
    
    private int height;
    private int width;
    public List<List<String>> tileMap;

    public Map(World world, String mapFile, int tileSize) throws java.io.IOException {
        height = world.getHeight() / tileSize;
        width = world.getWidth() / tileSize;
        this.world = world;
        tileMap = readMapFromFile(mapFile);
    }

    private List<List<String>> readMapFromFile(String mapFile) throws java.io.IOException {
        tileMap = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(mapFile))) {
            String line;
            while((line = br.readLine()) != null) {
                String []tiles = line.split(",");
                tileMap.add(Arrays.asList(tiles));
            }
        }
        return tileMap;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }
    
    public static Actor getMapObject(String object) {
        switch(object) {
            case "(":
                return new Wall("images/horizontalWallS.png");   
                
            case "-":
                return new Wall("images/horizontalWallM.png");
                
            case ")":
                return new Wall("images/horizontalWallE.png");
                
            case "]":
                return new Wall("images/verticalWallE.png");
                
            case "|":
                return new Wall("images/verticalWallM.png");
                
            case "[":
                return new Wall("images/verticalWallS.png");
            
            case "1":
                return new Wall("images/cornerUL.png");    
            
            case "2":
                return new Wall("images/cornerUR.png");
                            
            case "3":
                return new Wall("images/cornerDL.png");
            
            case "4":
                return new Wall("images/cornerDR.png");
                
            case "5":
                return new Wall("images/topTopL.png");
            
            case "6":
                return new Wall("images/topTopR.png");
            
            case "7":
                return new Wall("images/cornerTopL.png");
            
            case "8":
                return new Wall("images/cornerTopR.png");
            
            case "=":
                return new Wall("images/topM.png");
            
            case "!":
                return new Wall("images/ceilL.png");
                
            
            case "l":
                return new Wall("images/ceilR.png");
                
            
            case "_":
                return new Wall("images/topTopM.png");
                
            
            case "0":
                return new Wall("images/ceilM.png");
                              
            case "P":
                return new Pacman();
                
            case "G":
                return new Ghost();
            
            case ".":
                return new Dot();
            
            case "o":
                return new BigDot();
            
            case "*":
                return new Cherry();
            
            default:
                return null;
        }
    }
}
