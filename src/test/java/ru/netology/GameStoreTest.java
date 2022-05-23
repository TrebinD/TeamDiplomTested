package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");
        Game game2 = store.publishGame("WarCraft", "Strategy");
        Game game3 = store.publishGame("MortalKombat", "action");

        assertTrue(store.containsGame(game3));
    }

    @Test
    public void shouldAddGameOneGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }


    @Test
    public void shouldNotGame() {

        GameStore store = new GameStore();

        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Game game2 = null;
        assertFalse(store.containsGame(game2));
    }

    @Test
    public void timeNotPlayer() {

        GameStore store = new GameStore();

        String expected = store.getMostPlayer();
        String actual = null;

        assertEquals(expected, actual);
    }

    @Test
    public void timeTwoPlayer() {

        GameStore store = new GameStore();

        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);

        String actual = store.getMostPlayer();
        String expected = "Gena";

        assertEquals(expected, actual);
    }

    @Test
    public void timeMorePlayer() {

        GameStore store = new GameStore();
        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);
        store.addPlayTime("Petia", 36);

        String actual = store.getMostPlayer();
        String expected = "Petia";

        assertEquals(expected, actual);
    }

    @Test
    public void timeMoreNotPlayer() {

        GameStore store = new GameStore();

        String actual = store.getMostPlayer();
        String expected = null;

        assertEquals(expected, actual);
    }

    @Test
    public void addPlayerTime() {

        GameStore store = new GameStore();

        store.addPlayTime("Vasia", 15);
        store.addPlayTime("Gena", 26);
        store.addPlayTime("Vasia", 12);

        String actual = store.getMostPlayer();
        String expected = "Vasia";

        assertEquals(expected, actual);
    }


    @Test
    public void allTimePlayed() {

        GameStore store = new GameStore();

        store.addPlayTime("Vasia", 2);
        store.addPlayTime("Gena", 3);
        store.addPlayTime("Petia", 8);

        int actual = store.getSumPlayedTime();
        int expected = 13;

        assertEquals(expected, actual);
    }


    // другие ваши тесты
}
