package Controller.Operation;

import java.util.ArrayList;

public interface IntersectionHelper {

    //this method need parameters from method createSet from SetTheory class
    ArrayList<Integer> intersectionOperation(ArrayList<ArrayList<Integer>> ArrayOfSet);

    //method which has parameter that is the result of operation
    void display(ArrayList<Integer> Result);

}
