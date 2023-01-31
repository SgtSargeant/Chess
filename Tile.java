import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import java.util.LinkedList;

public class Tile {

    private Color colour;
    private JButton button;
    private Piece piece;
    protected Coordinates coordinates;
    private Boolean testBool = null;

    public Tile(JButton b,Piece p,Coordinates c){
        this.button = b;
        this.piece = p;
        this.coordinates = c;
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
        Color altColour = new Color(10,122,10);
        button.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent e) 
            {
                if(button.getBackground().equals(new Color(0,0,0)) || button.getBackground().equals(new Color(255,255,255))){
                    button.setBackground(altColour);
                }
                else{
                    button.setBackground(colour);
                }

                System.out.println(coordinates.x + " " + coordinates.y + " "  + piece.getTeam());

            }
            });
    }

    public Boolean returning(){
        return testBool;
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
