import java.util.ArrayList;

/**
 * Created by   on 4/30/2020.
 */
public class King extends Piece {

    public King(String path, int color) {
        setPath(path);
        setColor(color);
    }

    @Override
    public ArrayList<ArrayList<Cell>> getPossibleMoves(Cell[][] state, int x, int y) {
        possibleMoves.clear();

        ArrayList<Cell> possibleNormalMoves = new ArrayList<>();
        ArrayList<Cell> possibleKillMoves = new ArrayList<>();

       /*
       Arrays containing all 8 spots a king can move
        */

        int tempx[] = {x, x, x + 1, x + 1, x + 1, x - 1, x - 1, x - 1};
        int tempy[] = {y - 1, y + 1, y - 1, y, y + 1, y - 1, y, y + 1};

       /*
       Iteration of possible moves
        */

        for (int i = 0; i < 8; i++) {
            if ((tempx[i] >= 0 && tempx[i] < 8 && tempy[i] >= 0 && tempy[i] < 8)) {
                if (state[tempy[i]][tempx[i]].getPiece() == null) {
                    possibleNormalMoves.add(state[tempy[i]][tempx[i]]);
                }
                if(state[tempy[i]][tempx[i]].hasPiece()) {
                    if (state[tempy[i]][tempx[i]].getPiece().getColor() != this.color) {
                        possibleKillMoves.add(state[tempy[i]][tempx[i]]);
                    }
                }
            }
        }

        possibleMoves.add(possibleNormalMoves);
        possibleMoves.add(possibleKillMoves);
        return possibleMoves;
    }
}
