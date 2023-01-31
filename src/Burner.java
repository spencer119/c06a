public class Burner {
    public static final int TIME_DURATION = 2;

    private Temperature myTemperature;
    private Setting mySetting;
    private int timer;

    public Burner() {
        myTemperature = Temperature.COLD;
        mySetting = Setting.OFF;
    }

    public Temperature getTemperature() {
        return myTemperature;
    }

    public void plusButton() {
        if (mySetting == Setting.HIGH) return;
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
            default:
                break;
        }
        timer = TIME_DURATION;
    }

    public void minusButton() {
        if (mySetting == Setting.OFF) return;
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
                return;
            default:
                break;
        }
        timer = TIME_DURATION;
    }

    public void updateTemperature() {
        if (timer == 0) {
            switch (myTemperature) {
                case COLD:
                    if (mySetting != Setting.OFF) {
                        myTemperature = Temperature.WARM;
                        timer = TIME_DURATION;
                    }
                    break;
                case WARM:
                    if (mySetting == Setting.LOW) break;
                    if (mySetting == Setting.HIGH) {
                        myTemperature = Temperature.HOT;
                        timer = TIME_DURATION;
                    } else if (mySetting == Setting.OFF) {
                        myTemperature = Temperature.COLD;
                        timer = TIME_DURATION;
                    }
                    break;
                case HOT:
                    if (mySetting == Setting.MEDIUM) break;
                    if (mySetting == Setting.HIGH) {
                        myTemperature = Temperature.BLAZING;
                        timer = TIME_DURATION;
                    } else {
                        myTemperature = Temperature.WARM;
                        timer = TIME_DURATION;
                    }
                    break;
                case BLAZING:
                    if (mySetting != Setting.HIGH) {
                        myTemperature = Temperature.HOT;
                        timer = TIME_DURATION;
                    }
                    break;
                default:
                    break;
            }
        } else timer = timer - 1;
    }

    public void display() {
        System.out.println(mySetting.toString());
        // System.out.println(myTemperature);
    }

    public enum Temperature {BLAZING, HOT, WARM, COLD}
}
