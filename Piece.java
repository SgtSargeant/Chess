import javax.swing.*;
import java.util.LinkedList;


public class Piece {

    private String chessTeam;
    private Icon pieceIcon;
    private String type;
    private LinkedList<Coordinates> toReturn;

    public Piece(String path, String team){
        this.pieceIcon = new ImageIcon(path);
        this.chessTeam = team;
        toReturn = new LinkedList<Coordinates>();
    }

    public void setTeam(String cT){
        this.chessTeam = cT;
    }

    public void setType(String t){
        this.type = t;
    }

    public String getTeam(){
        return chessTeam;
    }

    public String getType(){
        return type;
    }

    public Icon getIcon(){
        return pieceIcon;
    }

    public LinkedList<Coordinates> getSpaces(Coordinates c){
        System.out.println(type);
        switch(type){
            case "Bishop":
            
            for(int count = 0; count < 8; count++){
                toReturn.add(new Coordinates((c.x + count), (c.y + count)));
                toReturn.add(new Coordinates((c.x - count), (c.y - count)));
                toReturn.add(new Coordinates((c.x - count), (c.y + count)));
                toReturn.add(new Coordinates((c.x + count), (c.y - count)));
            }                 

            break;
            case "Rook":
                System.out.println("Rook Clicked");
                for(int i = 0; i < 8; i++){
                    toReturn.add(new Coordinates(i, c.y));
                    toReturn.add(new Coordinates(c.x, i));
                }
            break;
            case "Knight":
                toReturn.add(new Coordinates(c.x + 1, c.y + 2));
                toReturn.add(new Coordinates(c.x + 1, c.y - 2));
                toReturn.add(new Coordinates(c.x - 1, c.y + 2));
                toReturn.add(new Coordinates(c.x - 1, c.y - 2));

                toReturn.add(new Coordinates(c.x + 2, c.y + 1));
                toReturn.add(new Coordinates(c.x + 2, c.y - 1));
                toReturn.add(new Coordinates(c.x - 2, c.y + 1));
                toReturn.add(new Coordinates(c.x - 2, c.y - 1));
                
            default:
                toReturn.add(c);
                
            
        }
        

        return toReturn;
        

    }

    

    
}
