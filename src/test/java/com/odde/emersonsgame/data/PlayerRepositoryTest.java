package com.odde.emersonsgame.data;

import com.odde.emersonsgame.data.impl.PlayerRepositoryImpl;
import com.odde.emersonsgame.model.Player;
import org.dbunit.IDatabaseTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.odde.emersonsgame.data.support.Databases.getDataSet;
import static com.odde.emersonsgame.data.support.Databases.getDatabaseTester;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class PlayerRepositoryTest {
    private IDatabaseTester databaseTester;
    private PlayerRepository repository;

    @Before
    public void setUp() throws Exception {
        databaseTester = getDatabaseTester();
        databaseTester.setDataSet(getDataSet("PlayerRepositoryTest.xml"));
        databaseTester.onSetup();

        repository = new PlayerRepositoryImpl();
    }

    @After
    public void tearDown() throws Exception {
        databaseTester.onTearDown();
    }

    @Test
    public void testGetAllMustReturnAllRaces() {
        List<Player> result = repository.getAll();

        assertThat(result, notNullValue());
        assertThat(result.size(), is(4));
    }
}
