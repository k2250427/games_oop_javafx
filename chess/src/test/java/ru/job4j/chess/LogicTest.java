package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = FigureNotFoundException.class)
    public void moveFigureNotFound()
            throws OccupiedCellException, ImpossibleMoveException, FigureNotFoundException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
      }

    @Test (expected = OccupiedCellException.class)
    public void moveOccupiedCell()
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void moveInvalidWay()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H5);
      }
}