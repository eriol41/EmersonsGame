package com.odde.emersonsgame.data.impl;

import com.odde.emersonsgame.data.DataException;
import com.odde.emersonsgame.data.PlayerRepository;
import com.odde.emersonsgame.model.Player;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.odde.emersonsgame.data.impl.Connections.getConnection;

public class PlayerRepositoryImpl implements PlayerRepository {
    @Override
    public List<Player> getAll() {
        String sql = "SELECT id, name FROM players";

        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Player> players = new ArrayList<>();

        try {
            c = getConnection();
            ps = c.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");

                Player player = new Player(name);

                players.add(player);
            }

            return players;
        } catch (SQLException e) {
            throw new DataException(e);
        } finally {
            try {
                rs.close();
                ps.close();
                c.close();
            } catch (SQLException e) {
                throw new DataException(e);
            }
        }
    }
}
