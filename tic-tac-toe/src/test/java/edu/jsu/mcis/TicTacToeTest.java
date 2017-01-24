package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	@Test
	public void testInitialBoardIsEmpty() {
        TicTacToeModel model= new TicTacToeModel();
        for (int row=0; row<3; row++){
            for (int col=0; col<3; col++){
                TicTacToeModel.Mark m = model.getMark(row,col);
                assertEquals(TicTacToeModel.Mark.EMPTY, m);
            }
        }
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		TicTacToeModel model = new TicTacToeModel();
        model.setMark(0, 2);
        TicTacToeModel.Mark m = model.getMark(0, 2);
        assertEquals(TicTacToeModel.Mark.X, m);
	}
	
	@Test
	public void testMarkOInBottomLeftCorner() {
		TicTacToeModel model = new TicTacToeModel();
        model.setMark(1, 0);
		model.setMark(2,0);
        TicTacToeModel.Mark m = model.getMark(2, 0);
        assertEquals(TicTacToeModel.Mark.O, m);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0,0);
		TicTacToeModel.Mark m = model.getMark(0, 0);
		model.setMark(0,0);
		assertEquals(model.getMark(0,0), m);		
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0,0);
		model.setMark(0,1);
		TicTacToeModel.Mark m = model.getMark(0, 1);
		assertEquals(TicTacToeModel.Mark.O, m);
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0,0);
		model.setMark(1,0);
		model.setMark(0,1);
		model.setMark(2,0);
		model.setMark(0,2);
		TicTacToeModel.Mark n = model.getMark(0, 0);
		TicTacToeModel.Mark p = model.getMark(0, 1);
		TicTacToeModel.Mark q = model.getMark(0, 2);
		if(n==p){
			if(p==q){
			assertEquals(TicTacToeModel.Mark.X, n);
			}
		}
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		TicTacToeModel model = new TicTacToeModel();
		model.setMark(0,0);
		model.setMark(0,2);
		model.setMark(0,1);
		model.setMark(1,0);
		model.setMark(1,1);
		model.checkForWin();
		model.setMark(2,1);
		model.checkForWin();
		model.setMark(1,2);
		model.checkForWin();
		model.setMark(2,2);
		model.checkForWin();
		model.setMark(2,0);
		model.checkForWin();
		assertEquals(model.winner, 0);
		
	}	
}
