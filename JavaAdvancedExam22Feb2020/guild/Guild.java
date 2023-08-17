package guild;

import java.util.ArrayList;
import java.util.List;

public class Guild {
    public List<Player> roster;
    public String name;
    public int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(p -> p.getName().equals(name));
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Member")) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name) && !player.getRank().equals("Trial")) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] players = roster.stream().filter(player -> player.getClazz().equals(clazz)).toArray(Player[]::new);
        roster.removeAll(List.of(players));
        return players;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Players in the guild: %s:", name));
        roster.forEach(p -> sb.append(System.lineSeparator()).append(p.toString()));
        return sb.toString();
    }
}
