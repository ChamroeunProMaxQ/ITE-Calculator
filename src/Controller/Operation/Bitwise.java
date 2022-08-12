package Controller.Operation;

public class Bitwise {

    /***
     * Method use to bitwise AND of two numbers
     * @param a first value
     * @param b second value
     * @return result of bitwise AND
     */
    int AND(int a, int b){
        return a&b;
    }

    /***
     * Method used to bitwise OR of two numbers
     * @param a first value
     * @param b second value
     * @return result of bitwise OR
     */
    int OR(int a, int b){
        return a|b;
    }

    /***
     * Method used to bitwise XOR of two numbers
     * @param a first value
     * @param b second value
     * @return result of bitwise XOR
     */
    int XOR(int a, int b){
        return a^b;
    }

    /***
     * Method used to bitwise left shift of two numbers
     * @param a first value
     * @param b second value
     * @return result of bitwise left shift
     */
    int leftShift(int a, int b){
        return a<<b;
    }

    /***
     * Method used to bitwise right shift of two numbers
     * @param a first value
     * @param b first value
     * @return result of bitwise right shift
     */
    int rightShift(int a, int b){
        return a>>b;
    }

    /***
     * Method used to do bits inversion of a number
     * @param a what value you want to bits inversion
     * @return the result of bits inversion
     */
    int bitInversion(int a) {
        int i = 0;
        int temp = 0;
        int[] A = new int[100];

        //convert to binary
        while (a > 0) {
            A[i] = a % 2;
            //System.out.println(A[i]);
            a /= 2;
            i++;
        } //close while

        //binary bitwise
        for (int j = 0; j < i; j++) {
            if (A[i - 1] == 0) {
               break;
            } else if (A[j] == 1) {
                A[j] = 0;
                // System.out.println("A[temp] = "+A[j]);
            } else {
                A[j] = 1;
                //  System.out.println("A[temp] = "+A[j]);}
                temp++;

            }
        } //close for loop
           // System.out.println("temp = " + temp);
            int newTemp;
            int remove = 0;
            for (int j = temp; j > 0; j--) {
                if (A[j] == 0) {
                    remove++;
                } else break;
            } //close loop

            newTemp = temp - remove + 1;
            int[] B = new int[newTemp];

            int counter = 1;
            //back decimal
            for (int j = 0; j < newTemp; j++) {
                B[j] = A[j] * (int) Math.pow(2, counter - 1);
                counter++;
            }

            //sum result
            int result = 0;
            for (int j = 0; j < newTemp; j++) {
                result += B[j];
                //System.out.println(result);

            } //close loop

            return result;
        }//close method

    } //close class

