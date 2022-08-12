package View.Utility;

import javax.swing.*;
import java.awt.*;

public class MyUtility {

    public Font myFontPrimary(int font_size) {
        return new Font(Font.DIALOG,Font.PLAIN,font_size);
    }
    public Font myFontSecondary(int font_size) {
        return new Font(Font.DIALOG_INPUT,Font.PLAIN,font_size);
    }
    public Font FreeStyleFont (int font_size) {
    return new Font(Font.SERIF,Font.PLAIN,50);
    }
    public Font KhmerFont (int font_size) {return new Font("Khmer OS Siemreap",Font.PLAIN,font_size);}

    public Color myThemeColor () {
        return new Color(45, 45, 48);
    }
    public Color myGreenColor () {
        return new Color(18, 150, 3);
    }
    public Color myBlackColor () {
        return new Color(14,17,14);
    }

    public Color myWhiteColor () {
        return new Color(255, 255, 255);
    }
    public Color myBlackHover () {
        return new Color(39, 46, 39);
    }
    public Color myGreenHover () {
        return new Color(140, 191, 140);
    }
    public Color myYellowColor () {return new Color(238, 210, 72, 255);}
    public Color myDarkgrayColor () {return new Color(189, 187, 187);}

    public Image mainIcon () {
        ImageIcon icon = new ImageIcon("src/View/assets/main_icon.png");

        return icon.getImage();
    }

}
