import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Frame{
    private int size = 300;
    private JFrame frame = new JFrame();
    private JButton[][] buttonGrid;
    private GridLayout gl = new GridLayout(9,9);
    
    private Icon blankPalePiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Pale.png");
    private Icon blankBlackPiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Black.png");

    public Frame(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGrid = new JButton[9][9]; 
        frame.setLayout(gl);
        frame.setSize(size,size);
        frame.setVisible(true);

        addButtons();
    }

    private void addButtons(){
        for(int i = 0; i < 8; i++){ 
            
            for(int j = 0; j < 8; j++){
                
                //JLabel tempLabel = new JLabel(Integer.toString(i+j));
                JButton tempButton = new JButton();
                tempButton.setSize(size/9,size/9);
                buttonGrid[i][j] = tempButton;
                
                buttonGrid[i][j].setVisible(true);

                if((i + j) % 2 != 1){
                    buttonGrid[i][j].setIcon(blankPalePiece);
                }else{
                    buttonGrid[i][j].setIcon(blankBlackPiece);
                }
                
                frame.add(buttonGrid[i][j]);
            }
        } 
    }
    
    /**public String getPiece(int x, int y){
        return buttonGrid[x][y].getIcon();
    }*/
    
}