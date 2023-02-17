import javax.swing.*;
import java.util.LinkedList;


public class Piece {

    private int[][] dummyBoard;

    protected String chessTeam;
    private Icon pieceIcon;
    protected String type;
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

    

    public LinkedList<Coordinates> testingMoves(Coordinates c,Tile[][] grid,String ty){
   
        switch(ty){
            case "Rook":
                try{
                for(int i = 1; i < 8; i++){
                
                    if(grid[c.x][c.y + i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x][c.y + i].piece.chessTeam != "no team" && grid[c.x][c.y + i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                        toReturn.add(new Coordinates(c.x, c.y+i));
                        break;
                    }else{
                        toReturn.add(new Coordinates(c.x, c.y+i));
                    }
                }

                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " right of rook");
                } 

                try{
                for(int i = 1; i < 8; i++){
            
                    if(grid[c.x][c.y - i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x][c.y - i].piece.chessTeam != "no team" && grid[c.x][c.y - i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                        toReturn.add(new Coordinates(c.x, c.y-i));
                        break;
                    }else{
                        toReturn.add(new Coordinates(c.x, c.y-i));
                    }
                }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 

                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x + i][c.y].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x + i][c.y].piece.chessTeam != "no team" && grid[c.x + i][c.y].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x + i, c.y));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x + i, c.y));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 

                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x - i][c.y].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x - i][c.y].piece.chessTeam != "no team" && grid[c.x - i][c.y].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x - i, c.y));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x - i, c.y));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 
                  
            break;

            case "Bishop":
                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x + i][c.y + i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x + i][c.y + i].piece.chessTeam != "no team" && grid[c.x + i][c.y + i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x + i, c.y + i));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x + i, c.y + i));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 

                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x + i][c.y - i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x + i][c.y - i].piece.chessTeam != "no team" && grid[c.x + i][c.y - i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x + i, c.y - i));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x + i, c.y - i));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 

                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x - i][c.y + i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x - i][c.y + i].piece.chessTeam != "no team" && grid[c.x - i][c.y + i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x - i, c.y + i));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x - i, c.y + i));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 

                try{
                    for(int i = 1; i < 8; i++){
                    
                        if(grid[c.x - i][c.y - i].piece.chessTeam == grid[c.x][c.y].piece.chessTeam || (grid[c.x - i][c.y - i].piece.chessTeam != "no team" && grid[c.x - i][c.y - i].piece.chessTeam != grid[c.x][c.y].piece.chessTeam)){
                            toReturn.add(new Coordinates(c.x - i, c.y - i));
                            break;
                        }else{
                            toReturn.add(new Coordinates(c.x - i, c.y - i));
                        }
                    }
                }catch(IndexOutOfBoundsException e){
                    System.out.println(e + " in trying to place rook");
                } 




            break;
            case "Queen":
                testingMoves(c, grid, "Bishop");
                testingMoves(c, grid, "Rook");

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
            case "King":
                toReturn.add(new Coordinates(c.x + 1,c.y + 1));
                toReturn.add(new Coordinates(c.x + 1,c.y - 1));
                toReturn.add(new Coordinates(c.x - 1,c.y + 1));
                toReturn.add(new Coordinates(c.x - 1,c.y - 1));
                toReturn.add(new Coordinates(c.x + 1,c.y));
                toReturn.add(new Coordinates(c.x,c.y + 1));
                toReturn.add(new Coordinates(c.x,c.y - 1));
                toReturn.add(new Coordinates(c.x - 1,c.y));
            break;
        }

        return toReturn;
    }
    

    
}
