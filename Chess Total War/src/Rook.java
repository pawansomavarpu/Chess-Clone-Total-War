import java.util.ArrayList;

/**
 * Created by   on 4/30/2020.
 */
public class Rook extends Piece {

    public Rook(String path, int color) {
        setPath(path);
        setColor(color);
    }

    @Override
    public ArrayList<ArrayList<Cell>> getPossibleMoves(Cell[][] state, int x, int y) {

        possibleMoves.clear();
        ArrayList<Cell> possibleNormalMoves = new ArrayList<>();
        ArrayList<Cell> possibleKillMoves = new ArrayList<>();

        int tempx = x;
        int tempy = y;

       /*
       Adding North Movement
        */

        tempx = x;
        tempy = y + 1;
        while(tempy < 8) {
            if(state[tempy][tempx].getPiece() == null) {
                possibleNormalMoves.add(state[tempy][tempx]);
            }
            else if(state[tempy][tempx].getPiece().getColor() != this.color){
                possibleKillMoves.add(state[tempy][tempx]);
                break;
            }
            else if(state[tempy][tempx].getPiece().getColor() == this.color) {
                break;
            }

            tempy++;
        }

       /*
       Adding South Movement
        */

        tempx = x;
        tempy = y - 1;
        while(tempy >= 0) {
            if(state[tempy][tempx].getPiece() == null) {
                possibleNormalMoves.add(state[tempy][tempx]);
            }
            else if(state[tempy][tempx].getPiece().getColor() != this.color){
                possibleKillMoves.add(state[tempy][tempx]);
                break;
            }
            else if(state[tempy][tempx].getPiece().getColor() == this.color) {
                break;
            }

            tempy--;
        }

       /*
       Adding West Movement
        */

        tempx = x - 1;
        tempy = y;
        while(tempx >= 0) {
            if(state[tempy][tempx].getPiece() == null) {
                possibleNormalMoves.add(state[tempy][tempx]);
            }
            else if(state[tempy][tempx].getPiece().getColor() != this.color){
                possibleKillMoves.add(state[tempy][tempx]);
                break;
            }
            else if(state[tempy][tempx].getPiece().getColor() == this.color) {
                break;
            }

            tempx--;
        }

       /*
       Adding East Movement
        */

        tempx = x + 1;
        tempy = y;
        while(tempx < 8) {
            if(state[tempy][tempx].getPiece() == null) {
                possibleNormalMoves.add(state[tempy][tempx]);
            }
            else if(state[tempy][tempx].getPiece().getColor() != this.color){
                possibleKillMoves.add(state[tempy][tempx]);
                break;
            }
            else if(state[tempy][tempx].getPiece().getColor() == this.color) {
                break;
            }

            tempx++;
        }

        possibleMoves.add(possibleNormalMoves);
        possibleMoves.add(possibleKillMoves);

        return possibleMoves;
    }
}
