import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class Tile {

    private Color colour;
    private JButton button;
    private Piece piece;

    public Tile(JButton b,Piece p){
        this.button = b;
        this.piece = p;
        highlight();
        }

    public void setTileColour(String a){
        if(a == "Black"){
            colour = new Color(0,0,0);
            button.setBackground(colour); 
        }else{
            colour = new Color(255,255,255);
            button.setBackground(colour); 
        }
    }

    public void highlight(){
        Color btnSecond = new Color(10,122,10);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) 
            {
                if(button.getBackground().equals(new Color(0,0,0)) || button.getBackground().equals(new Color(255,255,255))){
                    button.setBackground(btnSecond);
                }
                else{
                    button.setBackground(colour);
                }

            }
            });
    }

    
    
    public void setIconing(){
        button.setIcon(piece.getIcon());
    }

    public JButton getButton(){
        return button;
    }

    public Piece getPiece(){
        return piece;
    }
}
