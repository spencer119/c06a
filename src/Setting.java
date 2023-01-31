public enum Setting {
    OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
    private final String level;

    Setting(String level) {
        this.level = level;
    }

    public String toString() {
        String str = "[" + level + "].....";
        switch (this) {
            case OFF:
                str += "coooool";
                break;
            case LOW:
                str += "warm";
                break;
            case MEDIUM:
                str += "CAREFUL";
                break;
            case HIGH:
                str += "VERY HOT! DONT'T TOUCH";
                break;
            default:
                break;
        }
        return str;
    }

}
