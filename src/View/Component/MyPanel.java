package View.Component;

import Controller.MainController;
import View.Utility.MyUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;


/***
 * this class is extended from JPanel
 */
public class MyPanel {

    MyUtility util = new MyUtility();

    private final JTextField descriptionField4BA = new MyJTextField(20, 0, 610, 60);
    private final JTextField displayField4BA = new MyJTextField(120, 90, 510, 60);

    public JTextField getDescriptionField4BA() {
        return descriptionField4BA;
    }
    public JTextField getDisplayField4BA() {
        return displayField4BA;
    }

    private final MyJTextField binaryTextField = new MyJTextField();
    private final MyJTextField decimalTextField = new MyJTextField();
    private final MyJTextField octalTextField = new MyJTextField();
    private final MyJTextField hexadecimal = new MyJTextField();
    private final JLabel inp = new JLabel();
    private final MyJTextField displayField4NSC = new MyJTextField();

    public JTextField getBinaryTextField() {
        return binaryTextField;
    }
    public JTextField getDecimalTextField() {
        return decimalTextField;
    }
    public JTextField getOctalTextField() {
        return octalTextField;
    }
    public JTextField getHexadecimal() {
        return hexadecimal;
    }

    public JLabel getInp() {
        return inp;
    }
    public MyJTextField getDisplayField4NSC() {
        return displayField4NSC;
    }

    private final MyJTextField byteTextField = new MyJTextField();
    private final MyJTextField kilobyteTextField = new MyJTextField();
    private final MyJTextField megabyteTextField = new MyJTextField();
    private final MyJTextField gigabyteTextField = new MyJTextField();

    public MyJTextField getByteTextField() {
        return byteTextField;
    }
    public MyJTextField getKilobyteTextField() {
        return kilobyteTextField;
    }
    public MyJTextField getMegabyteTextField() {
        return megabyteTextField;
    }
    public MyJTextField getGigabyteTextField() {
        return gigabyteTextField;
    }

    private final JTextField descriptionField = new MyJTextField(20, 0, 610, 60);
    private final JTextField displayField = new MyJTextField(120, 90, 510, 60);

    public JTextField getDescriptionField() {
        return descriptionField;
    }
    public JTextField getDisplayField() {
        return displayField;
    }

    private final JTextField descriptionField4trio = new MyJTextField(20, 0, 610, 60);
    private final JTextField displayField4Trio = new MyJTextField(120, 90, 510, 60);

    public JTextField getDescriptionField4trio() {
        return descriptionField4trio;
    }
    public JTextField getDisplayField4Trio() {
        return displayField4Trio;
    }

    private final JTextField descriptionField4BW = new MyJTextField(20, 0, 610, 60);
    private final JTextField displayField4BW = new MyJTextField(120, 90, 510, 60);

    public JTextField getDisplayField4BW() {
        return displayField4BW;
    }

    public JTextField getDescriptionField4BW() {
        return descriptionField4BW;
    }

    //declare button
    private MyButton e_btn;
    private MyButton f_btn;
    private MyButton d_btn;
    private MyButton num7_btn;
    private MyButton num8_btn;
    private MyButton num9_btn;
    private MyButton c_btn;
    private MyButton num4_btn;
    private MyButton num5_btn;
    private MyButton num6_btn;
    private MyButton b_btn;
    private MyButton num1_btn;
    private MyButton num2_btn;
    private MyButton num3_btn;
    private MyButton a_btn;
    private MyButton num0_btn;

    public MyButton[] getBtnDisable4Bin () {
        return new MyButton[]{a_btn, b_btn,c_btn,d_btn,e_btn,f_btn,num2_btn,num3_btn,num4_btn,num5_btn,
                                num6_btn,num7_btn,num8_btn,num9_btn};
    }
    public MyButton[] getAllBtn () {
        return new MyButton[]{a_btn, b_btn,c_btn,d_btn,e_btn,f_btn,num0_btn,num1_btn, num2_btn,num3_btn,
                num4_btn,num5_btn, num6_btn,num7_btn,num8_btn,num9_btn};
    }
    public MyButton[] getBtnDisable4Dec () {
        return new MyButton[] {a_btn,b_btn,c_btn,d_btn,e_btn,f_btn};
    }

    /***
     * method is used to shorten the way to set gridBagConstant
     * @param grid_x int
     * @param grid_y int
     * @param width_x double
     * @param width_y double
     * @return gridBagConstant
     */
    private GridBagConstraints gridConstant (int grid_x,int grid_y,double width_x,double width_y) {

        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = grid_x;
        constraints.gridy = grid_y;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = width_x;
        constraints.weighty = width_y;

        return constraints;

    }

    private JPanel standardTextField(JTextField descriptionField, JTextField displayField) {
        JPanel textField = new JPanel(new GridLayout(2, 1));
        JTextField back = new MyJTextField(0, 0, 680, 200);

        displayField.setBorder(new LineBorder(util.myGreenColor()));
        descriptionField.setBorder(new LineBorder(util.myBlackColor()));

        //custom text field
        descriptionField.setFont(util.myFontSecondary(30));
        displayField.setFont(util.FreeStyleFont(30));

        textField.setBackground(util.myBlackColor());
        textField.setPreferredSize(new Dimension(645, 160));
        back.setBackground(util.myBlackColor());

        textField.add(descriptionField);
        textField.add(displayField);

        return textField;
    }
    private JPanel btnPanel4BA() {
        JPanel btn_panel4BA = new JPanel(new GridLayout(3, 3));

        String[] btn_text = {"/","AC","del","*","1","+","-","0","="};

        for (String name : btn_text) {
            MyButton button = new MyButton(name);
            btn_panel4BA.add(button);
            button.addActionListener(new MainController.BAController(this));
            if(name.equals("=")){
                button.setBackground(util.myGreenColor());
            }
            if(name.equals("AC")){
                button.setForeground(util.myYellowColor());
            }
            if(name.equals("del")){
                button.setForeground(Color.red);
            }
        }

        btn_panel4BA.setPreferredSize(new Dimension(645, 450));

        return btn_panel4BA;
    }
    private JPanel btnPanel4NSC() {

        JPanel myBtnPanel = new JPanel(new GridLayout(6,4));
        MyButton bin_btn = new MyButton("Bin");
        MyButton dec_btn = new MyButton("Dec");
        MyButton oct_btn = new MyButton("Oct");
        MyButton hex_btn = new MyButton("Hex");
         e_btn = new MyButton("E");
         f_btn = new MyButton("F");
        MyButton clr_btn = new MyButton("AC");
        clr_btn.setForeground(util.myYellowColor());
        MyButton del_btn = new MyButton("del");
        del_btn.setForeground(Color.red);
         d_btn = new MyButton("D");
         num7_btn = new MyButton("7");
         num8_btn = new MyButton("8");
         num9_btn = new MyButton("9");
         c_btn = new MyButton("C");
         num4_btn = new MyButton("4");
         num5_btn = new MyButton("5");
         num6_btn = new MyButton("6");
         b_btn = new MyButton("B");
         num1_btn = new MyButton("1");
         num2_btn = new MyButton("2");
         num3_btn = new MyButton("3");
         a_btn = new MyButton("A");
         num0_btn = new MyButton("0");
        MyButton point_btn = new MyButton(".");
        point_btn.setEnabled(false);
        MyButton equ_btn = new MyButton("=");

        MyButton[] all_btn = {bin_btn,dec_btn,oct_btn,hex_btn,
                                e_btn,f_btn,clr_btn,del_btn,
                                d_btn,num7_btn,num8_btn,num9_btn,
                                c_btn,num4_btn,num5_btn,num6_btn,
                                b_btn,num1_btn,num2_btn,num3_btn,
                                a_btn,num0_btn,point_btn,equ_btn};

        for(MyButton button : all_btn) {
            myBtnPanel.add(button);
            button.addActionListener(new MainController.NSCController(this));
            button.setEnabled(false);
            if(button.getText().equals("del")||button.getText().equals("AC")){
                button.setEnabled(true);
            }
        }
        for(int i = 0; i< 4; i++){
            all_btn[i].setEnabled(true);
            all_btn[i].setForeground(util.myWhiteColor());
        }

        myBtnPanel.setPreferredSize(new Dimension(645, 450));
        return myBtnPanel;
    }
    private JPanel btnPanel4SC () {

        JPanel storage_panel = new JPanel(new GridLayout(4,3));

        MyButton byte_btn = new MyButton("Byte");
        MyButton num0_btn = new MyButton("0");
        MyButton clr_btn = new MyButton("AC");
        MyButton del_btn = new MyButton("del");
        MyButton kb_btn = new MyButton("KB");
        MyButton num7_btn = new MyButton("7");
        MyButton num8_btn = new MyButton("8");
        MyButton num9_btn = new MyButton("9");
        MyButton mb_btn = new MyButton("MB");
        MyButton num4_btn = new MyButton("4");
        MyButton num5_btn = new MyButton("5");
        MyButton num6_btn = new MyButton("6");
        MyButton gb_btn = new MyButton("GB");
        MyButton num1_btn = new MyButton("1");
        MyButton num2_btn = new MyButton("2");
        MyButton num3_btn = new MyButton("3");



        MyButton[] all_btn = {
                byte_btn,num0_btn,clr_btn,del_btn,
                kb_btn,num7_btn,num8_btn,num9_btn,
                mb_btn,num4_btn,num5_btn,num6_btn,
                gb_btn,num1_btn,num2_btn,num3_btn};

        for(MyButton button : all_btn) {
            storage_panel.add(button);
        }

        storage_panel.setPreferredSize(new Dimension(645, 450));
        return storage_panel;
    }
    private JPanel btnPanel4Trio() {
        JPanel btn_panel = new JPanel(new GridLayout(6,4));

        String[] button_text = {"sin", "cos","AC","del","tan","7","8","9","deg","4","5","6","rad","1","2","3","x^3",
                                "x^2","0",".","∛","√","π","="};

        for (String buttons :  button_text){
            MyButton button = new MyButton(buttons);
            btn_panel.add(button);
            button.addActionListener(new MainController.TriController(this));
            if(buttons.equals("del")){
                button.setForeground(Color.red);
            }
            if(buttons.equals("AC")){
                button.setForeground(util.myYellowColor());
            }
            if(buttons.equals("=")){
                button.setBackground(util.myGreenColor());
            }
        }

        btn_panel.setPreferredSize(new Dimension(645, 450));
        return btn_panel;

    }
    private JPanel btnPanel() {
        JButton left_pa_btn = new MyButton("(");
        JButton right_pa_btn = new MyButton(")");
        JButton clr_pa_btn = new MyButton("AC");
        JButton del_btn = new MyButton("del");
        JButton num7_btn = new MyButton("7");
        JButton num8_btn = new MyButton("8");
        JButton num9_btn = new MyButton("9");
        JButton div_btn = new MyButton("/");
        JButton num4_btn = new MyButton("4");
        JButton num5_btn = new MyButton("5");
        JButton num6_btn = new MyButton("6");
        JButton mul_btn = new MyButton("*");
        JButton num1_btn = new MyButton("1");
        JButton num2_btn = new MyButton("2");
        JButton num3_btn = new MyButton("3");
        JButton sub_btn = new MyButton("-");
        JButton sign_btn = new MyButton("+/-");
        JButton num0_btn = new MyButton("0");
        JButton dec_btn = new MyButton(".");
        JButton add_btn = new MyButton("+");
        JButton sqrt_btn = new MyButton("√");
        JButton pi_btn = new MyButton("π");
        JButton mod_btn = new MyButton("%");
        JButton equ_btn = new MyButton("=");

        JButton[] all_btn = {left_pa_btn, right_pa_btn, clr_pa_btn, del_btn,
                num7_btn, num8_btn, num9_btn, div_btn,
                num4_btn, num5_btn, num6_btn, mul_btn,
                num1_btn, num2_btn, num3_btn, sub_btn,
                sign_btn, num0_btn, dec_btn, add_btn,
                sqrt_btn, pi_btn, mod_btn, equ_btn};

        JPanel btn_panel = new JPanel(new GridLayout(6, 4));

        for (JButton button : all_btn) {
            btn_panel.add(button);
            button.addActionListener(new MainController.StandardController(this));
            if(button.getText().equals("AC")){
                button.setForeground(util.myYellowColor());
            }
            if(button.getText().equals("=")){
                button.setBackground(util.myGreenColor());
            }
            if(button.getText().equals("del")){
                button.setForeground(Color.red);
            }

        }

        btn_panel.setPreferredSize(new Dimension(645, 450));

        return btn_panel;
    }
    private JPanel btnPanel4BW() {

        JButton and_btn = new MyButton("AND");
        JButton or_btn = new MyButton("OR");
        JButton clr_btn = new MyButton("AC");
        JButton del_btn = new MyButton("del");
        JButton num7_btn = new MyButton("7");
        JButton num8_btn = new MyButton("8");
        JButton num9_btn = new MyButton("9");
        JButton xor_btn = new MyButton("XOR");
        JButton num4_btn = new MyButton("4");
        JButton num5_btn = new MyButton("5");
        JButton num6_btn = new MyButton("6");
        JButton left_btn = new MyButton("L-shift");
        JButton num1_btn = new MyButton("1");
        JButton num2_btn = new MyButton("2");
        JButton num3_btn = new MyButton("3");
        JButton right_btn = new MyButton("R-shift");
        JButton bitInversion_btn = new MyButton("bit");
        JButton num0_btn = new MyButton("0");
        JButton dec_btn = new MyButton(".");
        JButton equ_btn = new MyButton("=");

        String[] buttons = {"AND","OR","AC","del","7","8","9","XOR","4","5","6","L-shift",
                            "1","2","3","R-shift","bit","0",".","="};

        JButton[] all_btn = {and_btn, or_btn, clr_btn, del_btn,
                num7_btn, num8_btn, num9_btn, xor_btn,
                num4_btn, num5_btn, num6_btn, left_btn,
                num1_btn, num2_btn, num3_btn, right_btn,
                bitInversion_btn,num0_btn,dec_btn, equ_btn};

        JPanel btn_panel = new JPanel(new GridLayout(5,4));

        for (String button : buttons) {
            JButton jButton = new MyButton(button);
            if(jButton.getText().equals(".")){
                jButton.setEnabled(false);
            }
            if(jButton.getText().equals("del")){
                jButton.setForeground(Color.red);
            }
            if(jButton.getText().equals("AC")){
                jButton.setForeground(util.myYellowColor());
            }
            if(jButton.getText().equals("=")){
                jButton.setBackground(util.myGreenColor());
            }
            btn_panel.add(jButton);
            jButton.addActionListener(new MainController.BWController(this));
        }
        btn_panel.setPreferredSize(new Dimension(645, 450));

        return btn_panel;
    }

    private JPanel storageConverterTextField(MyJTextField first, MyJTextField second,
                                             MyJTextField third, MyJTextField fourth) {

        JPanel converter_panel = new JPanel(new FlowLayout());

        JPanel label_container = new JPanel(new GridLayout(4, 1, 0, 0));

        JLabel Byte = new JLabel("Byte");
        JLabel KB = new JLabel("Kilobyte");
        JLabel MB = new JLabel("Megabyte");
        JLabel TB = new JLabel("Terabyte");


        JLabel[] arr_label = {Byte, KB, MB, TB};

        for (JLabel label : arr_label) {
            label.setFont(util.myFontPrimary(18));
            label.setOpaque(true);
            label.setBackground(util.myBlackColor());
            label.setForeground(util.myGreenColor());
            label.setBorder(new LineBorder(util.myBlackColor()));
            label_container.add(label);
        }

        label_container.setPreferredSize(new Dimension(120,120));

        JPanel textField_container = new JPanel(new GridLayout(4,1,0,0));

        JTextField[] jTextFields = {first,second,third,fourth};

        for(JTextField jTextField : jTextFields){
            jTextField.setBorder(new LineBorder(util.myGreenColor()));
            jTextField.setHorizontalAlignment(SwingConstants.LEFT);
            jTextField.setText("168.168.2.168");
            textField_container.add(jTextField);

        }

        MyJTextField displayField = new MyJTextField();
        displayField.setPreferredSize(new Dimension(645,30));
        displayField.setBorder(new LineBorder(util.myYellowColor()));

        textField_container.setPreferredSize(new Dimension(480,120));

        converter_panel.setPreferredSize(new Dimension(645, 160));
        converter_panel.setBackground(util.myBlackColor());
        converter_panel.add(label_container);
        converter_panel.add(textField_container);
        converter_panel.add(displayField);

        return converter_panel;

    }

    public JPanel converterTextField(MyJTextField first, MyJTextField second,
                                     MyJTextField third, MyJTextField fourth,
                                     JLabel inp,MyJTextField displayField) {
        JPanel converter_panel = new JPanel(new GridBagLayout());
        JPanel label_container = new JPanel(new GridLayout(5, 1, 0, 0));
//        label_container.setBorder(new LineBorder(Color.red));

        JLabel bin = new JLabel("Binary");
        JLabel deci = new JLabel("Decimal");
        JLabel oct = new JLabel("Octal");
        JLabel hex = new JLabel("Hexadecimal");

        JLabel[] labels = {bin, deci, oct, hex};

        for (JLabel label : labels) {
            label.setFont(util.myFontPrimary(18));
            label.setOpaque(true);
            label.setBackground(util.myBlackColor());
            label.setForeground(util.myGreenColor());
//            label.setBorder(new LineBorder(util.myBlackColor()));
            label_container.add(label);
        }
        label_container.add(inp);

        label_container.setPreferredSize(new Dimension(120,120));
        JPanel textField_container = new JPanel(new GridLayout(5,1,0,0));
//        textField_container.setBorder(new LineBorder(Color.BLUE));
        inp.setText("Number Sys");
        inp.setPreferredSize(new Dimension(120,20));
        inp.setFont(util.myFontPrimary(20));
        inp.setOpaque(true);
        inp.setForeground(util.myYellowColor());
        inp.setBackground(util.myBlackColor());
        displayField.setPreferredSize(new Dimension(510,30));
        displayField.setFont(util.myFontPrimary(25));
//        displayField.setBorder(new LineBorder(util.myYellowColor()));
        displayField.setText("Please choose number base system");


        JTextField[] jTextFields = {first,second,third,fourth};

        for(JTextField jTextField : jTextFields){
            jTextField.setBorder(new LineBorder(util.myBlackColor()));
            jTextField.setHorizontalAlignment(SwingConstants.LEFT);
            textField_container.add(jTextField);

        }
        textField_container.add(displayField);

        textField_container.setPreferredSize(new Dimension(480,120));

        converter_panel.setPreferredSize(new Dimension(645, 165));
        converter_panel.setBackground(util.myBlackColor());
        converter_panel.add(label_container,gridConstant(0,0,0.2,0.5));
        converter_panel.add(textField_container,gridConstant(1,0,0.8,0.5));

        return converter_panel;
    }

    public JPanel standardPanel() {

        JPanel myPanel = new JPanel(new GridBagLayout());

        JPanel textPanel = standardTextField(descriptionField, displayField);
        JPanel btnPanel = btnPanel();

        myPanel.add(textPanel,gridConstant(0,0,1,0.33));
        myPanel.add(btnPanel,gridConstant(0,1,1,0.67));

        myPanel.setBackground(util.myThemeColor());
        myPanel.setFocusable(true);
        return myPanel;
    }
    public JPanel binaryArithmeticPanel() {

        JPanel myPanel = new JPanel(new GridBagLayout());
        myPanel.setBackground(util.myThemeColor());
        JPanel textField = standardTextField(descriptionField4BA, displayField4BA);
        JPanel myBtnPanel = btnPanel4BA();

        myPanel.add(textField,gridConstant(0,0,1,0.33));
        myPanel.add(myBtnPanel,gridConstant(0,1,1,0.67));

        return myPanel;
    }
    public JPanel numberSystemConverterPanel () {
        JPanel myPanel = new JPanel(new GridBagLayout());

        JPanel textField = converterTextField(binaryTextField,decimalTextField,octalTextField,
                                                hexadecimal,inp,displayField4NSC);
        JPanel myBtnPanel = btnPanel4NSC();
        myPanel.add(textField,gridConstant(0,0,1,0.4));
        myPanel.add(myBtnPanel,gridConstant(0,1,1,0.6));
        myPanel.setBackground(util.myThemeColor());

        return myPanel;
    }
    public JPanel trigonometryPanel () {
        JPanel myPanel = new JPanel(new GridBagLayout());

        JPanel textField = standardTextField(descriptionField4trio,displayField4Trio);
        JPanel myBtnPanel = btnPanel4Trio();

        myPanel.add(textField,gridConstant(0,0,1,0.33));
        myPanel.add(myBtnPanel,gridConstant(0,1,1,0.67));

        myPanel.setBackground(util.myThemeColor());
        return myPanel;
    }
    public JPanel bitwisePanel () {
        JPanel bitwise_panel = new JPanel(new GridBagLayout());

        JPanel textField = standardTextField(descriptionField4BW,displayField4BW);
        JPanel btnPanel = btnPanel4BW();

        bitwise_panel.add(textField,gridConstant(0,0,1,0.33));
        bitwise_panel.add(btnPanel,gridConstant(0,1,1,0.67));

        bitwise_panel.setBackground(util.myThemeColor());
        return bitwise_panel;
    }
    public JPanel storageConverterPanel () {
        JPanel storageConverter = new JPanel(new GridBagLayout());

        JPanel textField = storageConverterTextField(byteTextField,kilobyteTextField,
                                                megabyteTextField,gigabyteTextField);
        JPanel btnPanel = btnPanel4SC();

        storageConverter.add(textField,gridConstant(0,0,1,0.33));
        storageConverter.add(btnPanel,gridConstant(0,1,1,0.67));

        storageConverter.setBackground(util.myThemeColor());
        return storageConverter;
    }

}
