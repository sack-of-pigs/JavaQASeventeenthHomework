import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    // Класс для тестирования, можно без него, если players будет public
    Map<String, Player> getPlayers() {
        return players;
    }


    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        // Проверка, найдены ли оба игрока
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Один или оба игрока не зарегистрированы");
        }

        // Сравнение strength
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
