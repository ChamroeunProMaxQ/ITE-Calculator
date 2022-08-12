package Controller.Operation;

import java.util.Arrays;
import java.util.Objects;

public class BinaryArithmetic extends NumSystemConverter {

    private String BinaryA;
    private String BinaryB;
    private String decimalA;
    private String decimalB;
    private String remainder;


    public String getBinaryA() {
        return BinaryA;
    }

    public String getBinaryB() {
        return BinaryB;
    }

    public String getDecimalA() {
        return decimalA;
    }

    public String getDecimalB() {
        return decimalB;
    }

    public String getRemainder(){
        return remainder;
    }



    //convert any binary to 32 digit
    private int[] binaryTo32bits(String Str_binary){

        int length = 32;
        int[] binary = new int[length];

        if(Str_binary.length()==32){
            binary[0] = Str_binary.charAt(0);
            for(int i=1; i<length; i++){
                 binary[i] = binary_Char2Int(Str_binary.charAt(i));
            }
        }


        for(int i=length-1; i>=(length-Str_binary.length());i--){
            binary[i] = binary_Char2Int(Str_binary.charAt(i-(length-Str_binary.length())));
        }

        return binary;
    } //close method

    int[] binary2Array (String  Str_binary){

        int[] ArrBinary = new int[Str_binary.length()];

        for(int i = 0; i < Str_binary.length(); i++){
            ArrBinary[i] = binary_Char2Int(Str_binary.charAt(i));
        }

        return ArrBinary;
    }

     String convertFrom32bits(String Str_Binary){

        Complement complement = new Complement();

        String convertedBinary;

        if(Str_Binary.charAt(0)=='1'){

            convertedBinary = complement.findSecondComplement(Str_Binary);

        } else {
            convertedBinary = Str_Binary;
        }

        int[] Arr_binary = binaryTo32bits(convertedBinary);

        long result = 0;

        for(int i = Arr_binary.length -1; i > 0; i--) {
            result += Arr_binary[i] * Math.pow(2,Arr_binary.length - (i+1));
        }

        if(Str_Binary.charAt(0)=='1'){

            long mainResult = (result) * (-1);

            return String.valueOf(mainResult);

        } else

            return String.valueOf(result);

    } //close method


    /***
     * method use to convert from 32 bits array to string back
     * @param Arr array of binary numbers
     * @return String of binary
     */
     String ArrayToString(int[] Arr){

        StringBuilder main_String = new StringBuilder();
        for (int j : Arr) {
            main_String.append(j);
        }

         return String.valueOf(main_String);
    }

    /***
     * method use to convert decimal for suitable in second's complement method
     * @param decimal value of decimal
     * @return String of binary
     */
    String convertForArithmetic (String decimal){

        Complement complement = new Complement();

        String newDecimal;
        String binary;
        String Str_binary;

        if(decimal.charAt(0)=='-'){
            newDecimal = decimal.substring(1);
            binary = decimal2Binary(newDecimal);
            Str_binary = complement.findSecondComplement(binary);

        } else {
            binary = decimal2Binary(decimal);
            Str_binary = ArrayToString(binaryTo32bits(binary));
        }

        return Str_binary;
    }


    /***
     * Method use to sum two binary numbers
     * @param Str_BinaryA String of first Binary
     * @param Str_BinaryB String of second Binary
     * @return value of result sum binary
     */
    public String binary_Add(String Str_BinaryA, String Str_BinaryB){

        int[] BinaryA;
        int[] BinaryB;

        int length = 32;
        int[] reminder= new int[length];
        int[] result = new int[length];

        //pass array of string to be integer value
        BinaryA = binaryTo32bits(Str_BinaryA);
        BinaryB = binaryTo32bits(Str_BinaryB);
        System.out.println(Arrays.toString(BinaryA));
        System.out.println(Arrays.toString(BinaryB));

        for (int i = length - 1; i >= 0; i--) {

            if (BinaryA[i] + BinaryB[i] == 0) {
                result[i] = 0;
                reminder[i] = 0;
            } else if (BinaryA[i] + BinaryB[i] == 1) {
                result[i] = 1;
                reminder[i] = 0;
                System.out.println("re : "+result[i]);

            } else if (BinaryA[i] + BinaryB[i] == 2) {
                result[i] = 0;
                reminder[i] = 1;
            } else {
                result[i] = 1;
                reminder[i] = 1;
            } //close condition

            if (i != 0) {
                BinaryA[i - 1] += reminder[i];
            } else {
                BinaryA[i] += reminder[i];

            } //close condition
        }//close loop

       return ArrayToString(result);
    }

    //=========================================================
    //Binary Addition operation

    /***
     * Method use to minus two binary numbers
     * @param Str_BinaryA String of first binary
     * @param Str_BinaryB String of second binary
     * @return value of result minus binary
     */
    public String binary_Sub (String Str_BinaryA, String Str_BinaryB){

        int[] BinaryA;
        int[] BinaryB;

        //pass array of string to be integer value
        BinaryA = binaryTo32bits(Str_BinaryA);
        BinaryB = binaryTo32bits(Str_BinaryB);

        int length = 32;
        int[] result = new int[length];

        //do calculation on both array
        for(int i= length-1; i>=0; i--) {
            if(BinaryA[i]-BinaryB[i]<0){
                BinaryA[i] += 2;
                BinaryA[i-1] -= 1;
            }

            result[i] = BinaryA[i]-BinaryB[i];

        } //close loop

        return ArrayToString(result);
    }

    /***
     * method use to multiple binary number
     * @param binaryA String of binaryA
     * @param binaryB String of binaryB
     * @return result of binary multiplication
     */
    public String binary_mul (String binaryA, String binaryB){

        int length = binaryA.length()+binaryB.length()-1;
        int lengthB = binaryB.length();
        String Str_result = "";
        int[] Temp = new int[length];
        String[] Str_temp = new String[binaryB.length()];

        int[] ArrBinaryA = binary2Array(binaryA);


        //variable to count space of zero before add to temp
        int front_zero = lengthB - 1;

        for(int i = 0; i < lengthB ;i++ ){
            if(binaryB.charAt(i) == '1'){
                int j = 0;
                while (j < binaryA.length()) {
                    Temp[j+front_zero] = ArrBinaryA[j];
                    j++;
                }
            } else {
                for(int k = 0 ; k < binaryA.length(); k++){
                    Temp [k] = 0;
                }
            }
            front_zero --;

            Str_temp[i] = ArrayToString(Temp);
            Str_result = binary_Add(Str_result, Str_temp[i]);
            for(int k = 0 ; k < length; k++){
                Temp[k] = 0;
            }

        }

        return Str_result;
    }


    public String binary_div (String binaryA, String binaryB){

        String decimalA = binary2Decimal(binaryA);
        String decimalB = binary2Decimal(binaryB);

        long decimalA_int = Long.parseLong(decimalA);
        long decimalB_int = Long.parseLong(decimalB);

        long result = decimalA_int/decimalB_int;
        long remainder = decimalA_int%decimalB_int;

        String Str_result = String.valueOf(result);
        String Str_remainder = String.valueOf(remainder);

        this.remainder = String.valueOf(decimal2Binary(Str_remainder));

        return decimal2Binary(Str_result);
    }




    //======================================================================
    //2's complement arithmetic

    /***
     * Method use to do addition of 2's complement binary
     * @param binaryA String of binary A
     * @param binaryB String of binary B
     * @return String of result
     */
    String addWithSecondComplement(String binaryA, String binaryB){

        Complement complement = new Complement();
        String Str_binaryA;
        String Str_binaryB;
        String result;
        long decimalA;
        long decimalB;

        if(binaryA.length() == 32 || binaryA.charAt(0) == '1'){
            Str_binaryA = ArrayToString(binaryTo32bits(binaryA));
        } else {
            Str_binaryA = complement.findSecondComplement(binaryA);
        }

        if(binaryB.length() == 32 || binaryB.charAt(0) == '1'){
            Str_binaryB = ArrayToString(binaryTo32bits(binaryB));
        } else {
            Str_binaryB = complement.findSecondComplement(binaryB);
        }

        this.BinaryA = Str_binaryA;
        this.BinaryB = Str_binaryB;


        String Str_decimalA = convertFrom32bits(binaryA);
        String Str_decimalB = convertFrom32bits(Str_binaryB);
        if (Str_decimalA.charAt(0) == '-'){
            String Temp_Str = Str_decimalA.replace(Str_decimalA.charAt(0), '0');
            decimalA = Long.parseLong(Temp_Str);
        } else {
            decimalA = Long.parseLong(Str_decimalA);
        }
        if (Str_decimalB.charAt(0) == '-'){
            String Temp_Str = Str_decimalB.replace(Str_decimalA.charAt(0), '0');
            decimalB = Long.parseLong(Temp_Str);
        } else {
            decimalB = Long.parseLong(Str_decimalB);
        }

        this.decimalA = convertFrom32bits(ArrayToString(binaryTo32bits(binaryA)));
        this.decimalB = convertFrom32bits(ArrayToString(binaryTo32bits(binaryB)));


        if(binaryA.length() == 32 && binaryB.length() == 32){

               result = binary_Add(Str_binaryA,Str_binaryB);

        } else if(binaryB.length() != 32 && binaryA.charAt(0) == '1' && binaryA.length() == 32){

            if(decimalB>decimalA){

                result =  binary_Sub(Str_binaryB,Str_binaryA);
            } else {

                result =  binary_Sub(Str_binaryA,Str_binaryB);
                return complement.findSecondComplement(result);
            }
        } else if(binaryA.length() !=32 && binaryB.charAt(0) == '1' && binaryB.length() == 32){

            result = binary_Sub(Str_binaryA,Str_binaryB);
        } else if (binaryA.length() != 32 && binaryB.length() != 32) {

            result = binary_Add(Str_binaryA,Str_binaryB);

        }  else {
            result = binary_Add(Str_binaryA,Str_binaryB);
        }


        if(decimalA+decimalB > 2147483647){
            result = "Overflow";
        }

        return result;
    }

    /***
     * Method use to do subtraction of 2's complement binary
     * @param binaryA String of binary
     * @param binaryB String of binary
     * @return String of binary
     */

    String subWithSecondComplement(String binaryA, String binaryB){

        Complement complement = new Complement();

        String Str_binaryA;
        String Str_binaryB;

        Str_binaryA = ArrayToString(binaryTo32bits(binaryA));
        Str_binaryB = complement.findSecondComplement(binaryB);


        this.decimalA = convertFrom32bits(ArrayToString(binaryTo32bits(binaryB)));
        this.decimalB = convertFrom32bits(ArrayToString(binaryTo32bits(binaryB)));
        this.BinaryA = Str_binaryA;
        this.BinaryB = Str_binaryB;

        return addWithSecondComplement(Str_binaryA, Str_binaryB);
    }



    //==++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //inner class

    public class Complement {

        /***
         * method use to 1's component
         * @param binary sting of binary number
         * @return result of 1's component
         */
        String findFirstComplement (String binary){

            StringBuilder result = new StringBuilder();

            int[] Arr_Binary = binaryTo32bits(binary);
            String newBinary = ArrayToString(Arr_Binary);

            for(int i=0; i<newBinary.length(); i++){

                if(newBinary.charAt(i)=='0'){
                    result.append('1');
                } else result.append('0');
            } // close loop

            return String.valueOf(result);
        } // close method


        /***
         * Method use to do 2's complement
         * @param binary String of binary
         * @return String of 2's complement
         */
        String findSecondComplement(String binary){

            String firstCom  = findFirstComplement(binary);

            return BinaryArithmetic.this.binary_Add(firstCom,"1");
        }

    } //close inner class

} // close outer class
