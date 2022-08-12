package Controller;

import Controller.Operation.BinaryArithmetic;
import Controller.Operation.NumSystemConverter;
import Controller.Operation.Trigonometry;
import Model.MyModel;
import View.Component.MyButton;
import View.Component.MyPanel;
import View.MyView;
import View.Utility.MyUtility;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainController {

    //instance object
    private static MyView mainView;
    private static MyModel mainModel;


    /***
     * Controller Class
     * @param mainView view object
     * @param mainModel Model object
     */
    public MainController(MyView mainView, MyModel mainModel) {
        MainController.mainView = mainView;
        MainController.mainModel = mainModel;
    }

    public static class NSCController implements ActionListener {

        private final MyPanel view;
        NumSystemConverter converterObj = new NumSystemConverter();

        public NSCController(MyPanel view) {

            this.view = view;

        }

        private void clearText() {
            view.getBinaryTextField().setText("");
            view.getDecimalTextField().setText("");
            view.getOctalTextField().setText("");
            view.getHexadecimal().setText("");
            view.getDisplayField4NSC().setText("");
            mainModel.setBaseNumber("");
        }

        private void converter(String binary) {

            view.getBinaryTextField().setText(binary);
            view.getDecimalTextField().setText(converterObj.binary2Decimal(binary));
            view.getOctalTextField().setText(converterObj.binary2Octal(binary));
            view.getHexadecimal().setText(converterObj.binary2Hex(binary));

        }

        private String toBinary (String number){
            String default_inp = view.getInp().getText();
            switch (default_inp) {
                case  "Decimal" -> {
                    return converterObj.decimal2Binary(number);
                }
                case "Octal" -> {
                    return converterObj.octal2binary(number);
                }
                default -> {
                    return number;
                }
            }
        }

        private void changeInp(String source) {

            UIManager.put("Button.disabledText", new MyUtility().myThemeColor() );
            MyButton[] all_button = view.getAllBtn();
            for (MyButton button : all_button) {
                button.setEnabled(true);
            }
            switch (source) {
                case "Bin" -> {
                    view.getInp().setText("Binary");
                    mainModel.setBaseNumber("");
                    MyButton[] buttons = view.getBtnDisable4Bin();
                    for (MyButton button : buttons) {
                        button.setEnabled(false);
                    }
                }

                case "Dec" -> {
                    view.getInp().setText("Decimal");
                    mainModel.setBaseNumber("");
                    MyButton[] buttons = view.getBtnDisable4Dec();
                    for (MyButton button : buttons) {
                        button.setEnabled(false);
                    }
                }
                case "Oct" -> {


                    view.getInp().setText("Octal");
                    MyButton[] buttons = view.getBtnDisable4Dec();
                    for (MyButton button : buttons) {
                        button.setEnabled(false);
                    }
                    for (MyButton button : all_button) {
                        if (button.getText().equals("8") || button.getText().equals("9")) {
                            button.setEnabled(false);
                            button.repaint();
                        }
                    }

                }
                case "Hex" -> view.getInp().setText("Hexadecimal");

            }

            clearText();
        }

        private void displayHandler(String source) {
            String display = view.getDisplayField4NSC().getText();
            switch (source) {
                case "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" ->
                        view.getDisplayField4NSC().setText(display.concat(source));

            }
            if (view.getInp().getText().equals("Binary")) {
                mainModel.setBaseNumber(mainModel.getBaseNumber().concat(source));
            } else if (view.getInp().getText().equals("Decimal")){
                String binary = converterObj.decimal2Binary(view.getDisplayField4NSC().getText());
                mainModel.setBaseNumber(binary);
            } else if (view.getInp().getText().equals("Octal")) {
                String binary = converterObj.octal2binary(view.getDisplayField4NSC().getText());
                mainModel.setBaseNumber(binary);
            } else {
                String binary = converterObj.hex2Binary(view.getDisplayField4NSC().getText());
                mainModel.setBaseNumber(binary);
            }
        }


        @Override
        public void actionPerformed(ActionEvent e) {

            String source = e.getActionCommand();
            System.out.println(source);

            switch (source) {
                case "Bin", "Dec", "Oct", "Hex" -> changeInp(source);
                case "del" -> {
                    String display = view.getDisplayField4NSC().getText();
                    if(!display.isEmpty()&&!view.getDisplayField4NSC().getText().endsWith("em")){
                        view.getDisplayField4NSC().setText(display.substring(0,display.length()-1));
                        mainModel.setBaseNumber(toBinary(view.getDisplayField4NSC().getText()));
                        converter(mainModel.getBaseNumber());
                    }

                }
                case "AC" -> {
                    if(!view.getDisplayField4NSC().getText().endsWith("em")){
                        clearText();
                    }

                }
                default -> {
                    displayHandler(source);
                    converter(mainModel.getBaseNumber());

                }

            }
        }
    }
    public static class TriController implements ActionListener{

        MyPanel view;

        public TriController (MyPanel view) {
            this.view = view;
        }

        private void resultHandler (String source) {
            Trigonometry tri = new Trigonometry();

            if(view.getDisplayField4Trio().getText().isEmpty()){
                if(source.equals("√")||source.equals("∛")||source.equals("π")) {
                    view.getDescriptionField4trio().setText("  "+source.concat("("));
                } else
                view.getDescriptionField4trio().setText(source.concat("("));
            } else {
                switch (source) {
                    case "sin" -> {
                        view.getDescriptionField4trio().setText("sin(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.sin(mainModel.getTriNumber()));
                    }
                    case "cos" -> {
                        view.getDescriptionField4trio().setText("cos(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.cos(mainModel.getTriNumber()));
                    }
                    case "tan" -> {
                        view.getDescriptionField4trio().setText("tan(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.tan(mainModel.getTriNumber()));
                    }
                    case "x^2" -> {
                        view.getDescriptionField4trio().setText("x^2(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.pow2(mainModel.getTriNumber()));
                    }
                    case "x^3" -> {
                        view.getDescriptionField4trio().setText("x^3(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.pow3(mainModel.getTriNumber()));
                    }
                    case "√" -> {
                        view.getDescriptionField4trio().setText("  √(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.sqrt2(mainModel.getTriNumber()));
                    }
                    case "∛" -> {
                        view.getDescriptionField4trio().setText("  ∛(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.sqrt3(mainModel.getTriNumber()));
                    }
                    case "deg" -> {
                        view.getDescriptionField4trio().setText("deg(".concat(mainModel.getTriNumber()));
                        view.getDisplayField4Trio().setText(tri.degree2Radian(mainModel.getTriNumber()).concat("rad"));
                    }
                }
            }

        }

        /***
         * check if the key is valid to number to input
         * @param key char of key to verify
         * @return true if key is in valid list
         */
        public boolean isValidKeyNum (char key) {
            switch (key) {
                case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                    return true;
                }
            }

            return false;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            ValidationController valid = new ValidationController();
            if(view.getDescriptionField4trio().getText().length() > 4){
                view.getDisplayField4Trio().setText("");
                view.getDescriptionField4trio().setText("");
                mainModel.setTriNumber("");
            }

            String source = e.getActionCommand();
            String display = view.getDisplayField4Trio().getText();
            switch (source) {
                case "1","2","3","4","5","6","7","8","9","0" -> {
                    if(view.getDisplayField4Trio().getText().isEmpty()
                            || isValidKeyNum(view.getDisplayField4Trio().getText().charAt(0)) ) {
                        mainModel.setTriNumber(mainModel.getTriNumber().concat(source));
                        view.getDisplayField4Trio().setText(mainModel.getTriNumber());
                    }
                }
                case "." -> {
                    if(view.getDisplayField4Trio().getText().isEmpty()) {
                        mainModel.setTriNumber(mainModel.getTriNumber().concat("0."));
                    } else if (!view.getDisplayField4Trio().getText().contains(".")){
                        mainModel.setTriNumber(mainModel.getTriNumber().concat(source));
                    }
                    view.getDisplayField4Trio().setText(mainModel.getTriNumber());
                }
                case "del" -> {

                    if(!view.getDisplayField4Trio().getText().isEmpty()) {
                        view.getDisplayField4Trio().setText(display.substring(0,display.length()-1));
                        mainModel.setTriNumber(view.getDisplayField4Trio().getText());
                    }

                }
                case "AC" -> {
                    view.getDisplayField4Trio().setText("");
                    view.getDescriptionField4trio().setText("");
                    mainModel.setTriNumber("");
                }
                case "=" -> {
                    resultHandler(view.getDescriptionField4trio().getText().substring(0,3));
                }
                default -> resultHandler(source);

            }

            System.out.println(source);
        }
    }
    public static class BAController implements ActionListener {

        BinaryArithmetic binaryArithmetic = new BinaryArithmetic();

        private final MyPanel view;

        public BAController (MyPanel view) {
            this.view = view;
        }

        private void operationHandler (String source) {
            if(view.getDescriptionField4BA().getText().isEmpty()){
                view.getDescriptionField4BA().setText(view.getDisplayField4BA().getText().concat(source));
                view.getDisplayField4BA().setText("");
            }
        }

        private void resultHandler () {
            String text = view.getDescriptionField4BA().getText().substring(0,view.getDescriptionField4BA().getText().length()-1);
            String text2 = view.getDisplayField4BA().getText();
            String sign = view.getDescriptionField4BA().getText().substring(view.getDescriptionField4BA().getText().length()-1);
            String result = "";

            switch (sign) {

                case "+" -> {
                    result = binaryArithmetic.binary_Add(text,text2);

                }
                case "-" -> {
                    result = binaryArithmetic.binary_Sub(text,text2);
                }
                case "*" -> {
                    result = binaryArithmetic.binary_mul(text,text2);
                }
                case "/" -> {
                    result = binaryArithmetic.binary_div(text,text2);
                }

            }
            view.getDisplayField4BA().setText("="+result.substring(result.indexOf("1")));

        }


        @Override
        public void actionPerformed(ActionEvent e) {

            view.getDisplayField4BA().setFont(new Font(Font.DIALOG,Font.PLAIN,35));
            String source = e.getActionCommand();

            switch (source) {
                case "0","1" -> {
                    view.getDisplayField4BA().setText(view.getDisplayField4BA().getText().concat(source));
                }
                case "del" -> {
                    view.getDisplayField4BA().setText(view.getDisplayField4BA().getText().substring(
                            0,view.getDisplayField4BA().getText().length()-1));
                }
                case "AC" -> {
                    view.getDescriptionField4BA().setText("");
                    view.getDisplayField4BA().setText("");
                }
                case "+", "-","*","/" -> {
                    operationHandler(source);
                }
                case "=" -> {
                    resultHandler();
                    view.getDescriptionField4BA().setText("");
                }
            }
        }
    }
    public static class BWController implements ActionListener {

        MyPanel view;

        public BWController(MyPanel view) {
            this.view = view;
        }

        private void operationConcat(String sign){
            mainModel.setBWNumber(view.getDisplayField4BW().getText());
            view.getDisplayField4BW().setText("");
            switch (sign) {
                case "AND" -> {
                    view.getDescriptionField4BW().setText(mainModel.getBWNumber().concat(" &"));
                }
                case "OR" -> {
                    view.getDescriptionField4BW().setText(mainModel.getBWNumber().concat(" |"));
                }
                case "XOR" -> {
                    view.getDescriptionField4BW().setText(mainModel.getBWNumber().concat(" ^"));
                }
                case "L-shift" -> {

                }
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String source = e.getActionCommand();
            switch (source) {
                case "1","2","3","4","5","6","7","8","9","0" -> {
                    view.getDisplayField4BW().setText(view.getDisplayField4BW().getText().concat(source));
                }
                case "del" -> {
                    view.getDisplayField4BW().setText(view.getDisplayField4BW().getText().substring(0,view.getDisplayField4BW().getText().length()-1));
                }
                case "AC" -> {
                    view.getDisplayField4BW().setText("");
                    view.getDescriptionField4BW().setText("");
                }
                default -> operationConcat(source);
            }
        }
    }

    /***
     * Action controller class
     */
    public static class StandardController implements ActionListener {

            //declare object
            static MyPanel view;
            ValidationController valid = new ValidationController();
            static String key_source;
            static int key_code;
            //constructor
            public StandardController(MyPanel view) {
                StandardController.view = view;
            }

        public static KeyListener keyListen(MyView WindowView) {

            return new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    super.keyReleased(e);
                    key_source = String.valueOf(e.getKeyChar());
                    key_code = e.getKeyCode();
                    switch (key_code){
                        case 10 ->  key_source = "=";
                        case 8 -> key_source = "del";
                        case 46 -> key_source = ".";
                    }
                    performAction(key_source);
                }
            };
        }

            private static void operationConcat(String display, String description, String sign) {

                if (display.isBlank()) {
                    mainModel.setDescription(mainModel.getDescription().concat("0".concat(sign)));
                } else if (description.endsWith("..") || description.isBlank()) {
                    mainModel.setDescription(mainModel.getDescription().concat(display.concat(sign)));

                } else if (description.endsWith(")") || description.endsWith("=")) {
                    mainModel.setDescription(mainModel.getDescription().concat(sign));
                }

                view.getDescriptionField().setText(mainModel.getDescription().concat("..."));

            }
        private static void performAction (String source) {

            String display = view.getDisplayField().getText();

            switch (source) {
                case "1", "2", "3", "4", "5", "6", "7", "8", "9", "0","π","(",")" -> {
                    if (view.getDescriptionField().getText().endsWith("...")) {
                        view.getDisplayField().setText("");
                        view.getDescriptionField().setText(mainModel.getDescription().concat(".."));
                        view.getDisplayField().setText(source);
                    } else {
                        view.getDisplayField().setText(view.getDisplayField().getText().concat(source));
                    }
                }
                case "AC" -> {
                    view.getDisplayField().setText("");
                    view.getDescriptionField().setText("");
                    mainModel.setDescription("");
                }
                case "del" -> {
                    if (!display.isEmpty()) {
                        view.getDisplayField().setText(display.substring(0, display.length() - 1));
                    }
                }
                case "." -> {
                    if (!display.contains(".")) {
                        view.getDisplayField().setText(display.concat("."));
                    }
                    if (display.isEmpty()) {
                        view.getDisplayField().setText("0.");
                    }
                }

                case "+", "-", "*", "/", "%" -> {
                    operationConcat(display, view.getDescriptionField().getText(), source);

                }
                case "√" -> {
                    mainModel.setResult(new Trigonometry().sqrt2(display));
                    if (view.getDescriptionField().getText().endsWith("=")) {
                        view.getDescriptionField().setText("√(".concat(mainModel.getDescription()).concat(")"));
                        view.getDisplayField().setText(mainModel.getResult());
                    } else {
                        mainModel.setDescription(mainModel.getDescription().concat("√(" + display + ")"));
                        view.getDisplayField().setText(mainModel.getResult());
                        view.getDescriptionField().setText(mainModel.getDescription());
                    }
                }

                case "=" -> {
                    try {
                        if (mainModel.getDescription().endsWith(")")) {
                            mainModel.setDescription(mainModel.getDescription());
                        } else {
                            mainModel.setDescription(mainModel.getDescription().concat(display));
                        }
                        OperationHandler handler = new OperationHandler();
                        view.getDescriptionField().setText(mainModel.getDescription().concat("="));
                        if(mainModel.getDescription().contains("π")){
                            mainModel.setDescription(mainModel.getDescription().replace("π",String.valueOf(Math.PI)));
                        }
                        String input = "0+".concat(mainModel.getDescription());
                        String result = handler.operationHandler(input);
                        view.getDisplayField().setText(result);
                    } catch (ArithmeticException msg) {
                        view.getDescriptionField().setText("Divided By zero!!");
                    }
                    catch (NumberFormatException msg) {
                        view.getDescriptionField().setText("Wrong Format!!");
                    }
                    catch (Exception msg){
                        view.getDescriptionField().setText("Error!!");
                    }
                }

            }

        }

            @Override
            public void actionPerformed(ActionEvent e) {

                String source = e.getActionCommand();

                performAction(source);

            }

        }
    public static class Route implements ActionListener {

        JMenuBar menuBar;
        public Route(JMenuBar mainWindowView) {
                this.menuBar = mainWindowView;
            }

        @Override
        public void actionPerformed(ActionEvent e) {

                String source = e.getActionCommand();

                CardLayout card = (CardLayout) mainView.getCardPanel().getLayout();

                card.show(mainView.getCardPanel(),source);

                if(source.equals("Exit")){
                    System.exit(0);
                }
        }
    }

}
