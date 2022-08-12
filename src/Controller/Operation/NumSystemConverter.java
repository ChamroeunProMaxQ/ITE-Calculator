package Controller.Operation;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class NumSystemConverter {

     public String binary2Octal(String binary) {

        //initialize value which is the input is not enough to form binary in to octal
        String add_00 = "00";
        String add_0 = "0";
        String newBinary;

        //condition to check how many value of zero to add at first
        if(binary.length()%3 == 1){
            newBinary = add_00.concat(binary);
        } else if(binary.length()%3 == 2){
            newBinary = add_0.concat(binary);
        } else {
            newBinary = binary;
        }

        //initialize string and length for using in loop
        int length2 = newBinary.length() / 3;
        String[] Arr = new String[length2];
        StringBuilder result = new StringBuilder();

        //first loop to add char of 3 index each
        for (int j = 0; j < length2; j++) {

            int counter=0; //the counter which reset every second loop was executed.
            Arr[j] = ""; //initialize an empty string of every j index

            //loop all the value to one time 3 index tha main array
            for (int k = j * 3; k < newBinary.length(); k++) {

                counter++; //increase counter
                Arr[j] += newBinary.charAt(k); //add char to array (3 char each)

                //break condition
                if(counter==3){
                    break;
                } //close condition

            } //close second loop

            // add every individual converted char to result
            result.append(octal_binary_to_octal(Arr[j]));
        }

        return String.valueOf(result);
    }


    static char octal_binary_to_octal (String octal){

        char converted_octal = 'n';

        switch (octal){
            case "001" -> converted_octal = '1';
            case "010" -> converted_octal = '2';
            case "011" -> converted_octal = '3';
            case "100" -> converted_octal = '4';
            case "101" -> converted_octal = '5';
            case "110" -> converted_octal = '6';
            case "111" -> converted_octal = '7';
            case "000" -> converted_octal = '0';

        }
        return converted_octal;
    }

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //binary to decimal

    /***
     * Method to convert binary to decimal
     * @param binary value of binary
     * @return value of decimal in array
     */
     public String binary2Decimal(String binary){

        long[] Arr = new long[binary.length()];

        long result=0;

        for(int i = 0; i<binary.length(); i++){

            Arr[i] =(long) (Math.pow(2,binary.length()-(i+1)) * binary_Char2Int(binary.charAt(i)));

            result += Arr[i];
        }

        return String.valueOf(result);
    } //end method

    static int binary_Char2Int(char binary){

        if(binary == '0') {
            return 0;
        } else return 1;

    }


    //============================================================
    //binary to hexadecimal

    public String binary2Hex(String binary){

        String newBinary ;

        String Add_000 = "000";
        String Add_00 = "00";
        String Add_0 = "0";
        StringBuilder result = new StringBuilder();

        if ((binary.length()%4)==1){
            newBinary = Add_000.concat(binary);
        } else if((binary.length()%4)==2){
            newBinary = Add_00.concat(binary);
        }else if((binary.length()%4)==3){
            newBinary = Add_0.concat(binary);
        } else {
            newBinary = binary;
        }

        int length = newBinary.length() / 4;
        String[] Arr = new String[length];

        //first loop to add char of 3 index each
        for (int j = 0; j < length; j++) {

            int counter=0; //the counter which reset every second loop was executed.
            Arr[j] = ""; //initialize an empty string of every j index

            //loop all the value to one time 3 index tha main array
            for (int k = j * 4; k < newBinary.length(); k++) {

                counter++; //increase counter
                Arr[j] += newBinary.charAt(k); //add char to array (3 char each)

                //break condition
                if(counter==4){
                    break;
                } //close condition

            } //close second loop

            // add every individual converted char to result
            result.append(hex_binary_to_hex(Arr[j]));
        }

        return String.valueOf(result);
    }


    char  hex_binary_to_hex(String binary){

        char hex= 'n';

        switch (binary){
            case "0000" -> hex = '0';
            case "0001" -> hex = '1';
            case "0010" -> hex = '2';
            case "0011" -> hex = '3';
            case "0100" -> hex = '4';
            case "0101" -> hex = '5';
            case "0110" -> hex = '6';
            case "0111" -> hex = '7';
            case "1000" -> hex = '8';
            case "1001" -> hex = '9';
            case "1010" -> hex = 'A';
            case "1011" -> hex = 'B';
            case "1100" -> hex = 'C';
            case "1101" -> hex = 'D';
            case "1110" -> hex = 'E';
            case "1111" -> hex = 'F';
        }
        return hex;
    }


    //=======================================================
    //octal

    /***
     * Method use to convert from octal to binary
     * @param octal value of octal
     * @return result of decimal
     */
    public String octal2decimal(String octal){

        String result;
        String binary = octal2binary(octal);
        result = binary2Decimal(binary);

        return result;

    }//close method

    /***
     * Method use to convert octal to binary
     * @param octal value of octal
     * @return binary value
     */
    public String octal2binary(String octal){

        StringBuilder result = new StringBuilder();

        for(int i=0; i<octal.length();i++){
            result.append(converter_by_switch_octal2binary(octal.charAt(i)));
        }

        return String.valueOf(result);
    } //close method

    public String converter_by_switch_octal2binary(char octal_each){

        String Binary = "";

        switch (octal_each){
            case '1' -> Binary = "001";
            case '2' -> Binary = "010";
            case '3' -> Binary = "011";
            case '4' -> Binary = "100";
            case '5' -> Binary = "101";
            case '6' -> Binary = "110";
            case '7' -> Binary = "111";
            case '0' -> Binary = "000";
        }

        return Binary;
    }


    /***
     * Method use to convert from octal to hexadecimal
     * @param octal value of octal
     */
    public String octal2Hex(String octal){

        String result;
        result = binary2Hex(octal2binary(octal));

      return result;
    }

    //=============================================
    //decimal

    /***
     * Method use to convert from decimal to binary
     * @param decimal value of decimal
     * @return binary value
     */
    public String decimal2Binary(String decimal){

//        long decimals = Long.parseLong(decimal);
//
//        int[] result = new int[32];
//
//        for(int i=31;decimals>0;i--){
//            result[i] += (decimals%2);
//            decimals /= 2;
//        }

//
//        String string_result = new BinaryArithmetic().ArrayToString(result);
//        int idx = string_result.indexOf("1");
//
//
//        return string_result.substring(idx);
        BigInteger new_decimal = new BigInteger(decimal);



        return new_decimal.toString(2);
    }


    /***
     * Method use to convert from decimal to octal
     * @param decimal value of decimal
     * @return value of octal
     */
    public String decimal2Octal(String decimal){

        String result;

        String binary = decimal2Binary(decimal);

        result = binary2Octal(binary);

        return result;

    }

    /***
     * Method use to convert from decimal to hexadecimal
     * @param decimal value of hexadecimal
     */
    public String decimal2hex(String decimal){

       String binary = decimal2Binary(decimal);

       return binary2Hex(binary);
    }

    //==============================================================================
    //hexadecimal to binary

    /***
     * Method use to convert from hexadecimal to binary
     * @param hex value of hex
     * @return value of binary
     */
    public String hex2Binary (String hex){

        //declare new array of string to get value from hex to binary each character
        String[] hex_one_digit = new String[hex.length()];

        //use to string builder to concat to string
        StringBuilder temp_binary = new StringBuilder();

        //loop to convert from hex to binary
        for(int i=0;i<hex.length();i++){
          hex_one_digit[i] = hex_switch_2_binary(hex.charAt(i));
          temp_binary.append(hex_one_digit[i]);

        }

        //return string value of binary
        return String.valueOf(temp_binary);
    }

    /***
     * Method use to change from each char to binary
     * @param hex_char value of hex each char
     * @return binary of each char
     */
    public String hex_switch_2_binary (char hex_char) {

        String newHex = null;
        switch (hex_char) {
            case '0' -> newHex = "0000";
            case '1' -> newHex = "0001";
            case '2' -> newHex = "0010";
            case '3' -> newHex = "0011";
            case '4' -> newHex = "0100";
            case '5' -> newHex = "0101";
            case '6' -> newHex = "0110";
            case '7' -> newHex = "0111";
            case '8' -> newHex = "1000";
            case '9' -> newHex = "1001";
            case 'A' -> newHex = "1010";
            case 'B' -> newHex = "1011";
            case 'C' -> newHex = "1100";
            case 'D' -> newHex = "1101";
            case 'E' -> newHex = "1110";
            case 'F' -> newHex = "1111";
        }  //close switch

        return newHex;
    } //close method


    //==================================================================================
    //hexadecimal to decimal


    /***
     * Method use to convert from hexadecimal to decimal
     * @param hex value of hexadecimal
     * @return value of decimal
     */
    public String hex2Decimal(String hex){

        String result;
        result = binary2Decimal(hex2Binary(hex));

        return result;
    }

    //===================================================================
    //hex2Octal

    /***
     * Method use to convert from char to long
     * @param hex value of hexadecimal
     * @return value of octal
     */
    public String hex2Octal (String hex){

        String result;
        result = binary2Octal(hex2Binary(hex));

        return result;

    } //close method


    //===================================================================
    //the help method

    /***
     * to if user input valid binary or not
     * @param binary binary value (string)
     * @return true or false
     */
    boolean isValidBinary(String binary){
        boolean check = false;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '1' || binary.charAt(i) =='0'){
                check = true;
            }
            else {
                check = false;
                break;
            }
        }
        return check;
    }

    /***
     * to if user input valid octal or not
     * @param octal octal value (string)
     * @return true or false
     */
    boolean isValidOctal(String octal){
        boolean check = false;
        for(int i=0; i<octal.length(); i++){
            switch (octal.charAt(i)){
                case '1','2','3','4','5','6','7','0' -> check = true;
                default -> check = false;

            }
        }

        return check;
    }

    /***
     * to if user input valid octal or not
     * @param decimal decimal value (string)
     * @return true or false
     */
    boolean isValidDecimal(String decimal){
        boolean check = false;
        for(int i=0; i<decimal.length(); i++){
            switch (decimal.charAt(i)){
                case '1','2','3','4','5','6','7','8','9','0' -> check = true;
                default -> check = false;

            }
        }
        return check;
    }

    /***
     * to if user input valid hexadecimal or not
     * @param hex hexadecimal value (string)
     * @return true or false
     */
    boolean isValidHex(String hex){
        boolean check = false;
        for(int i=0; i<hex.length(); i++){
            switch (hex.charAt(i)){
                case '1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F' -> check = true;
                default -> check = false;

            }
        }
        return check;
    }



} //close class
