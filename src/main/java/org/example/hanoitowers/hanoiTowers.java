package org.example.hanoitowers;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

public class hanoiTowers {
    @FXML
    private VBox lft,mdl,rght;
    private static final int BASE_DISK_SIZE = 50;
    private static final int DISK_HEIGHT = 30;
    private Rectangle[] disks;

    public void initialize() throws InterruptedException {
        lft.setAlignment(Pos.BOTTOM_CENTER);
        mdl.setAlignment(Pos.BOTTOM_CENTER);
        rght.setAlignment(Pos.BOTTOM_CENTER);
        disks = new Rectangle[HelloController.disksNum+1];
        for (int i = 1; i < HelloController.disksNum+1; i++) {
            int finalI = i;
            Rectangle disk = new Rectangle(BASE_DISK_SIZE + finalI * 10, DISK_HEIGHT);
            disk.setFill(Color.web("#436850"));
            disk.setStroke(Color.BLACK);
            disk.setStrokeWidth(2);
            disk.setId("disk" + finalI);
            disks[finalI] = disk;
            lft.getChildren().add(disk);
        }
        hT(HelloController.disksNum,lft,rght,mdl);
//        Rectangle disko =(Rectangle) lft.getChildren().getFirst();
//        lft.getChildren().remove(0);
//        rght.getChildren().add(disko);
//        Node first = lft.getChildren().get(0);
//        rght.getChildren().add(first);
//        System.out.println(lft.getChildren().get(0).getId());
    }

    public void hT (int n, VBox from,VBox to, VBox que){
//        PauseTransition delay = new PauseTransition(Duration.seconds(1));
//        delay.setOnFinished(event -> {});
//        delay.play();
            if (n == 1) {
                to.getChildren().add(0, from.getChildren().getFirst());
                return;
            }
//            delay.setOnFinished(event -> {
            hT(n - 1, from, que, to);
//            });
//        delay.play();
//        delay.setOnFinished(event -> {
            for (javafx.scene.Node node : from.getChildren()) {
                if (node instanceof Rectangle && node.getId() != null && node.getId().equals("disk" +(HelloController.disksNum-n))) {
                    to.getChildren().add(0, node);
                    break;
                }
            }
            }
//        );
//        delay.play();
            delay.setOnFinished(event -> {
            hT(n - 1, que, to, from);
//        });
//        delay.play();
    }
//    public void hT(int n,VBox from,VBox to,VBox que){
//        if(n==0)
//            return;
//        hT(n-1,from,que,to);
//        for (javafx.scene.Node node : from.getChildren()) {
//                if (node instanceof Rectangle && node.getId() != null && node.getId().equals("disk" + n)) {
//                    to.getChildren().add(0, node);
//                    break;
//                }
//            }
//        hT(n-1,que,to,from);
//    }
//public void hT(int n, VBox from, VBox to, VBox que) {
//    if (n == 0)
//        return;
//
//    hT(n - 1, from, que, to);
//
//    for (javafx.scene.Node node : from.getChildren()) {
//        if (node instanceof Rectangle && node.getId() != null && node.getId().equals("disk" +(HelloController.disksNum-n))) {
//            PauseTransition pause = new PauseTransition(Duration.seconds(1));
//            pause.setOnFinished(event -> {
//                to.getChildren().add(0, node);
//            });
//            pause.play();
//            break;
//        }
//    }
//
//    hT(n - 1, que, to, from);
//}
}