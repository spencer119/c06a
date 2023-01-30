public class Burner {
    public enum Temperature {BLAZING, HOT, WARM, COLD};
    private Temperature myTemperature;
    private Setting mySetting;
    private int timer;
    public static final int TIME_DURATION = 2;
    public Temperature getTemperature() {
        return myTemperature;
    }
    public Burner() {
        myTemperature = Temperature.COLD;
        mySetting = Setting.OFF;
    }
    public void plusButton() {
    switch (mySetting) {
        case OFF:
            mySetting = Setting.LOW;
            break;
        case LOW:
            mySetting = Setting.MEDIUM;
            break;
        case MEDIUM:
            mySetting = Setting.HIGH;
            break;
        case HIGH:
        default:
            break;
        }
    }
    public void minusButton() {
    switch (mySetting) {
        case LOW:
            mySetting = Setting.OFF;
            break;
        case MEDIUM:
            mySetting = Setting.LOW;
            break;
        case HIGH:
            mySetting = Setting.MEDIUM;
            break;
        case OFF:
        default:
            break;
        }
    }
    public void updateTemperature() {
    }
    public void display() {

    }
}
