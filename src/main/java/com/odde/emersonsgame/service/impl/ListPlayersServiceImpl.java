package com.odde.emersonsgame.service.impl;

import com.odde.emersonsgame.data.PlayerRepository;
import com.odde.emersonsgame.data.impl.PlayerRepositoryImpl;
import com.odde.emersonsgame.model.Player;
import com.odde.emersonsgame.service.ListPlayersService;

import java.util.List;

public class ListPlayersServiceImpl implements ListPlayersService {
    private PlayerRepository playerRepository;

    public ListPlayersServiceImpl() {
        playerRepository = new PlayerRepositoryImpl();
    }

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getAll();
    }

    public void setPlayerRepository(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
}
