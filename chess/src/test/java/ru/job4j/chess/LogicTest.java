package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H6);
    }

    @Ignore
    @Test
    public void moveFigureNotFound()
            throws OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (FigureNotFoundException e) {
            assertThat(e.getMessage(), is("Figure not found at " + Cell.C1));
        }
    }

    @Ignore
    @Test
    public void moveOccupiedCell()
            throws FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.H6));
        try {
            logic.move(Cell.C1, Cell.H6);
        } catch (OccupiedCellException e) {
            assertThat(e.getMessage(), is("Cell " + Cell.H6 + " is occupied"));
        }
    }

    @Ignore
    @Test
    public void moveInvalidWay()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        try {
            logic.move(Cell.C1, Cell.H5);
        } catch (ImpossibleMoveException e) {
            assertThat(e.getMessage(), is("Could not way by diagonal from C1 to H5"));
        }
    }
}