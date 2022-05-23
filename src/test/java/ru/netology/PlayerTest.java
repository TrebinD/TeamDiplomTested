package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PlayerTest {

    GameStore store = new GameStore();

    Player player = new Player("Vitia");
    Player player2 = new Player("Petya");

    Game game = store.publishGame("Нетология Баттл Онлайн", "Action");
    Game game1 = store.publishGame("SWAT", "Action");
    Game game2 = store.publishGame("Sims", "Strategy");


    @Test
    public void addTimeGameNotInstalled() {

        assertThrows(NotInstalledGame.class, () -> {
            player.play(game, 22);
        });
    }

    @Test
    public void addTimeGame() {

        player.installGame(game);

        player.play(game, 22);
        player.play(game, 22);

        int expected = 54;
        int actual = player.play(game, 10);

        assertEquals(expected, actual);
    }

    @Test

    public void addTimeGameNewTime() {
        player.installGame(game);

        int expected = 10;
        int actual = player.play(game, 10);

        assertEquals(expected, actual);

    }

    @Test

    public void addTimeGameNewTimeTwoGame() {
        player.installGame(game);
        player.installGame(game2);

        int expected = 10;
        int actual = player.play(game2, 10);

        assertEquals(expected, actual);

    }


    @Test
    public void shouldSumGenreIfOneGame() {

        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());

        assertEquals(expected, actual);

    }

    @Test
    public void mostTimeGameThisGenre() {

        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 12);
        player.play(game1, 22);
        player.play(game2, 69);

        String exception = "SWAT";
        String actual = player.mostPlayerByGenre("Action");

        assertEquals(exception, actual);

    }

    @Test
    public void mostTimeNotGameThisGenre() {

        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 12);
        player.play(game1, 22);

        String exception = null;
        String actual = player.mostPlayerByGenre("Strategy");

        assertEquals(exception, actual);

    }

    @Test
    public void mostTimeTwoGamesThisGenre() {

        player.installGame(game);
        player.installGame(game1);
        player.installGame(game2);
        player.play(game, 22);
        player.play(game1, 22);

        String exception = "SWAT";
        String actual = player.mostPlayerByGenre("Action");

        assertEquals(exception, actual);

    }

    @Test
    public void sumGenre() {
        player.installGame(game);
        player.installGame(game1);

        player.play(game, 22);
        player.play(game1, 12);

        int expected = 34;
        int actual = player.sumGenre("Action");

        assertEquals(expected, actual);

    }

    @Test
    public void sumGenreNotGame() {
        player.installGame(game);
        player.installGame(game1);

        player.play(game, 22);
        player.play(game1, 12);

        int expected = 0;
        int actual = player.sumGenre("Аркады");

        assertEquals(expected, actual);

    }

    @Test
    public void sumGenreSeveralPlayer() {
        player.installGame(game);
        player.installGame(game1);
        player2.installGame(game);

        player.play(game, 22);
        player.play(game1, 12);
        player2.play(game, 12);

        int expected = 12;
        int actual = player2.sumGenre("Action");

        assertEquals(expected, actual);

    }

}
