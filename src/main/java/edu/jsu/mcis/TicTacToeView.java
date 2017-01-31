package edu.jsu.mcis;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TicTacToeView extends JPanel  {
    int count=0;
    TicTacToeModel model;
    JLabel Label= new JLabel("Turn: X");
    JLabel ResultLabel=new JLabel("");
	
	public TicTacToeView(){
		model=new TicTacToeModel();
                model.counter=0;
		setLayout(new GridLayout(4,3));
                setPreferredSize(new Dimension(400,400));
                ActionListener list = new ButtonListener();
		JButton[][] button = new JButton[3][3];
                for(int i = 0; i < 3; i++) {
                    for(int j = 0; j < 3; j++) {
                        button[i][j] = new JButton("");
                        button[i][j].setName("b" + i + "" + j);
                        button[i][j].addActionListener(list);
                        add(button[i][j]);
                    }
                }
		JLabel label = Label;
                label.setSize(new Dimension(50,50));
                label.setFont(new Font("Courier New", Font.BOLD, 24));
                add(label);
	}

private class ButtonListener implements ActionListener {
    @Override 
    public void actionPerformed(java.awt.event.ActionEvent event) {
	JButton button = (JButton)event.getSource();
	String name= button.getName();
        System.out.println("The name is " + name);
	int row=Integer.parseInt(name.substring(1,2));
	int col=Integer.parseInt(name.substring(2));
        model.setMark(row,col);
        model.counter++;
	if (model.counter%2 == 0){
            button.setText("O");
            button.setFont(new Font("Courier New", Font.BOLD, 18));
	    Label.setText("Turn: X");
            ResultLabel.setText("O");
        }
	else {
            button.setText("X");
            button.setFont(new Font("Courier New", Font.BOLD, 18));
            Label.setText("Turn: O");
            ResultLabel.setText("X");
        }
         if (model.counter==9){
            ResultLabel.setText("TIE");
        }
      
}
    }

    
}