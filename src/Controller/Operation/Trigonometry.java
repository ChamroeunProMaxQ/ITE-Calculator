package Controller.Operation;

import javax.net.ssl.SSLContext;
import java.math.BigDecimal;
import java.math.MathContext;

public class Trigonometry {

    /***
     * Method used to find value of sin(rad)
     * @param radian value of radian
     * @return result of sin(rad)
     */
    public String sin( String radian){

        double _rad = Double.parseDouble(radian);

        return String.valueOf(Math.sin(_rad));
    }

    /***
     * Method used to find value of cos(rad)
     * @param radian value of radian
     * @return result of cos(rad)
     */
    public String cos(String radian){
        double rad_double = Double.parseDouble(radian);
        return String.valueOf(Math.cos(rad_double));
    }

    /***
     * Method used to find value of sin(degree)
     * @param degree value of degree
     * @return result of sin(deg)
     */
    public float sind(int degree){
        float goRadian = (float) Math.toRadians(degree);
        return (float) Math.sin(goRadian);
    }

    /***
     * Method used to find value of cos(deg)
     * @param degree value of degree
     * @return result of cod(deg)
     */
    public float cosd(float degree){
        float goRadian = (float) Math.toRadians(degree);
        return (float) Math.cos(goRadian);
    }

    /***
     * Method used to find tan(rad)
     * @param radian value of radian
     * @return result of tan(rad)
     */
    public String tan(String radian){

        double tan_string = Double.parseDouble(radian);

        return String.valueOf(Math.tan(tan_string));
    }

    /***
     * Method used to fine tan(deg)
     * @param degree value of degree
     * @return result of tan(deg)
     */
    float tand(float degree){
        float goRadian = (float) Math.toRadians(degree);
        return (float) Math.tan(goRadian);
    }

    /***
     * Method used to find square root
     * @param x value
     * @return result of pow2
     */
    public String pow2(String x){
        BigDecimal _x = new BigDecimal(x);
        return String.valueOf(_x.multiply(_x,MathContext.DECIMAL32));
    }

    /***
     * Method used to find cube root
     * @param x value
     * @return result x^3
     */
    public String sqrt3(String x){
        double _x = Double.parseDouble(x);
        return String.valueOf(Math.pow(_x,1.0/3.0));
    }

    /***
     * Method used to find square root of floating-point
     * @param x value
     * @return result of sqrt2
     */
    public String sqrt2(String x){
        BigDecimal _x = new BigDecimal(x);
        return String.valueOf(_x.sqrt(MathContext.DECIMAL32));
    }

    /***
     * Method used to find cube root of floating-point
     * @param x value
     * @return result of x^3
     */
    public String pow3(String x){
        BigDecimal _x = new BigDecimal(x);
        return String.valueOf(_x.pow(3));
    }

    /***
     * Method used to convert from degree to radian
     * @param degree value of degree
     * @return result value of radian
     */
    public String degree2Radian(String degree){
        return String.valueOf(Math.toRadians(Double.parseDouble(degree)));
    }

}
