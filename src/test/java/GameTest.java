import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game = new Game();
    private Player player1 = new Player(1, "Alice", 80);
    private Player player2 = new Player(2, "Bob", 90);
    private Player player3 = new Player(3, "Charlie", 80);

    @Test
    void testRegister() {
        game.register(player1);

        List<Player> players = new ArrayList<>();
        players.add(player1);

        assertEquals(players,game.getPlayers());
    }

    @Test
    void testRoundFirstPlayerStronger() throws NotRegisteredException {
        game.register(player2); // Bob (90)
        game.register(player1); // Alice (80)

        int result = game.round("Bob", "Alice");
        assertEquals(1, result);
    }

    @Test
    void testRoundSecondPlayerStronger() throws NotRegisteredException {
        game.register(player1); // Alice (80)
        game.register(player2); // Bob (90)

        int result = game.round("Alice", "Bob");
        assertEquals(2, result);
    }

    @Test
    void testRoundEqualStrength() throws NotRegisteredException {
        game.register(player1); // Alice (80)
        game.register(player3); // Charlie (80)

        int result = game.round("Alice", "Charlie");
        assertEquals(0, result);
    }

    @Test
    void testRoundFirstPlayerNotRegistered() {
        game.register(player2);

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
    }

    @Test
    void testRoundSecondPlayerNotRegistered() {
        game.register(player1);

        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Charlie")
        );
    }

    @Test
    void testRoundBothPlayersNotRegistered() {
        assertThrows(
                NotRegisteredException.class,
                () -> game.round("Alice", "Bob")
        );
    }
}
