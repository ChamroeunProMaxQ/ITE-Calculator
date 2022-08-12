package Model;

public class MyModel {

    private String result;
    private String description = "";
    private String baseNumber = "";
    private String triNumber = "";
    private String BWNumber = "";

    public String getBWNumber() {
        return BWNumber;
    }

    public void setBWNumber(String BWNumber) {
        this.BWNumber = BWNumber;
    }

    public String getTriNumber() {
        return triNumber;
    }

    public void setTriNumber(String triNumber) {
        this.triNumber = triNumber;
    }

    public String getBaseNumber() {
        return baseNumber;
    }

    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }


}
