import javafx.animation.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *JavaFX poker game
 *<p>
 *A poker game is created on execution. The game consists of 2
 *players. A hand is dealed to both players and the player
 *with the most points is the winner.
 * </p>
 */
public class PokerDeal extends Animate {
  private Scene secondScene, thirdScene;
  @Override
  public void start(Stage firstScene){


        int p1 = 0;
        int p2 = 0;

        Deck game = new Deck();
        game.shuffle();
        PokerHand firstHand = new PokerHand();
        PokerHand secondHand = new PokerHand();
        Group firstLayout, secondLayout, thirdLayout;

        Label first = new Label();
        first.setText("PRESS PLAY TO BEGIN");
        first.setLayoutX(100);
        first.setLayoutY(80);
        first.setFont(new Font(40));
        first.setTextFill(Color.WHITE);

        Button deal = new Button("PLAY");
        deal.setLayoutX(270);
        deal.setLayoutY(300);
        deal.setFont(new Font(30));
        deal.setOnAction(e -> firstScene.setScene(secondScene));

        firstLayout = new Group();
        firstLayout.getChildren().addAll(deal, first);
        Scene scene = new Scene(firstLayout, 640, 400, Color.CADETBLUE);


        for(int dealp1=0;dealp1 < 5;dealp1++){
            firstHand.add(game.deal());
        }
        for(int dealp2=0;dealp2 < 5;dealp2++){
            secondHand.add(game.deal());
        }

        Button result = new Button("CHECK HANDS");
        result.setLayoutX(250);
        result.setLayoutY(110);
        result.setOnAction(e -> firstScene.setScene(thirdScene));

        Label player1 = new Label();
        player1.setText("Player 1");
        player1.setFont(new Font(40));
        player1.setTextFill(Color.BLACK);
        player1.setLayoutX(50);
        player1.setLayoutY(310);


        Label player2 = new Label();
        player2.setText("Player 2");
        player2.setFont(new Font(40));
        player2.setTextFill(Color.SNOW);
        player2.setLayoutX(420);
        player2.setLayoutY(310);

        secondLayout = new Group();
        for(int i=0;i<5;i++){
            secondLayout.getChildren().addAll(new ImageView(firstHand.cards.get(i).getImage()));
        }
        for(int j=0;j<5;j++){
             secondLayout.getChildren().addAll(new ImageView(secondHand.cards.get(j).getImage()));
        }

        int k = 510;
        int l = 130;
        secondLayout.getChildren().addAll(result, player1, player2);
        for(int p = 0;p<5;p++){

            TranslateTransition translate1 = new TranslateTransition(Duration.millis(3000));
            translate1.setToX(k);
            translate1.setToY(210);
            RotateTransition rotate = new RotateTransition(Duration.millis(3500));
            rotate.setToAngle(370);
            ParallelTransition transition = new ParallelTransition(secondLayout.getChildren().get(p), translate1,rotate);
            transition.play();
            k -= 20;
        }
        for(int q = 5;q<10;q++){
            TranslateTransition translate6 = new TranslateTransition(Duration.millis(3000));
            translate6.setToX(l);
            translate6.setToY(210);
            RotateTransition rotate2 = new RotateTransition(Duration.millis(3500));
            rotate2.setToAngle(350);
            ParallelTransition transition = new ParallelTransition(secondLayout.getChildren().get(q), translate6,rotate2);
            transition.play();
            l -= 20;
        }

        secondScene = new Scene(secondLayout,640, 400, Color.CADETBLUE);


        if(firstHand.isPair()){
            p1++;
        }
        if(firstHand.isTwoPairs()){
            p1 += 2;
        }
        if(firstHand.isThreeOfAKind()){
            p1 += 3;
        }
        if(firstHand.isStraight()){
            p1 += 4;
        }
        if(firstHand.isFlush()){
            p1 += 5;
        }
        if(firstHand.isFullHouse()){
            p1 += 6;
        }
        if(firstHand.isFourOfAKind()){
            p1 += 7;
        }

        if(secondHand.isPair()){
            p2++;
        }
        if(secondHand.isTwoPairs()){
            p2 += 2;
        }
        if(secondHand.isThreeOfAKind()){
            p2 += 3;
        }
        if(secondHand.isStraight()){
            p2 += 4;
        }
        if(secondHand.isFlush()){
            p2 += 5;
        }
        if(secondHand.isFullHouse()){
            p2 += 6;
        }
        if(secondHand.isFourOfAKind()){
            p2 += 7;
        }

        Label winner = new Label();
        winner.setFont(new Font(60));
        winner.setTextFill(Color.SNOW);

        if (p1 > p2){
            winner.setText("PLAYER 1 WON");
            winner.setLayoutX(110);
            winner.setLayoutY(160);
        }
        else if (p2 > p1){
            winner.setText("PLAYER 2 WON");
            winner.setLayoutX(110);
            winner.setLayoutY(160);
        }
        else{
            winner.setText("DRAW");
            winner.setLayoutX(260);
            winner.setLayoutY(160);
        }
        Label scores = new Label();
        scores.setText("Player 1 score: "+p1+"\nPlayer 2 score: "+p2);
        scores.setLayoutX(200);
        scores.setLayoutY(300);
        scores.setFont(new Font(30));
        scores.setTextFill(Color.SNOW);

        thirdLayout = new Group();
        thirdLayout.getChildren().addAll(winner, scores);

        thirdScene = new Scene(thirdLayout,640, 400, Color.CADETBLUE);

        firstScene.setTitle("Poker Demo");
        firstScene.setScene(scene);
        firstScene.show();
  }
  public static void main(String[] args){
        launch(args);
  }

}
