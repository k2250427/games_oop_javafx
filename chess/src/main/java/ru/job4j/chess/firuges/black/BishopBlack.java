package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        int dx = Math.abs(dest.getX() - position.getX());
        int dy = Math.abs(dest.getY() - position.getY());
        if (dx != dy) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int signX = (dest.getX() - position.getX()) / dx;
        int signY = (dest.getY() - position.getY()) / dy;
        Cell[] steps = new Cell[dx];

        for (int index = 0; index < dx; index++) {
            steps[index] = Cell.findBy(position.getX() + signX * (index + 1),
                                        position.getY() + signY * (index + 1));
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return Math.abs(dest.getX() - source.getX()) == Math.abs(dest.getY() - source.getY());
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
