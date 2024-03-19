package Teams;

public class Team {
    private String name;
    private String baseLocation;
    private String coachName;
    private Player[] players = new Player[18];
    private int numberOfPlayers = 0;

    public Team(String name, String baseLocation, String coachName){
        this.name = name;
        this.baseLocation = baseLocation;
        this.coachName = coachName;
    }
    public void addPlayer(Player player){
        if(numberOfPlayers < players.length)
            players[numberOfPlayers++] = player;
    }
    public void removePlayer(Player player){
        for (int i = 0; i < numberOfPlayers; i++) {
            if(players[i] == player){
                for (int j = i; j < numberOfPlayers - 1; j++) {
                    players[j] = players[j+1];
                }
                players[numberOfPlayers-1] = null;
                numberOfPlayers--;
                break;
            }
        }
    }
    public void substitute(Player substitute, Player starter){
        if (substitute == null) {
            System.out.println("O jogador substituto não pode ser nulo.");
            return;
        }

        if (substitute.getIsFielded()) {
            System.out.println("O jogador substituto já está em campo.");
            return;
        }

        boolean starterFoundAndSubstituted = false;
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] == starter && starter.getIsFielded()) {
                players[i] = substitute;
                starter.setIsFielded(false);
                substitute.setIsFielded(true);
                starterFoundAndSubstituted = true;
                System.out.println("Substituição realizada: " + starter.getName() + " por " + substitute.getName());
                break;
            }
        }
        if (!starterFoundAndSubstituted) {
            System.out.println("O jogador inicial não está em campo ou não pertence à equipe.");
        }
    }

    public void setCaptain(Player player){
        for (Player p : players) {
            if(p != null)
                p.setCaptain(false);
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            if (players[i] == player){
                players[i].setCaptain(true);
                System.out.println(players[i].getName() + " é o capitão da equipe.");
                break;
            }
        }
    }
    public Player[] getFieldedPlayers(){
        return getPlayersByFieldStatus(true);
    }
    public Player[] getOutfieldedPlayers(){
        return getPlayersByFieldStatus(false);
    }

    private Player[] getPlayersByFieldStatus(boolean isFielded){
        Player[] result = new Player[numberOfPlayers];
        int count = 0;
        for (int i = 0; i < numberOfPlayers; i++) {
            if(players[i].getIsFielded() == isFielded){
                result[count] = players[i];
                count++;
            }
        }
        Player[] finalResult = new Player[count];
        for (int i = 0; i < count; i++) {
            finalResult[i] = result[i];
        }
        return finalResult;
    }
}
