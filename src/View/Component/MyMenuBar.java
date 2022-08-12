package View.Component;

import Controller.MainController;
import View.Utility.MyUtility;

import javax.swing.*;
import java.awt.*;

public class MyMenuBar extends JMenuBar {

    MyUtility util = new MyUtility();

    JMenu menu;
    JMenuItem Standard;
    JMenuItem BinaryArithmetic;
    JMenuItem NumberSystemConverter;
    JMenuItem StorageConverter;
    JMenuItem Bitwise;
    JMenuItem SetTheory;
    JMenuItem Trigonometry;
    JMenuItem Exit;

    ImageIcon imageIcon = new ImageIcon("src/View/assets/menuBar.png");

    public MyMenuBar ()  {

    myMenu();
    this.add(menu);
    this.setBackground(util.myThemeColor());
    this.setBorder(BorderFactory.createEmptyBorder());
    this.setFocusable(true);

    }

    private void myMenu () {
        menu = new JMenu();
        menu.setPreferredSize(new Dimension(50,40));

        Standard = new JMenuItem("Standard");
        Trigonometry  = new JMenuItem("Trigonometry");
        BinaryArithmetic = new JMenuItem("Binary Arithmetic");
        NumberSystemConverter = new JMenuItem("Number System Converter");
        StorageConverter = new JMenuItem("Storage Converter");
        Bitwise = new JMenuItem("Bitwise");
        SetTheory = new JMenuItem("Set Theory");
        Exit = new JMenuItem("Exit");

        JMenuItem[] jMenuItems = {Standard,Trigonometry,BinaryArithmetic,NumberSystemConverter,StorageConverter,
                                Bitwise,SetTheory,Exit};

        for(JMenuItem jMenuItem : jMenuItems ){
            menu.add(jMenuItem);
            jMenuItem.addActionListener(new MainController.Route(this));
        }


        Image image = imageIcon.getImage();
        Image image_scale = image.getScaledInstance(35,25,Image.SCALE_SMOOTH);
        ImageIcon imageIconZin = new ImageIcon(image_scale);

        menu.setIcon(imageIconZin);


    }


}
