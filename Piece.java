import javax.swing.*;


public class Piece {
    private String chessTeam;
    private Icon pieceIcon;
    public Piece(String path, String team){
        this.pieceIcon = new ImageIcon(path);
        this.chessTeam = team;
    }

    public void setTeam(String cT){
        this.chessTeam = cT;
    }

    public String getTeam(){
        return chessTeam;
    }

    public Icon getIcon(){
        return pieceIcon;
    }

    
}
