package View;

import Controller.MainController;
import View.Component.*;
import View.Utility.MyUtility;


import javax.swing.*;
import java.awt.*;


public class MyView extends JFrame {

    //call usable object for this class
    MyUtility util = new MyUtility();

    //instant obj
    private JPanel cardPanel;
    JMenuBar menuBar ;

    public JPanel getCardPanel() {
        return cardPanel;
    }

    //constructor
    public MyView() {

        this.setTitle("Kon Khmer Calculator");
        this.setSize(680,720);
        this.setMinimumSize(new Dimension(680,720));

        menuBar = new MyMenuBar();
        this.setJMenuBar(menuBar);

        createCard();

        this.getContentPane().setBackground(util.myThemeColor());
        this.getContentPane().add(cardPanel);

        this.addKeyListener(MainController.StandardController.keyListen(this));
        this.setFocusable(true);
        this.setResizable(true);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(util.mainIcon());

    }

    //card layout
    private void createCard () {
        MyPanel myPanel = new MyPanel();
        cardPanel = new JPanel(new CardLayout());
        cardPanel.setBounds(20,10,630,200);
        //instant object
        JPanel BAPanel = myPanel.binaryArithmeticPanel();
        JPanel StandardPanel = myPanel.standardPanel();
        JPanel NumConverterPanel = myPanel.numberSystemConverterPanel();
        JPanel TrigonometryPanel = myPanel.trigonometryPanel();
        JPanel BitwisePanel = myPanel.bitwisePanel();
        JPanel StorageConverterPanel = myPanel.storageConverterPanel();

        cardPanel.add("Standard",StandardPanel);
        cardPanel.add("Trigonometry",TrigonometryPanel);
        cardPanel.add("Binary Arithmetic", BAPanel);
        cardPanel.add("Number System Converter",NumConverterPanel);
        cardPanel.add("Storage Converter",StorageConverterPanel);
        cardPanel.add("Bitwise",BitwisePanel);
    }

}
