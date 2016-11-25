package com.odde.emersonsgame.model;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.odde.emersonsgame.model.Player.SUPERSPEED;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PlayerTest {

    public static final String DUCATI = "ducati";
    private Player player;

    @Before
    public void setUp() throws Exception {
        player = new Player(DUCATI);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldSelectSpeed() {
        // given

        // when
        player.setSpeed(SUPERSPEED);

        // then
        assertThat(player.getSpeed(), is(SUPERSPEED));
    }

    @Test
    public void shouldAddPositionWhenDiceResultIsOddAndPlayerSpeedNormal() {
        // given
        Integer diceResult1 = 1;
        Integer diceResult2 = 3;
        Integer diceResult3 = 5;
        Player player1 = new Player(DUCATI);
        Player player2 = new Player(DUCATI);
        Player player3 = new Player(DUCATI);

        // when
        player1.includeDiceResult(diceResult1);
        player2.includeDiceResult(diceResult2);
        player3.includeDiceResult(diceResult3);

        // then
        assertThat(player1.getPosition(), is(1));
        assertThat(player2.getPosition(), is(1));
        assertThat(player3.getPosition(), is(1));
    }

    @Test
    public void shouldAddPositionWhenDiceResultIsEvenAndPlayerSpeedNormal() {
        // given
        Integer diceResult1 = 2;
        Integer diceResult2 = 4;
        Integer diceResult3 = 6;
        Player player1 = new Player(DUCATI);
        Player player2 = new Player(DUCATI);
        Player player3 = new Player(DUCATI);

        // when
        player1.includeDiceResult(diceResult1);
        player2.includeDiceResult(diceResult2);
        player3.includeDiceResult(diceResult3);

        // then
        assertThat(player1.getPosition(), is(2));
        assertThat(player2.getPosition(), is(2));
        assertThat(player3.getPosition(), is(2));
    }

    @Test
    public void shouldAddPositionAndDamageWhenPlayerSpeedIsSuperSpeed() {
        // given
        Integer diceResult1 = 1;
        Integer diceResult2 = 2;
        Integer diceResult3 = 3;
        Integer diceResult4 = 4;
        Integer diceResult5 = 5;
        Integer diceResult6 = 6;
        Player player1 = new Player(DUCATI);
        Player player2 = new Player(DUCATI);
        Player player3 = new Player(DUCATI);
        Player player4 = new Player(DUCATI);
        Player player5 = new Player(DUCATI);
        Player player6 = new Player(DUCATI);

        // when
        player1.setSpeed(SUPERSPEED);
        player2.setSpeed(SUPERSPEED);
        player3.setSpeed(SUPERSPEED);
        player4.setSpeed(SUPERSPEED);
        player5.setSpeed(SUPERSPEED);
        player6.setSpeed(SUPERSPEED);
        player1.includeDiceResult(diceResult1);
        player2.includeDiceResult(diceResult2);
        player3.includeDiceResult(diceResult3);
        player4.includeDiceResult(diceResult4);
        player5.includeDiceResult(diceResult5);
        player6.includeDiceResult(diceResult6);

        // then
        assertThat(player1.getPosition(), is(diceResult1));
        assertThat(player2.getPosition(), is(diceResult2));
        assertThat(player3.getPosition(), is(diceResult3));
        assertThat(player4.getPosition(), is(diceResult4));
        assertThat(player5.getPosition(), is(diceResult5));
        assertThat(player6.getPosition(), is(diceResult6));
        assertThat(player1.getDamage(), is(1));
        assertThat(player2.getDamage(), is(1));
        assertThat(player3.getDamage(), is(1));
        assertThat(player4.getDamage(), is(1));
        assertThat(player5.getDamage(), is(1));
        assertThat(player6.getDamage(), is(1));
    }

    @Test
    public void shouldAddPositionAndDamageWhenPlayerSpeedIsSuperSpeedAndContainsDamage() {
        // given
        Integer diceResult1 = 1;
        Integer diceResult2 = 2;
        Integer diceResult3 = 3;
        Integer diceResult4 = 4;
        Integer diceResult5 = 5;
        Integer diceResult6 = 6;
        Integer initialScore = 1;
        Integer previousDamage = 1;
        Player player1 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());
        Player player2 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());
        Player player3 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());
        Player player4 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());
        Player player5 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());
        Player player6 = new Player(DUCATI).withSpeed(SUPERSPEED).withScore(initialScore).withDamage(new Damage());

        // when
        player1.includeDiceResult(diceResult1);
        player2.includeDiceResult(diceResult2);
        player3.includeDiceResult(diceResult3);
        player4.includeDiceResult(diceResult4);
        player5.includeDiceResult(diceResult5);
        player6.includeDiceResult(diceResult6);

        // then
        assertThat(player1.getPosition(), is(initialScore + diceResult1 - previousDamage));
        assertThat(player2.getPosition(), is(initialScore + diceResult2 - previousDamage));
        assertThat(player3.getPosition(), is(initialScore + diceResult3 - previousDamage));
        assertThat(player4.getPosition(), is(initialScore + diceResult4 - previousDamage));
        assertThat(player5.getPosition(), is(initialScore + diceResult5 - previousDamage));
        assertThat(player6.getPosition(), is(initialScore + diceResult6 - previousDamage));
        assertThat(player1.getDamage(), is(previousDamage + 1));
        assertThat(player2.getDamage(), is(previousDamage + 1));
        assertThat(player3.getDamage(), is(previousDamage + 1));
        assertThat(player4.getDamage(), is(previousDamage + 1));
        assertThat(player5.getDamage(), is(previousDamage + 1));
        assertThat(player6.getDamage(), is(previousDamage + 1));
    }
}
