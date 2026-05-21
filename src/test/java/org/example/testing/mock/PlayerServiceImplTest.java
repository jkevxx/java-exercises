package org.example.testing.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.Mockito;
import static org.mockito.Mockito.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {

    @Mock
    private PlayerRepositoryImpl playerRepository;

    @InjectMocks
    private PlayerServiceImpl playerService;

    @Test
    public void testFindAll() {


        when(playerRepository.findAll()).thenReturn(DataProvider.playersListMock());
        List<Player> result = playerService.findAll();

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Lionel Messi", result.getFirst().getName());
    }

    @Test
    void testFindBydId() {
    }

    @Test
    void testSave() {
    }

    @Test
    void testDeleteById() {
    }
}