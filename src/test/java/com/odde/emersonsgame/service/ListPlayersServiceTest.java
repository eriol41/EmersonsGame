package com.odde.emersonsgame.service;

import com.odde.emersonsgame.data.PlayerRepository;
import com.odde.emersonsgame.service.impl.ListPlayersServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;

public class ListPlayersServiceTest {
    private ListPlayersService service;

    @Mock
    private PlayerRepository playerRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ListPlayersServiceImpl service = new ListPlayersServiceImpl();
        service.setPlayerRepository(playerRepository);

        this.service = service;
    }

    @Test
    public void GetAllPlayersMustReturnAllPlayers() {
        service.getAllPlayers();

        verify(playerRepository).getAll();
    }
}
