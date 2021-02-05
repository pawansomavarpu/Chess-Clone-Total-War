import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by   on 4/30/2020.
 */
public class Cell extends Rectangle {

    Piece piece;
    PieceImage pieceImage;

    Cell(boolean color, int x, int y) {
        setHeight(100);
        setWidth(100);
        relocate(x * 100, y * 100);

        if(color) {
            setFill(Color.BLANCHEDALMOND);
        }
        else {
            setFill(Color.BURLYWOOD);
        }

        setStroke(Color.BLACK);
        setStrokeWidth(4);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public boolean hasPiece() {
        return piece!=null;
    }

    public PieceImage getPieceImage() {
        return pieceImage;
    }

    public void setPieceImage(PieceImage pieceImage) {
        this.pieceImage = pieceImage;
    }
}