import javax.swing.*;
import java.awt.*;

public class Frame{
    private int size = 300;
    private JFrame frame = new JFrame();
    private Tile[][] tileGrid;
    private JButton[][] buttonGrid;
    private GridLayout gl = new GridLayout(9,9);
    
    private Icon blankPalePiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Pale.png");
    private Icon blankBlackPiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Black.png");

    public Frame(){
        tileGrid = new Tile[8][8];
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGrid = new JButton[8][8]; 
        frame.setLayout(gl);
        frame.setSize(size,size);
        frame.setVisible(true);

        addButtons();
        populateBoard();

    }

    public void listen(){
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tileGrid[i][j].getButton();
            }
        }
    }


    
    public void addButtons(){
        String piece = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
            JButton tempButton = new JButton();
            Piece tempP = new Piece("C:/Users/james/OneDrive/Programming/Github/Chess/Images/" + piece +".png","None");
            tempButton.setSize(size/8,size/8);

            tileGrid[i][j] = new Tile(tempButton,tempP,new Coordinates(i,j));    
            if((i + j) % 2 != 1){
                piece = "Blank-Pale";
                tileGrid[i][j].setTileColour("");
            }else{
                piece = "Blank-Black";
                tileGrid[i][j].setTileColour("Black");
            }
            
            
            
            
            tileGrid[i][j].getButton().setForeground(Color.gray);
            frame.add(tileGrid[i][j].getButton());
            }
        }

    }
    
    private void populateBoard(){
        populateBlack();
        populateWhite();
    }

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

    }
    
    
    
}