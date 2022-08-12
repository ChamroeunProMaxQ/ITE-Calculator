package Controller.Operation;

import java.util.ArrayList;
import java.util.Scanner;

public class SetTheory {

    private ArrayList<ArrayList<Integer>> ArrayOfSet;

    //this method will return more than 2 set from any operation method from any interface
    private ArrayList<ArrayList<Integer>> createSet(){

        Scanner scanner = new Scanner(System.in);

        //create 2 new arraylist
        ArrayList<ArrayList<Integer>> ArrayOfSet = new ArrayList<>();
        ArrayList<Integer> ArrayOfElement;

        System.out.print("input number of set : ");
        int NumOfSet = scanner.nextInt();

        //input index into each set
        int[] NumOfElement = new int[NumOfSet];

        //user input number of element of each set
        for(int i=0; i<NumOfElement.length;i++){
            System.out.print("Input number of element of set "+ i +": ");
            NumOfElement[i] = scanner.nextInt();
        }

        //loop to add every new Arraylist of Element
        for(int j=0;j<NumOfSet;j++){
            //declare new arraylist of ArrayOfElement in each time of loop
            ArrayOfElement = new ArrayList<>();
            for(int i=0; i<NumOfElement[j];i++){
                System.out.print("input index "+ i + " of set " + j + " : " );
                ArrayOfElement.add(i,scanner.nextInt());
            }
            ArrayOfSet.add(new ArrayList<>(ArrayOfElement));
        }

        return ArrayOfSet;
    }

    //set union inner class
    private static class SetUnion implements UnionHelper {

        @Override
        public ArrayList<Integer> UnionOperation(ArrayList<ArrayList<Integer>> ArrayOfSet) {

            ArrayList<Integer> ResultOfUnion = new ArrayList<>();

            //loop all size of Array of set
            for(int i=0; i<ArrayOfSet.size();i++){
                //loop for size of the first ArrayLis
                for(int j=0;j<ArrayOfSet.get(i).size();j++){
                    if(i==0){
                        // give all the element from first list of elements except the duplicate elements
                        for(int k=0; k<ArrayOfSet.get(i).size();k++){
                            if(!ResultOfUnion.contains(ArrayOfSet.get(i).get(j))){
                                ResultOfUnion.add(ArrayOfSet.get(i).get(j));
                            }
                        }
                    } else {
                        //compare and give more element from every list except duplicate elements
                        if(!ResultOfUnion.contains(ArrayOfSet.get(i).get(j))){
                            ResultOfUnion.add(ArrayOfSet.get(i).get(j));
                        }
                    } //close condition

                } //close inner loop
            } //close main loop

            return ResultOfUnion;
        }

        //display
        @Override
        public void display(ArrayList<Integer> UnionResult) {

            System.out.println("Union Result : "+UnionResult);

        } //close method
    }

    //// method will do all process from union interface
    public void union(){

        System.out.println("Union......");

        //Create object and call all method in class
        SetUnion setUnion = new SetUnion();

        this.ArrayOfSet = createSet();

        ArrayList<Integer> UnionResult = setUnion.UnionOperation(ArrayOfSet);

        setUnion.display(UnionResult);

    }

    // method will do all process from intersection interface
    public void intersection(){

        System.out.println("Intersection......");

        //local class implement logic later
        class SetIntersection implements IntersectionHelper {

            @Override
            public ArrayList<Integer> intersectionOperation(ArrayList<ArrayList<Integer>> ArrayOfSet) {

                ArrayList<Integer> IntersectionResult = new ArrayList<>();

                //loop from all element in array of set
                for(int i=0; i<ArrayOfSet.size();i++){


                    if(i!=0){
                        //loop to get element from array of element
                        for(int j=0;j<ArrayOfSet.get(i).size();j++){

                            //if array of set contain it item of any element in other set
                            /*
                            if size of intersection equal zero or intersection did not
                            container that item that is true to add in. or item that did
                            not contain in set yet.
                            */
                            if(ArrayOfSet.get(i-1).contains(ArrayOfSet.get(i).get(j))){
                                if(IntersectionResult.size()==0
                                        || !IntersectionResult.contains(ArrayOfSet.get(i).get(j))
                                        || !ArrayOfSet.get(i).contains(ArrayOfSet.get(i).get(j))) {

                                    IntersectionResult.add(ArrayOfSet.get(i).get(j));
                                }

                            }

                        }
                    }
                } // close main loop

                return IntersectionResult;
            }  //close method

            @Override
            public void display(ArrayList<Integer> IntersectionResult) {
                System.out.println("Intersection Result : " + IntersectionResult);
            }
        } //close local class

        //Create object and call all method in class
        SetIntersection setIntersection = new SetIntersection();
        ArrayOfSet  = createSet();
        ArrayList<Integer> IntersectionResult = setIntersection.intersectionOperation(ArrayOfSet);
        setIntersection.display(IntersectionResult);

    }

    // method will do all process from SetDifferent interface
    public void setDiff(){

        //msg to user
        System.out.println("#######_NOTE ______");
        System.out.println("This program will get only the first pair of your input " +
                "set to calculate the Set different ");
        System.out.println("I recommend you to input 2 set only !!!!!!");

        SetDifferentHelper setDifferent = new SetDifferentHelper() {

            @Override
            public ArrayList<Integer> setDifferent(ArrayList<ArrayList<Integer>> ArrayOfSet) {

                //Different work with 2 set A - B = C
                //get only element which contain in A,
                // but not in B
                ArrayList<Integer> DifferentResult = new ArrayList<>();

                    //remove which elements also exit in B
                    for(int j=0;j<ArrayOfSet.get(1).size();j++) {
                        ArrayOfSet.get(0).remove(ArrayOfSet.get(1).get(j));
                    }

                    //remove duplicate element in A
                    for(int integer=0;integer<ArrayOfSet.get(0).size();integer++){
                        if(!DifferentResult.contains(ArrayOfSet.get(0).get(integer))){
                            DifferentResult.add(ArrayOfSet.get(0).get(integer));
                        }
                    }

                return DifferentResult;
            }

            @Override
            public void display(ArrayList<Integer> DifferentResult){

                System.out.println("Set different: "+DifferentResult);
            }

        };

        //Create object and call all method in class
        ArrayList<ArrayList<Integer>> ArrayOfSet = createSet();
        ArrayList <Integer> DifferentResult =  setDifferent.setDifferent(ArrayOfSet);
        setDifferent.display(DifferentResult);

    } //close class


} //close setTheory class
