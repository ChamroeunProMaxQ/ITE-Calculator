package View.Component;

import View.Utility.MyUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;


/***
 * this is extended from JTextField
 * for using this class you have to input x,y,w,h in as parameter
 * it requires the parameter to setBounds
 */
public class MyJTextField extends JTextField {

    MyUtility myUtility = new MyUtility();

    //set bounds by constructor
    public MyJTextField (int x, int y, int w, int h) {
        this.setFont(myUtility.myFontPrimary(35));
        this.setBackground(myUtility.myBlackColor());
        this.setForeground(myUtility.myWhiteColor());
        this.setBorder(new LineBorder(myUtility.myThemeColor()));
        this.setBounds(x,y,w,h);
        this.setEditable(false);
        this.setHorizontalAlignment(SwingConstants.RIGHT);

    }

    public MyJTextField() {
        this.setFont(myUtility.myFontPrimary(20));
        this.setBackground(myUtility.myBlackColor());
        this.setForeground(myUtility.myWhiteColor());
        this.setBorder(new LineBorder(myUtility.myThemeColor()));
        this.setEditable(false);
        this.setHorizontalAlignment(SwingConstants.RIGHT);
    }
}
