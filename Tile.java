import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.util.LinkedList;

public class Tile extends JButton implements ActionListener{

    private Color colour;
    private JButton button;
    private Piece piece;
    protected Coordinates coordinates;
    public  Boolean isChosen = null;

    public Tile(JButton b,Piece p,Coordinates c){
        this.button = b;
        this.button.addActionListener(this);
        this.piece = p;
        this.coordinates = c;
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
        //button.addActionListener(new ActionListener(){
          //  public void actionPerformed(java.awt.event.ActionEvent e) 
            //{
                if(button.getBackground().equals(new Color(0,0,0)) || button.getBackground().equals(new Color(255,255,255))){
                    button.setBackground(altColour);
                    isChosen = true;
                }
                else{
                    button.setBackground(colour);
                    isChosen = true;
                }

               // System.out.println(coordinates.x + " " + coordinates.y + " "  + piece.getTeam());

          //  }
            //});
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        Object obj= e.getSource();
        
        if(obj instanceof JButton){
            JButton a = (JButton)obj;
            a.setBackground(Color.yellow);
        }

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
