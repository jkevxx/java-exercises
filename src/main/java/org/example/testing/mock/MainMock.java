package org.example.testing.mock;

public class MainMock {
    public static void main(String[] args) {

        PlayerRepositoryImpl playerRepository = new PlayerRepositoryImpl();

        PlayerServiceImpl playerService = new PlayerServiceImpl(playerRepository);

//        System.out.println(playerService.findAll());

//        System.out.println(playerService.findBydId(1L));

//        playerService.deleteById(1L);
//        System.out.println(playerService.findAll());

//        Player player = new Player(7L, "Luiz Dias", "Delantero", "Liverpool");
//        playerService.save(player);
//        System.out.println(playerService.findAll());
    }
}
