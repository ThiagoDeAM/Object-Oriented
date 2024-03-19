package Teams;

public class Player {
    private String name;
    private int number;
    private String position;
    private boolean isFielded;
    private boolean isCaptain;

    public Player(String name, int number, String position, boolean isFielded){
        this.name = name;
        this.number = number;
        this.position = position;
        this.isFielded = isFielded;
    }

    public String getName() {
        return name;
    }

    public boolean getIsFielded() {
        return isFielded;
    }

    public void setIsFielded(boolean isFielded) {
        this.isFielded = isFielded;
    }

    public void setCaptain(boolean captain) {
        isCaptain = captain;
    }

    public String getStateAsString(){
        return "Player{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", position='" + position + '\'' +
                ", isFielded=" + isFielded +
                ", isCaptain=" + isCaptain +
                '}';
    }
}
