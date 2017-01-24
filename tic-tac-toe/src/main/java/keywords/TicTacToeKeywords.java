package keywords;
import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToeModel model;
	
	
	public void StartNewGame() {
		model= new TicTacToeModel();
	}
	
	public void markLocation(int row, int col) {
		model.setMark(row,col);
	}
	
	public String getMark(int row, int col) {
		TicTacToeModel.Mark temp=model.getMark(row,col);
		if (temp==TicTacToeModel.Mark.X){
			return "X";
		}
		else if (temp==TicTacToeModel.Mark.O){
			return "O";
		}
		else 
			return "EMPTY";
	
	}
    
	public String getWinner() {
		model.checkForWin();
		
		switch(model.winner){
			case 0:
				return "TIE";
			case 1:
				return model.end;
			case 2:
				return model.end;
		}
		return "";
	}
}
