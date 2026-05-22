package org.example.testing.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
//import org.mockito.Mockito; // this is another way to call
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
        // When
        when(playerRepository.findAll()).thenReturn(DataProvider.playersListMock());
        List<Player> result = playerService.findAll();

        // Then
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals("Lionel Messi", result.getFirst().getName());
        verify(this.playerRepository).findAll();
    }

    @Test
    void testFindBydId() {
        // Given
        Long id = 1L;

        // When
        when(playerRepository.findBydId(anyLong())).thenReturn(DataProvider.playerMock());
        Player result = playerService.findBydId(id);

        // Then
        assertNotNull(result);
        assertEquals("Lionel Messi", result.getName());
        verify(this.playerRepository, times(1)).findBydId(anyLong());
    }

    @Test
    void testSave() {
        // Given
        Player player = DataProvider.newPlayerMock();

        // When
        this.playerService.save(player);

        // Then
        verify(this.playerRepository).save(any(Player.class));

        ArgumentCaptor<Player> playerArgumentCaptor = ArgumentCaptor.forClass(Player.class);
        verify(this.playerRepository).save(playerArgumentCaptor.capture());
        assertEquals(10L, playerArgumentCaptor.getValue().getId());
        assertEquals("Luiz Dias", playerArgumentCaptor.getValue().getName());

    }

    @Test
    void testDeleteById() {
        // Given
        Long id = 1L;

        // When
        this.playerService.deleteById(id);

        // Then
        verify(this.playerRepository).deleteById(anyLong());

        ArgumentCaptor<Long> longArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(this.playerRepository).deleteById(longArgumentCaptor.capture());
        assertEquals(1L, longArgumentCaptor.getValue());
    }
}