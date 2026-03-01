import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players = new ArrayList<>();

    // Класс для тестирования, можно без него, если players будет public
    List<Player> getPlayers() {
        return players;
    }


    public void register(Player player) {
        players.add(player);
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = null;
        Player player2 = null;

        // Поиск игроков по имени
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

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
