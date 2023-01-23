import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Frame{
    private int size = 300;
    JButton[][] buttonGrid;
    Icon blackPawn = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Black-Pawn.png");
    Icon blankPalePiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Pale.png");
    Icon blankBlackPiece = new ImageIcon("C:/Users/james/OneDrive/Programming/Github/Chess/Images/Blank-Black.png");

    public Frame(){



        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buttonGrid = new JButton[9][9];
        GridLayout gl = new GridLayout(9,9);
        System.out.println(gl);

        frame.setLayout(gl);
        frame.setSize(size,size);
        frame.setVisible(true);

        for(int i = 0; i < 8; i++){ 
            
            for(int j = 0; j < 8; j++){
                //JLabel tempLabel = new JLabel(Integer.toString(i+j));
                JButton tempButton = new JButton();
                tempButton.setSize(size/9,size/9);
                buttonGrid[i][j] = tempButton;
                
            }
        } 
        //JButton top = new JButton();
        //top.setSize(size,40);
        //frame.add(top);
        
        
        
        System.out.println(blackPawn);
        int colourCount = 1;
        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                
                buttonGrid[x][y].setVisible(true);
                frame.add(buttonGrid[x][y]);
                
                //uttonGrid[x][y].setIcon(blackPawn);
            }
        }

        buttonGrid[1][1].setIcon(blackPawn);
        


    }
}