package Controller.Operation;

public class MoneyExchange {

    /***
     * Method used to exchange Riel to USD
     * @param riel value of Riel you want to exchange
     * @return result USD with currency rate 4050R/1USD
     */
    float riel2dollar(float riel){
        return riel / 4050;
    }

    /***
     * Method used to exchange Riel to Euro
     * @param riel value of Riel
     * @return result of Euro with currency rate 6000R/1Euro
     */
    float riel2Euro(float riel){
        return  riel/6000;
    }

    /***
     * Method used to exchange Riel to Franc
     * @param riel value of Riel
     * @return result of Swiss Franc with currency rate 4500R/1Fr
     */
    float riel2Franc (float riel){
        return riel/4500;
    }

    /***
     * Method used to exchange Riel to baht
     * @param riel value of Riel
     * @return result of Baht with currency rate 100R/1B
     */
    float riel2Baht (float riel){

        return riel/100;
    }

    /***
     * Method use to exchange Dollar to Riel
     * @param dollar value of dollar
     * @return result of riel with currency rate 4050R/1USD
     */
    float dollar2Riel(float dollar){

        return dollar*4050;
    }

    /***
     * Method use to exchange Euro to Riel
     * @param euro value of euro
     * @return result of riel with currency rate 6000R/1Euro
     */
    float euro2Riel(float euro){

        return euro*6000;
    }

    /***
     * Method used to exchange Baht to Riel
     * @param baht value of Baht
     * @return result of riel with currency rate 100r/1Baht
     */
    float baht2Riel(float baht){

        return baht*100;
    }

    /***
     * Method used to exchange Swiss Franc to Riel
     * @param franc value of franc
     * @return result of riel with currency rate 4500r/1franc
     */
    float franc2Riel(float franc){
        return franc*4500;
    }

}
