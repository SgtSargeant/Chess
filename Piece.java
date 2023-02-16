import javax.swing.*;
import java.util.LinkedList;


public class Piece {

    private int[][] dummyBoard;

    protected String chessTeam;
    private Icon pieceIcon;
    private String type;
    private LinkedList<Coordinates> toReturn;

    public Piece(String path, String team){
        dummyBoard = new int[8][8];
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

    public Coordinates tryCoord(int x, int y){
        try{
            System.out.println(dummyBoard[x][x]);
            return new Coordinates(x, y);
        }catch(Exception e){
            System.out.println("OOB");
            return null;
        }       

        
    }

    public LinkedList<Coordinates> testingMoves(Coordinates c,Tile[][] grid){
        System.out.println("inside");
        switch(type){
            case "Rook":
                for(int i = 1; i < 8; i++){
                try{
                    if(grid[c.x][c.y + i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x][c.y + i].piece.chessTeam != "no team" && grid[c.x][c.y + i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                        toReturn.add(new Coordinates(c.x, c.y+i));
                        break;
                    }else{
                        toReturn.add(new Coordinates(c.x, c.y+i));
                    }
               
                    System.out.println(c.x + " " + (c.y-i));
                    System.out.println();
                    if(grid[c.x][c.y - i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x][c.y - i].piece.chessTeam != "no team" && grid[c.x][c.y - i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                        toReturn.add(new Coordinates(c.x, c.y-i));
                        break;
                    }else{
                        toReturn.add(new Coordinates(c.x, c.y-i));
                    }

                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                }   
              
                }
           // for(int l = 0; l < toReturn.size(); l++){
              //  System.out.println(toReturn.get(l));
            //}
            break;
        }

        return toReturn;
    }

    public LinkedList<Coordinates> getSpaces(Coordinates c){
        System.out.println(type);
        switch(type){

            case "Pawn":
                if(chessTeam == "Black"){
                    toReturn.add(tryCoord(c.x - 1, c.y));
                }else{
                    toReturn.add(tryCoord(c.x + 1, c.y));
                }
            break;
            case "Bishop":
            
            for(int count = 0; count < 8; count++){
                toReturn.add(tryCoord(c.x + count,c.y+count));
                toReturn.add(tryCoord(c.x + count,c.y-count));
                toReturn.add(tryCoord(c.x - count,c.y+count));
                toReturn.add(tryCoord(c.x - count,c.y-count));

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
            break;

            case "Queen":
                for(int i = 0; i < 8; i++){
                  toReturn.add(new Coordinates(i, c.y));
                  toReturn.add(new Coordinates(c.x, i));
                }
                for(int count = 0; count < 8; count++){
                 toReturn.add(new Coordinates((c.x + count), (c.y + count)));
                 toReturn.add(new Coordinates((c.x - count), (c.y - count)));
                 toReturn.add(new Coordinates((c.x - count), (c.y + count)));
                 toReturn.add(new Coordinates((c.x + count), (c.y - count)));
             }   
            default:
                toReturn.add(c);
                
            
        }
        

        return toReturn;
        

    }

    

    
}
