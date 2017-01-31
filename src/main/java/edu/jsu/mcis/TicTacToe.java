package edu.jsu.mcis;

import javax.swing.JFrame;


public class TicTacToe {
private TicTacToeModel model;


	public static void main(String[] args) {
	JFrame frame = new JFrame("Tic Tac Toe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //panel = new board();
        TicTacToeView panel;
        panel = new TicTacToeView();
	frame.add(panel);
        frame.pack();
        frame.setVisible(true);
	
		
}
}
