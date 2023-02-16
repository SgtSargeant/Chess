import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Frame implements ActionListener{
    private int size = 600;

    private String playerTurn = null;
    private Dimension tileSize = new Dimension(size/8,size/8);
    private Tile highlightedTile;
    private JFrame frame = new JFrame();

    private Tile[][] board;
    
    private GridLayout gl = new GridLayout(8,8);
    
    private Icon blankPalePiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Pale.png");
    private Icon blankBlackPiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Black.png");

    public Frame(){
        board = new Tile[8][8];
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        frame.setLayout(gl);
        frame.setSize(size,size);
        frame.setVisible(true);
       
        //addButtons();
        populateBoard();
        
      

    }

    private void populateBoard(){
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                Tile tempTile = new Tile(null,new Coordinates(x, y));
                board[x][y] = tempTile;
                board[x][y].setSize(tileSize);
                board[x][y].setForeground(Color.gray);
                board[x][y].addActionListener(this);
                frame.add(board[x][y]);
                board[x][y].setPiece(new Piece(null,"White"));
                board[x][y].getPiece().setType("no piece");
                board[x][y].getPiece().setTeam("no team");
            }
        }

       
        populateBlack();
        populateWhite();
        
        

        
    }

    private void highlightPieces(Coordinates buttonToHighlight){
        LinkedList<Coordinates> toHighlight = (board[buttonToHighlight.x][buttonToHighlight.y].piece).testingMoves(buttonToHighlight,board);
        for(int len = 0; len < toHighlight.size(); len++){
            Color highlightColour = Color.cyan;
                

            try{
                if(board[toHighlight.get(len).x][toHighlight.get(len).y].getPiece().getTeam() == board[buttonToHighlight.x][buttonToHighlight.y].getPiece().getTeam()){
                    highlightColour = Color.green;
                }else{
                    if(board[toHighlight.get(len).x][toHighlight.get(len).y].getPiece().getTeam() == "no team"){
                        highlightColour = Color.cyan;
                    }else{
                        highlightColour = Color.red;
                    }
                    
                }
            board[toHighlight.get(len).x][toHighlight.get(len).y].setBackground(highlightColour);
            }catch(Exception e){
                System.out.println("Error" + e);
            }
            board[buttonToHighlight.x][buttonToHighlight.y].setBackground(Color.magenta);
        }

        

        toHighlight.clear();
    }

    private void dehighlightPieces(Coordinates buttonToHighlight){
        LinkedList<Coordinates> toHighlight = (board[buttonToHighlight.x][buttonToHighlight.y].piece).getSpaces(buttonToHighlight);
        for(int len = 0; len < toHighlight.size(); len++){
            try{
                board[toHighlight.get(len).x][toHighlight.get(len).y].setBackground(board[toHighlight.get(len).x][toHighlight.get(len).y].getOriginalColour());
            }catch(Exception e){
                System.out.println("Error" + e);
            }
        }

        toHighlight.clear();
    }
    

    public void actionPerformed(ActionEvent e){
        buttonSelect(e);

        
        
        Tile s = (Tile)e.getSource();
        System.out.println(s.getBackground());
    }

    private void buttonSelect(ActionEvent e){
        Object obj = e.getSource();
        if(highlightedTile == null){
            highlightedTile = (Tile)obj;
            highlightedTile.setBackground(Color.cyan);
            highlightPieces(highlightedTile.coordinates);
        }else{
            if(highlightedTile == (Tile)obj){
                highlightedTile.setBackground(highlightedTile.getOriginalColour());
                dehighlightPieces(highlightedTile.coordinates);
                highlightedTile = null;
            }else{
                Tile t = (Tile)obj;
                if(t.getBackground() == Color.cyan || t.getBackground() == Color.red){
                    System.out.println("Taking a Piece!");
                    t.setBackground(highlightedTile.getBackground());
                    t.setText(highlightedTile.getText());
                    t.piece.setTeam(highlightedTile.piece.getTeam());
                    t.piece.setType(highlightedTile.piece.getType());
                    dehighlightPieces(highlightedTile.coordinates);
                    highlightedTile.piece.setTeam("no team");
                    highlightedTile.piece.setType("no type");
                    highlightedTile.setText(null);
                    highlightedTile.setBackground(highlightedTile.getOriginalColour());
                    
                    highlightedTile = null;
                }
            }
        }

    }
    
    private void setPiece(Coordinates c,String type, String team){
        board[c.x][c.y].getPiece().setType(type); 
        board[c.x][c.y].getPiece().setTeam(team);
        board[c.x][c.y].setText(type + " " +team); 
    }

    private void populateBlack(){
        setPiece(new Coordinates(7,0), "Rook", "Black");
        setPiece(new Coordinates(7,7), "Rook", "Black");
        setPiece(new Coordinates(7,4), "Rook", "White");
     /*    setPiece(new Coordinates(7,2), "Bishop", "Black");
        setPiece(new Coordinates(7,5), "Bishop", "Black");
        setPiece(new Coordinates(7,6), "Knight","Black");
        setPiece(new Coordinates(7,1), "Knight","Black");
        setPiece(new Coordinates(7,4),"Queen","Black");
        setPiece(new Coordinates(6,0),"Pawn","Black");*/
    }
    
    private void populateWhite(){

        setPiece(new Coordinates(0,0), "Rook", "White");
        setPiece(new Coordinates(0,7), "Rook", "White");
        setPiece(new Coordinates(4, 0), "Pawn", "White");
        setPiece(new Coordinates(0,2), "Bishop", "White");
        setPiece(new Coordinates(0,5), "Bishop", "White");
        setPiece(new Coordinates(0,6), "Knight","White");
        setPiece(new Coordinates(0,1), "Knight","White");

    }
    
    
    
}