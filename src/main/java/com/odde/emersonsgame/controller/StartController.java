package com.odde.emersonsgame.controller;

import com.odde.emersonsgame.model.Player;
import com.odde.emersonsgame.service.ListPlayersService;
import com.odde.emersonsgame.service.impl.ListPlayersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/start")
public class StartController extends HttpServlet {
    static final String PLAYERS = "players";

    private ListPlayersService listPlayersService;

    public StartController() {
        listPlayersService = new ListPlayersServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Player> players = listPlayersService.getAllPlayers();

        req.setAttribute(PLAYERS, players);

        req.getRequestDispatcher("pages/start/index.jsp").forward(req, resp);
    }

    void setListPlayersService(ListPlayersService listPlayersService) {
        this.listPlayersService = listPlayersService;
    }
}
