import javax.swing.*;
import java.awt.*;

public class Piece {
    private String chessTeam, pieceType;
    private Icon pieceIcon;
    public Piece(String path, String team,String piece){
        pieceIcon = new ImageIcon(path);
        chessTeam = team;
    }
}
