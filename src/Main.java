import Controller.MainController;
import Model.MyModel;
import View.MyView;

public class Main {

    public static void main(String[] args) {

        //Call Object
        MyModel myModel = new MyModel();
        MyView mainView = new MyView();

        new MainController(mainView,myModel); //controller object
    }
}
