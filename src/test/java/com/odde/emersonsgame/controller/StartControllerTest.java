package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Player;
import com.odde.emersonsgame.service.ListPlayersService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class StartControllerTest {
    private StartController controller;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private ListPlayersService listPlayersService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        controller = new StartController();
        controller.setListPlayersService(listPlayersService);

        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void ListPlayersMustBeEmptyIfNoPlayers() throws ServletException, IOException {
        controller.doGet(request, response);

        assertThatControllerForwardedToIndexPage();
        assertThatPlayersAttributeContains(Collections.emptyList());
    }

    @Test
    public void ListPlayersMustShowAllPlayers() throws ServletException, IOException {
        List<Player> players = new ArrayList<>();
        players.add(new Player());
        players.add(new Player());

        when(listPlayersService.getAllPlayers()).thenReturn(players);

        controller.doGet(request, response);

        assertThatControllerForwardedToIndexPage();
        assertThatPlayersAttributeContains(players);
    }

    private void assertThatControllerForwardedToIndexPage() {
        ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);

        verify(request).getRequestDispatcher(captor.capture());

        assertThat(captor.getValue(), is("pages/start/index.jsp"));
    }

    private void assertThatPlayersAttributeContains(List<Player> players) {
        ArgumentCaptor<String> keyCaptor = ArgumentCaptor.forClass(String.class);

        @SuppressWarnings("unchecked")
        ArgumentCaptor<List<Player>> valueCaptor = ArgumentCaptor.forClass((Class) List.class);

        verify(request).setAttribute(keyCaptor.capture(), valueCaptor.capture());

        assertThat(keyCaptor.getValue(), is(StartController.PLAYERS));
        assertThat(valueCaptor.getValue(), is(players));
    }
}
