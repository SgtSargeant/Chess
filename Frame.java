import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class Frame implements ActionListener{
    private int size = 300;

    private Dimension tileSize = new Dimension(size/8,size/8);
    private Tile highlightedTile;
    private JFrame frame = new JFrame();
    private Tile[][] tileGrid;

    private Tile[][] board;
    
    private JButton[][] buttonGrid;
    private GridLayout gl = new GridLayout(8,8);
    
    private Icon blankPalePiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Pale.png");
    private Icon blankBlackPiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Black.png");

    public Frame(){
        tileGrid = new Tile[8][8];
        board = new Tile[8][8];
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGrid = new JButton[8][8]; 
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

        setPieces();

        
        

        
    }

    private void highlightPieces(Coordinates buttonToHighlight){
        LinkedList<Coordinates> toHighlight = (board[buttonToHighlight.x][buttonToHighlight.y].piece).getSpaces(buttonToHighlight);
        for(int len = 0; len < toHighlight.size(); len++){
            Color highlightColour = Color.cyan;
            System.out.println(toHighlight.get(len).x + " " + toHighlight.get(len).y);
                

            try{
                if(board[toHighlight.get(len).x][toHighlight.get(len).y].getPiece().getTeam() == board[buttonToHighlight.x][buttonToHighlight.y].getPiece().getTeam()){
                    highlightColour = Color.green;
                }else{
                    highlightColour = Color.red;
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
                System.out.println("Failed under");
            }
        }

        toHighlight.clear();
    }
    

    public void actionPerformed(ActionEvent e){
        buttonSelect(e);
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
                System.out.println("Choose same tile again");
            }
        }

    }
        
    


    private void implementMoves(String piece){
        System.out.println(piece);
    }


    


    
   

    
    
    private void setPieces(){
        board[0][0].getPiece().setType("Rook"); 
        board[0][0].getPiece().setTeam("Black");
        board[0][0].setText("Rook"); 
        board[0][1].getPiece().setTeam("Black");
        board[0][1].getPiece().setType("Bishop");
        board[0][1].setText("Bishop");

        board[1][1].getPiece().setType("Rook"); 
        board[1][1].getPiece().setTeam("White");
        board[1][1].setText("Rook"); 
        board[2][1].getPiece().setTeam("White");
        board[2][1].getPiece().setType("Bishop");
        board[2][1].setText("Bishop");
    }
    /* 
    private void populateBlack(){
        for(int count = 0; count < 8; count++){
            tileGrid[1][count].getButton().setText("B-Pawn");
            tileGrid[1][count].getPiece().setTeam("Black");
        }
        
        tileGrid[0][0].getButton().setText("B-Rook");
        tileGrid[0][0].getPiece().setTeam("Black");
        tileGrid[0][7].getButton().setText("B-Rook");
        tileGrid[0][7].getPiece().setTeam("Black");

        tileGrid[0][1].getButton().setText("B-Knight");
        tileGrid[0][1].getPiece().setTeam("Black");
        tileGrid[0][6].getButton().setText("B-Knight");
        tileGrid[0][6].getPiece().setTeam("Black");

        tileGrid[0][2].getButton().setText("B-Bishop");
        tileGrid[0][2].getPiece().setTeam("Black");
        tileGrid[0][5].getButton().setText("B-Bishop");
        tileGrid[0][5].getPiece().setTeam("Black");
        
        tileGrid[0][3].getButton().setText("B-Queen");
        tileGrid[0][3].getPiece().setTeam("Black");

        tileGrid[0][4].getButton().setText("B-King");
        tileGrid[0][4].getPiece().setTeam("Black");

    }

    private void populateWhite(){
        for(int count = 0; count < 8; count++){
            tileGrid[6][count].getButton().setText("W-Pawn");
            tileGrid[6][count].getPiece().setTeam("White");
        }
        
        tileGrid[7][0].getButton().setText("W-Rook");
        tileGrid[7][0].getPiece().setTeam("White");
        tileGrid[7][7].getButton().setText("W-Rook");
        tileGrid[7][7].getPiece().setTeam("White");

        tileGrid[7][1].getButton().setText("W-Knight");
        tileGrid[7][1].getPiece().setTeam("White");
        tileGrid[7][6].getButton().setText("W-Knight");
        tileGrid[7][6].getPiece().setTeam("White");

        tileGrid[7][2].getButton().setText("W-Bishop");
        tileGrid[7][2].getPiece().setTeam("White");
        tileGrid[7][5].getButton().setText("W-Bishop");
        tileGrid[7][5].getPiece().setTeam("White");
        
        tileGrid[7][4].getButton().setText("W-Queen");
        tileGrid[7][4].getPiece().setTeam("White");

        tileGrid[7][3].getButton().setText("W-King");
        tileGrid[7][3].getPiece().setTeam("White");

    }*/

    
    
    
    
}