package Controller;

public class ValidationController {


    public String checkOpSign (String text) {
        if(text.contains("+")){
            return  "+";
        }
        if(text.contains("-")){
            return  "-";
        }
        if (text.contains("*")){
            return  "*";
        }
        if(text.contains("/")){
            return  "/";
        }
        if(text.contains("%")){
            return "%";
        }
        return "";
    }

    public int countChar (String text,char sign){
        int counter = 0 ;
        for(int i = 0; i<text.length();i++){
            if((text.charAt(i) == sign)){
                counter++;
            }
        }
        return counter;
    }

    /***
     * method use to check if the operation sign is already contained
     * @param text String of text
     * @return true if operation sign is already contained
     */
    public boolean isContainOp (String text) {

        if(text.contains("+")){
            return true;
        } else if(text.contains("-")){
            return true;
        } else if(text.contains("*")){
            return true;
        } else if(text.contains("/")){
            return true;
        } else return text.contains("%");
    }

    /***
     * check if the key is valid to number to input
     * @param key char of key to verify
     * @return true if key is in valid list
     */
    public boolean isValidKeyNum (char key) {
        switch (key) {
            case '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' -> {
                return true;
            }
        }

        return false;
    }

    public boolean isValidKeyOp (char key) {
        switch (key) {
            case '+','-','*','/','%' -> {
                return true;
            }
        }
        return false;
    }

}
