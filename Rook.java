import java.util.LinkedList;

public class Rook extends Piece {

    private LinkedList<Coordinates> toReturn;

    public Rook(String path,String team){
        super(path,team);
        toReturn = new LinkedList<Coordinates>();
        }

    public LinkedList<Coordinates> getSpaces(Coordinates c){
        
        for(int i = 0; i < 8; i++){
            toReturn.add(new Coordinates(i, c.y));
            toReturn.add(new Coordinates(c.x, i));
        }

        return toReturn;

    }
}
