package com.odde.emersonsgame.data;

import com.odde.emersonsgame.model.Player;

import java.util.List;

public interface PlayerRepository {
    List<Player> getAll();
}
