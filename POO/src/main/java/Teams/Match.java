package Teams;

public class Match {
    public static void main(String[] args) {
        Team team = new Team("Palmeiras", "Brasil", "Abel Ferreira");

        Player p1 = new Player("Messi", 10, "Meia", true);
        Player p2 = new Player("Neymar", 11, "Atacante", true);
        Player p3 = new Player("Mbappé", 7, "Atacante", false);
        Player p4 = new Player("Ronaldo", 9, "Atacante", true);
        Player p5 = new Player("Modric", 8, "Meio-campo", false);

        team.addPlayer(p1);
        team.addPlayer(p2);
        team.addPlayer(p3);
        team.addPlayer(p4);
        team.addPlayer(p5);

        System.out.println("Lista de Jogadores em campo: ");
        for(Player player : team.getFieldedPlayers()){
            System.out.println(player.getStateAsString());
        }

        System.out.println("Lista de jogadores fora de campo: ");
        for(Player player : team.getOutfieldedPlayers()){
            System.out.println(player.getStateAsString());
        }

        team.removePlayer(p2);

        team.substitute(p3, p4);

        System.out.println("Lista de Jogadores em campo: ");
        for(Player player : team.getFieldedPlayers()){
            System.out.println(player.getStateAsString());
        }
        System.out.println("Lista de jogadores fora de campo: ");
        for(Player player : team.getOutfieldedPlayers()){
            System.out.println(player.getStateAsString());
        }
        team.setCaptain(p1);

    }
}
