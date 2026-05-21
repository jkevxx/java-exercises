package org.example.testing.mock;

import java.util.List;

public interface IPlayerRepository {

    List<Player> findAll();
    Player findBydId(Long id);
    void save(Player player);
    void deleteById(Long id);

}
