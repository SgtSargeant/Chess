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

    }


    
    public void addButtons(){
        String piece = "";
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
            JButton tempButton = new JButton();
            Piece tempP = new Piece("C:/Users/james/OneDrive/Programming/Github/Chess/Images/" + piece +".png","Black");
            tempButton.setSize(size/8,size/8);

            tileGrid[i][j] = new Tile(tempButton,tempP);    
            if((i + j) % 2 != 1){
                piece = "Blank-Pale";
                tileGrid[i][j].setTileColour("");
            }else{
                piece = "Blank-Black";
                tileGrid[i][j].setTileColour("Black");
            }
            
            
            
            
            
            frame.add(tileGrid[i][j].getButton());
            }
        }

    }
    
    
    
}