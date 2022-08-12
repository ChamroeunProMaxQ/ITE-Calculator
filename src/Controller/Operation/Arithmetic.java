package Controller.Operation;

import java.math.BigDecimal;
import java.math.MathContext;

public class Arithmetic {


    /***
     * Method used to sum of two numbers
     * @param a first value to sum
     * @param b second value to sum
     * @return the result of sum
     */
    public String sum(String a, String b){
        BigDecimal _a = new BigDecimal(a);
        BigDecimal _b = new BigDecimal(b);

        return String.valueOf(_a.add(_b));
    }

    /***
     * Method used to divide of two numbers
     * @param a first value
     * @param b second value
     * @return the result of divide
     */
    public String division(String a, String b){
        BigDecimal _a = new BigDecimal(a);
        BigDecimal _b = new BigDecimal(b);

        return String.valueOf(_a.divide(_b,MathContext.DECIMAL64));
    }

    /***
     * Method used to minus of two numbers
     * @param a first value
     * @param b second value
     * @return the result of minus
     */
    public String subtraction(String a, String b){

        System.out.println(a);

        BigDecimal _a = new BigDecimal(a);
        BigDecimal _b = new BigDecimal(b);
        return String.valueOf(_a.subtract(_b));
    }

    /***
     * Method use to multiply of two numbers
     * @param a first value
     * @param b second value
     * @return the result of multiply
     */
    public String multiple(String a, String b){

        BigDecimal _a = new BigDecimal(a);
        BigDecimal _b = new BigDecimal(b);

        return String.valueOf(_a.multiply(_b,MathContext.DECIMAL64));
    }


    /***
     * Method used to modulo of two numbers
     * @param a first value
     * @param b second value
     * @return the result of modulo
     */
    public String modulation (String a, String b){
        Long a_ = Long.parseLong(a);
        Long b_ = Long.parseLong(b);

        return String.valueOf(a_ % b_);
    }



} //end class
