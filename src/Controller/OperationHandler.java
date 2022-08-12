package Controller;

import Controller.Operation.Arithmetic;
import Controller.Operation.Trigonometry;
import java.util.ArrayList;

public class OperationHandler {

    Arithmetic arithmetic = new Arithmetic();
    Trigonometry tro = new Trigonometry();
    private String pre_sign = "...";
    private String pre_first = "0";


    //main method to calculate
    public String operationHandler(String input) {

        System.out.println(input);

        class handler {

            /***
             * method use to check if it is a sign
             * @param input String of what you want to check
             * @return true if it is a sign
             */
            boolean isContainSign(String input) {
                return input.contains("+") || input.contains("-") || input.contains("*")
                        || input.contains("/") || input.contains("%");
            }

            /***
             * overloading method
             * @param input String of what you want to check
             * @return true if it is a sign
             */
            boolean isContainSign(char input) {
                return input == '+' || input == '-'
                        || input == '*'
                        || input == '/'
                        || input == '%';
            }

            /***
             * count the sign exit in the string
             * @param input String what you want to check
             * @return return number of sign
             */
            int countSign (String input) {
                int count = 0;
                for(int i=0 ; i < input.length(); i++) {
                    if(i==0 && input.startsWith("-")){
                        continue;
                    }
                    if(isContainSign(input.charAt(i))){
                        count ++;
                    }
                }
                return count;
            }

            /***
             *
             * @param input String of what you want to calculate
             * @return ArrayList of array list store index of location
             */
            public ArrayList<ArrayList<Integer>> locateNUm (String input) {

                ArrayList<Integer> contain_sub_num = new ArrayList<>();
                ArrayList<ArrayList<Integer>> contain_all = new ArrayList<>();

                for(int i=0; i<input.length(); i++) {

                    if(i==0&&String.valueOf(input.charAt(0)).equals("-")){
                        contain_sub_num.add(i);
                        continue;
                    }
                    if(!isContainSign(input.charAt(i))){
                        contain_sub_num.add(i);
                    } else {
                        contain_all.add(contain_sub_num); // give arr of previous number index first
                        contain_sub_num = new ArrayList<>(); // create small new object

                        contain_sub_num.add(i); // add index of sign to arr
                        contain_all.add(contain_sub_num); // add to big arr
                        contain_sub_num = new ArrayList<>(); // new small arr
                    }

                    if(i == input.length()-1){
                        contain_all.add(contain_sub_num);
                    }
                }
//        System.out.println(contain_all);
                return contain_all;
            }

            /***
             * method used to do the first priority of calculation
             * @param sign String current sign you want to calculate
             * @param pre_sign previous sing
             * @param first_num String of first number to calculate
             * @param second_num String of second number to calculate
             * @return calculated result
             */
            public String priorityOpHandler (String sign, String pre_sign, String first_num, String second_num) {
                String temp;
                if(pre_sign.equals("+")){
//                    System.out.println("1 f"+first_num);
                    first_num = arithmetic.subtraction(first_num,pre_first); // change first number to original

                    if(sign.equals("*")){ // if multiple
                        temp = arithmetic.multiple(first_num,second_num); // temporary multiple result

                    } else {
                        temp = arithmetic.division(first_num,second_num);
                    }

                    return arithmetic.sum(temp,pre_first); //return original result

                } else if (pre_sign.equals("-")) {
                    first_num = arithmetic.subtraction(pre_first,first_num);
                    if(sign.equals("*")){
                        temp = arithmetic.multiple(first_num,second_num);
                    } else {
                        temp = arithmetic.division(first_num,second_num);
                    }
                    return arithmetic.subtraction(pre_first,temp);

                } else {
                    if(sign.equals("*")){
                        return arithmetic.multiple(first_num,second_num);
                    } else {
                        return arithmetic.division(first_num,second_num);
                    }
                }
            }
        } //close class

        //local class object
        handler handler = new handler();

        //get array list from local class method
        ArrayList<ArrayList<Integer>> arr = handler.locateNUm(input);
        String first_num;
        String second_num;
        String result = "..";
        String sign = String.valueOf(input.charAt(arr.get(1).get(0)));

        // logic
        if (handler.isContainSign(input) && handler.countSign(input) != 1) {

            if(arr.get(0).size() == 1) {
                first_num = input.substring(0,1);
            } else {
                first_num = input.substring(0,arr.get(0).size());
            }

            if(arr.get(2).size() == 1) {
                second_num = String.valueOf(input.charAt(arr.get(2).get(0)));

            } else {
                second_num = input.substring(arr.get(2).get(0),arr.get(2).get(arr.get(2).size()-1)+1);
                if(second_num.contains("√")){
                    String temp = second_num.substring(2,second_num.length()-1);
                    second_num = tro.sqrt2(temp);
                }
                if(second_num.startsWith("(")){
                    String temp = input.substring(input.indexOf("(")+1,input.indexOf(")"));
                    String replacement = input.substring(input.indexOf("("),input.indexOf(")")+1);
                    second_num = operationHandler(temp);
                    return operationHandler(input.replace(replacement,second_num));
                }

            }
            String pre_string = input.substring(arr.get(3).get(0));

            switch (sign) {

                case "+","%" -> {
                    result = arithmetic.sum(first_num,second_num);
                    pre_first = first_num;
                    pre_sign = "+";

                }
                case "-" -> {
                    result = arithmetic.subtraction(first_num,second_num);
                    pre_first = first_num;
                    pre_sign = "-";
                }
                case "*","/" -> result = handler.priorityOpHandler(sign,pre_sign,first_num,second_num);
            }
            input = result.concat(pre_string);

            return  operationHandler(input);
        } else
            if (handler.countSign(input) == 1){
                if(input.startsWith("-")){
                    first_num = input.substring(0,input.lastIndexOf(sign));
                } else {
                    first_num = input.substring(0,input.indexOf(sign));
                }

            second_num = input.substring(input.lastIndexOf(sign)+1);

            if(second_num.contains("√")){
                String temp = second_num.substring(2,second_num.length()-1);
                second_num = tro.sqrt2(temp);
//                System.out.println(second_num);
            }
            switch (sign) {
                case "+" -> {
                    return arithmetic.sum(first_num,second_num);
                }
                case "-" -> {
                    return arithmetic.subtraction(first_num,second_num);
                }
                case "*","/" -> {
                    return handler.priorityOpHandler(sign,pre_sign,first_num,second_num);
                }
                case "%" -> {
                    return arithmetic.modulation(first_num,second_num);
                }
            }

        } return input;

    }

}

