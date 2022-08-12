package View.Component;

import View.Utility.MyUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyButton extends JButton {

    MyUtility util = new MyUtility();
    Color previousColorBack;
    Color previousColorFront;

    public MyButton (String text) {

        //decorate button
        this.setFont(util.myFontPrimary(30));
        this.setBackground(util.myBlackColor());
        this.setForeground(util.myWhiteColor());
        this.setBorder(new LineBorder(util.myThemeColor()));
        this.setFocusable(false);
        this.setText(text);


        this.addMouseListener(new MyMouseListener() {
            @Override
            public void mouseEntered(MouseEvent e) {
                previousColorFront = MyButton.super.getForeground();
                previousColorBack = MyButton.super.getBackground();

                MyButton.super.setBackground(util.myBlackHover());
                MyButton.super.setForeground(util.myGreenHover());

            }
            @Override
            public void mouseExited(MouseEvent e) {
                MyButton.super.setBackground(previousColorBack);
                MyButton.super.setForeground(previousColorFront);
//                MyButton.super.setForeground(util.myWhiteColor());

            }

        });

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }


    public static class MyMouseListener implements MouseListener {

            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        }






}
