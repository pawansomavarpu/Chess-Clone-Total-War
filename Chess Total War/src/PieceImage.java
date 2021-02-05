import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by   on 4/30/2020.
 */
public class PieceImage extends ImageView {

    Piece piece;
    double mouseX, mouseY;
    double oldX, oldY;

    public PieceImage(Piece piece, int x, int y) {

        setPiece(piece);
        Image img = new Image(piece.getPath());
        setImage(img);

        setFitWidth(100);
        setFitHeight(100);
        move(x*100, y*100);

        setOnMousePressed(event -> {
            mouseX = event.getSceneX();
            mouseY = event.getSceneY();
        });

        setOnMouseDragged(event -> {
            relocate(event.getSceneX() - mouseX + oldX, event.getSceneY() - mouseY + oldY);
        });

    }

    public void move(int x, int y) {
        setOldX(x);
        setOldY(y);
        relocate(oldX, oldY);
    }

    public void abortMove() {
        relocate(oldX, oldY);
    }

    public void deletePiece() {
        setImage(null);
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }
}