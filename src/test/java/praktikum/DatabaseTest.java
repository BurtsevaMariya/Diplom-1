package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    Database database = new Database();
    int expectedBansSize = 3;

    @Test
    public void accessibleBuns(){
        assertEquals("Неправильные булочки", expectedBansSize, database.availableBuns().size());
    }
}
