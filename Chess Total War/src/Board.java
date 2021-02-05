import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by   on 4/30/2020.
 */
public class Board extends Application{

    Cell board[][] = new Cell[8][8];
    Group cellGroup = new Group();
    Group pieceGroup = new Group();

    //White Pieces
    King wk = new King("whiteKing.png", 0);
    Queen wq = new Queen("whiteQueen.png", 0);
    Bishop wb1 = new Bishop("whiteBishop.png", 0);
    Knight wk1 = new Knight("whiteKnight.png", 0);
    Rook wr1 = new Rook("whiteRook.png", 0);
    Pawn wp1 = new Pawn("whitePawn.png", 0);

    //Black Pieces
    King bk = new King("blackKing.png", 1);
    Queen bq = new Queen("blackQueen.png", 1);
    Bishop bb1 = new Bishop("blackBishop.png", 1);
    Knight bk1 = new Knight("blackKnight.png", 1);
    Rook br1 = new Rook("blackRook.png", 1);
    Pawn bp1 = new Pawn("blackPawn.png", 1);

    boolean redTurn = true;
    int KingCounter;
    boolean victory = false;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Menu
        Stage windowMenu = new Stage();
        GridPane rootMenu = new GridPane();


        Label label1 = new Label(" Chanji");
        label1.setFont(new Font("Arial",50));

        Button rules = new Button("Rules");
        rules.setPrefSize(200, 100);
        rules.setOnAction(event -> {
            // Rules explained
            windowMenu.close();
            Stage windowRules = new Stage();
            GridPane rootRules = new GridPane();
            rootRules.setPrefSize(700, 320);
            rootRules.setPadding(new Insets(10, 10, 10, 10));

            Label labelRule = new Label();
            labelRule.setText("Rules: \n" + "The Rules of Chanji are similar to Chess but with certain altercations. \n" +
                    "Movement altercations include that Pawns can move backwards and in all \n" +
                    "directions a maximum of 1 tile. The main change is the victory condition. \n" +
                    "A player must kill the king of the opposing player to win. There are no \n" +
                    "check dynamics so killing a king is fair game. Furthermore a stalemate is \n" +
                    "induced if both players are reduced to only 3 pieces each. Have fun playing!");
            labelRule.setFont(new Font("Arial", 20));

            Button play2 = new Button("Play");
            play2.setPrefSize(700, 100);
            play2.setOnAction(event2 -> {
                // Chess Board
                windowMenu.close();
                Stage window = primaryStage;
                Pane root = new Pane();
                root.setPrefSize(800, 800);
                initBoard();
                root.getChildren().addAll(cellGroup, pieceGroup);
                Scene scene = new Scene(root);
                window.setTitle("Chess");
                window.setScene(scene);
                window.show();
            });

            rootRules.setConstraints(labelRule, 0, 0);
            rootRules.setConstraints(play2, 0, 1);

            rootRules.getChildren().addAll(labelRule, play2);
            rootRules.setVgap(20);

            Scene sceneRule = new Scene(rootRules);
            windowRules.setTitle("Rules");
            windowRules.setScene(sceneRule);
            windowRules.show();
        });

        Button play = new Button("Play");
        play.setPrefSize(200, 100);
        play.setOnAction(event -> {
            // Chess Board
            windowMenu.close();
            Stage window = primaryStage;
            Pane root = new Pane();
            root.setPrefSize(800, 800);
            initBoard();
            root.getChildren().addAll(cellGroup, pieceGroup);
            Scene scene = new Scene(root);
            window.setTitle("Chess");
            window.setScene(scene);
            window.show();
        });

        rootMenu.setConstraints(label1, 0, 0);
        rootMenu.setConstraints(play, 0, 1);
        rootMenu.setConstraints(rules, 0, 2);
        rootMenu.setPadding(new Insets(10, 10, 10, 10));
        rootMenu.setVgap(10);
        rootMenu.getChildren().addAll(label1, play, rules);
        rootMenu.setPrefSize(200,300);
        Scene sceneMenu = new Scene(rootMenu);
        windowMenu.setTitle("Main Menu");
        windowMenu.setScene(sceneMenu);
        windowMenu.show();


    }

    public void initBoard() {

        Piece p;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                p = null;

                if ((i == 0 && j == 0)) {
                    p = br1;
                } else if ((i == 0 && j == 7)) {
                    p = br1;
                } else if ((i == 0 && j == 1)) {
                    p = bk1;
                } else if ((i == 0 && j == 6)) {
                    p = bk1;
                } else if ((i == 0 && j == 2)) {
                    p = bb1;
                } else if ((i == 0 && j == 5)) {
                    p = bb1;
                } else if ((i == 0 && j == 3)) {
                    p = bq;
                } else if ((i == 0 && j == 4)) {
                    p = bk;
                } else if ((i == 7 && j == 0)) {
                    p = wr1;
                } else if ((i == 7 && j == 7)) {
                    p = wr1;
                } else if ((i == 7 && j == 1)) {
                    p = wk1;
                } else if ((i == 7 && j == 6)) {
                    p = wk1;
                } else if ((i == 7 && j == 2)) {
                    p = wb1;
                } else if ((i == 7 && j == 5)) {
                    p = wb1;
                } else if ((i == 7 && j == 3)) {
                    p = wq;
                } else if ((i == 7 && j == 4)) {
                    p = wk;
                } else if (i == 1) {
                    p = bp1;
                } else if (i == 6) {
                    p = wp1;
                }

                Cell cell = new Cell(((i + j) % 2 == 0), j, i);
                cell.setPiece(p);
                board[i][j] = cell;
                cellGroup.getChildren().add(cell);

            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].getPiece() != null) {
                    Piece p2 = board[i][j].getPiece();
                    PieceImage pieceImage = makePiece(p2, j, i);
                    board[i][j].setPieceImage(pieceImage);
                    pieceGroup.getChildren().add(board[i][j].getPieceImage());
                }
            }
        }

    }

    public PieceImage makePiece(Piece p, int x, int y) {
        PieceImage pieceImage = new PieceImage(p, x, y);



        pieceImage.setOnMouseReleased(event -> {

            int releasedx = (int) ((event.getSceneX())/100);
            int releasedy = (int) ((event.getSceneY())/100);
            int origx = (int) (pieceImage.getOldX()/100);
            int origy = (int) (pieceImage.getOldY()/100);

            ArrayList<ArrayList<Cell>> possibleMoves = new ArrayList<ArrayList<Cell>>();
            possibleMoves = board[origy][origx].getPiece().getPossibleMoves(board, origx, origy);
            ArrayList<Cell> possibleNormalMoves = possibleMoves.get(0);
            ArrayList<Cell> possibleKillMoves = possibleMoves.get(1);

            if(redTurn) {
                if(board[origy][origx].getPiece().getColor() == 0) {
                    if(possibleKillMoves.isEmpty() && possibleNormalMoves.isEmpty()) {
                        pieceImage.abortMove();
                    }
                    else {
                        for(int i = 0; i < possibleNormalMoves.size(); i++) {
                            if(board[releasedy][releasedx] == possibleNormalMoves.get(i)) {
                                Piece temp = board[origy][origx].getPiece();
                                PieceImage temp2 = board[origy][origx].getPieceImage();
                                board[origy][origx].setPiece(null);
                                board[releasedy][releasedx].setPiece(temp);
                                board[origy][origx].setPieceImage(null);
                                board[releasedy][releasedx].setPieceImage(temp2);

                                pieceImage.move(releasedx*100, releasedy*100);
                                redTurn = false;
                            }
                            else {
                                pieceImage.abortMove();
                            }
                        }

                        for(int i = 0; i < possibleKillMoves.size(); i++) {
                            if(board[releasedy][releasedx] == possibleKillMoves.get(i)) {

                                board[releasedy][releasedx].setPiece(null);
                                Piece temp = board[origy][origx].getPiece();
                                board[origy][origx].setPiece(null);
                                board[releasedy][releasedx].setPiece(temp);

                                pieceGroup.getChildren().remove(board[releasedy][releasedx].getPieceImage());
                                board[releasedy][releasedx].setPieceImage(board[origy][origx].getPieceImage());
                                board[origy][origx].setPieceImage(null);

                                pieceImage.move(releasedx*100, releasedy*100);
                                redTurn = false;
                            }
                            else {
                                pieceImage.abortMove();
                            }
                        }
                    }

                }
                else {
                    pieceImage.relocate(origx*100, origy*100);
                }
            }
            else {
                if(board[origy][origx].getPiece().getColor() == 1) {
                    if(possibleKillMoves.isEmpty() && possibleNormalMoves.isEmpty()) {
                        pieceImage.abortMove();
                    }
                    else {
                        for(int i = 0; i < possibleNormalMoves.size(); i++) {
                            if(board[releasedy][releasedx] == possibleNormalMoves.get(i)) {
                                Piece temp = board[origy][origx].getPiece();
                                PieceImage temp2 = board[origy][origx].getPieceImage();
                                board[origy][origx].setPiece(null);
                                board[releasedy][releasedx].setPiece(temp);
                                board[origy][origx].setPieceImage(null);
                                board[releasedy][releasedx].setPieceImage(temp2);

                                pieceImage.move(releasedx*100, releasedy*100);
                                redTurn = true;
                            }
                            else {
                                pieceImage.abortMove();
                            }
                        }

                        for(int i = 0; i < possibleKillMoves.size(); i++) {
                            if(board[releasedy][releasedx] == possibleKillMoves.get(i)) {

                                board[releasedy][releasedx].setPiece(null);
                                Piece temp = board[origy][origx].getPiece();
                                board[origy][origx].setPiece(null);
                                board[releasedy][releasedx].setPiece(temp);

                                pieceGroup.getChildren().remove(board[releasedy][releasedx].getPieceImage());
                                board[releasedy][releasedx].setPieceImage(board[origy][origx].getPieceImage());
                                board[origy][origx].setPieceImage(null);

                                pieceImage.move(releasedx*100, releasedy*100);
                                redTurn = true;
                            }
                            else {
                                pieceImage.abortMove();
                            }
                        }
                    }

                }
                else {
                    pieceImage.relocate(origx*100, origy*100);
                }
            }

            if(checkWin()) {
                for(int i = 0; i < 8; i++) {
                    for(int j = 0; j < 8; j++) {
                        if(board[i][j].getPiece() != null) {
                            board[i][j].getPiece().setColor(3);
                        }
                    }
                }

                Stage window2 = new Stage();
                StackPane root2 = new StackPane();
                root2.setPrefSize(450, 300);
                Label label2 = new Label();
                label2.setText("The "+getVictor(redTurn)+" Player has won the game!!!");
                label2.setFont(new Font("Arial", 24));
                root2.getChildren().add(label2);
                Scene scene2 = new Scene(root2);
                window2.setTitle("Victory!");
                window2.setScene(scene2);
                window2.show();
            }

        });

        return pieceImage;
    }

    public String getVictor(boolean redTurn) {
        if(redTurn) {
            return "Black";
        }
        else {
            return "Red";
        }
    }

    public boolean checkWin() {
        boolean won = false;
        KingCounter = 0;


        for(int i = 0; i < 8;i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j].getPiece() instanceof King) {
                    KingCounter++;
                }
            }
        }


        if(KingCounter == 1) {
            won = true;
        }

        return won;
    }
}