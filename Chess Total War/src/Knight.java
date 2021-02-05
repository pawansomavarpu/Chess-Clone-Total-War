import java.util.ArrayList;

/**
 * Created by   on 4/30/2020.
 */
public class Knight extends Piece {

    public Knight(String path, int color) {
        setPath(path);
        setColor(color);
    }

    @Override
    public ArrayList<ArrayList<Cell>> getPossibleMoves(Cell[][] state, int x, int y) {

        possibleMoves.clear();
        ArrayList<Cell> possibleNormalMoves = new ArrayList<>();
        ArrayList<Cell> possibleKillMoves = new ArrayList<>();

       /*
       Knights only have 8 possible places they can move so using an array of temporary values we can iterate
       through each possible instance
        */

        int[] tempx = {x+1,x-1,x+1,x-1,x+2,x-2,x+2,x-2};
        int[] tempy = {y+2,y+2,y-2,y-2,y+1,y+1,y-1,y-1};

       /*
       Iteration through the possible moves
        */

        for(int i = 0; i < 8; i++) {
            if((tempx[i] >= 0 && tempx[i] < 8 && tempy[i] >= 0 && tempy[i] < 8 )) {

                //Checking if the move is normal
                if(state[tempy[i]][tempx[i]].getPiece() == null) {
                    possibleNormalMoves.add(state[tempy[i]][tempx[i]]);
                }

                //Checking if the move is a kill move
                if(state[tempy[i]][tempx[i]].hasPiece()) {
                    if(state[tempy[i]][tempx[i]].getPiece().getColor() != this.color) {
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