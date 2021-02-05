import java.util.ArrayList;

/**
 * Created by   on 4/30/2020.
 */
public class Piece {

    String path;
    int color;

    public Piece() {

    }

    ArrayList<ArrayList<Cell>> possibleMoves = new ArrayList<>();

    public ArrayList<ArrayList<Cell>> getPossibleMoves(Cell state[][], int x, int y) {
        return possibleMoves;
    }


    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
