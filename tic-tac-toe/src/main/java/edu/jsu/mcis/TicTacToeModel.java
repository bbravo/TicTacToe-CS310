package edu.jsu.mcis;

public class TicTacToeModel {
    public enum Mark { EMPTY, X, O };
    private Mark[][] board;
    private boolean xTurn=true;
	public int counter=0;
	public Mark temp,temp1,temp2,m;
	public int winner;
	public boolean flag=false;
	public String turn, end;
    
    public TicTacToeModel() {
		counter=0;
        board = new Mark[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = Mark.EMPTY;
            }
        }
       
    }
    
    public Mark getMark(int row, int col) {
        return board[row][col];
    }
    
    public void setMark(int row, int col) {
        Mark m = (xTurn)? Mark.X : Mark.O;
        if(board[row][col] == Mark.EMPTY) {
            board[row][col] = m;
            xTurn = !xTurn;
			counter++;		
        }
	
		
    }
	public int checkForWin(){
		
		checkHorizontal();
		checkVertical();
		checkDiagonal1();
		checkDiagonal2();
		if (flag==false)
			winner=0;
		if (winner==2)
			end="X";
		else if (winner==1) 
			end="O";
		return winner;
	}
		
	public void checkHorizontal(){
		for (int f=0;f<3;f++){
			temp=getMark(f,0);
			temp1=getMark(f,1);
			temp2=getMark(f,2);
			if ((temp==temp1)&&(temp==temp2)&&(temp!=Mark.EMPTY)){
				 if (!xTurn) {
                    winner = 2;
                } else {
                    winner = 1;
                }
				flag=true;
			}
		}
	}
	
	public void checkVertical(){
		for (int f=0;f<3;f++){
			temp=getMark(0,f);
			temp1=getMark(1,f);
			temp2=getMark(2,f);
			if ((temp==temp1)&&(temp==temp2)&&(temp!=Mark.EMPTY)){
				 if (!xTurn) {
                    winner = 2;
                } else {
                    winner = 1;
                }
				flag=true;
			}
		}
	}
	
	public void checkDiagonal1(){
		for (int f=0;f<3;f++){
			temp=getMark(0,2);
			temp1=getMark(1,1);
			temp2=getMark(2,0);
			if ((temp==temp1)&&(temp==temp2)&&(temp!=Mark.EMPTY)){
				 if (!xTurn) {
                    winner = 2;
                } else {
                    winner = 1;
                }
				flag=true;
			}
		}
	}
	public void checkDiagonal2(){
		for (int f=0;f<3;f++){
			temp=getMark(0,0);
			temp1=getMark(1,1);
			temp2=getMark(2,2);
			if ((temp==temp1)&&(temp==temp2)&&(temp!=Mark.EMPTY)){
				 if (!xTurn) {
                    winner = 2;
                } else {
                    winner = 1;
                }
				flag=true;
			}	
		}
	}
	
}






