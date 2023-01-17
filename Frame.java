import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Frame{
    public Frame(){

        LinkedList<JButton> buttonList = new LinkedList<JButton>();

        for(int i = 0; i < 10; i++){ 
            
            for(int j = 0; j < 10; j++){
                JLabel tempLabel = new JLabel(Integer.toString(i*j));
                JButton tempButton = new JButton();
                tempButton.add(tempLabel);
                buttonList.add(tempButton);
                System.out.println(tempButton);
            }
        } 



        System.out.println("In here");
        JFrame frame = new JFrame();
        JPanel pan = new JPanel();
        JButton button = new JButton();
        JLabel lab = new JLabel("Testing");
        pan.setSize(50,50);
        frame.setSize(100,100);
        frame.setVisible(true);
        button.setSize(40,40);
       
        frame.add(lab);
        button.add(lab);
        frame.add(button);
        frame.add(pan);
    
    }
}