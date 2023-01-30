public enum Setting {
    OFF ("---"), LOW ("--+"), MEDIUM ("-++"), HIGH ("+++");
    private String level;
    Setting(String level) {
        this.level = level;
    }

    public String toString() {
        return level;
    }
}
