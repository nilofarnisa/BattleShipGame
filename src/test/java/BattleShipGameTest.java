import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BattleShipGameTest {
    @Test
    void shouldReturnMISSIfTheShipIsNotHit() {
        BattleShipGame battleShipGame = new BattleShipGame();

        String shootResult = battleShipGame.shootShip(0, 0);

        assertEquals("MISS",shootResult);
    }
}
