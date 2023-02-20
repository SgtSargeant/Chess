import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JButton;
import java.util.LinkedList;

public class Tile extends JButton implements ActionListener{

    private Color colour;
    private JButton button;
    public Piece piece;
    protected Coordinates coordinates;
    public  Boolean isChosen = null;


 
    public Tile(Piece p, Coordinates c){
        super();
        this.coordinates = c;
        setTileColour(c);
    }

    public void setTileColour(Coordinates coor){
        if((coor.x + coor.y) % 2 != 1){
            colour = new Color(0,0,0);
            this.setBackground(colour); 
        }else{
            colour = new Color(255,255,255);
            this.setBackground(colour); 
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

    public void setPiece(Piece p){
        piece = p;
    }

    public Piece getPiece(){
        return piece;
    }

    public Color getOriginalColour(){
        return colour;
    }

  
}
