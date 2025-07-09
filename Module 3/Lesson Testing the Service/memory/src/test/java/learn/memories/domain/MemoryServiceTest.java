package learn.memories.domain;

import learn.memories.data.DataAccessException;
import learn.memories.data.MemoryRepositoryDouble;
import learn.memories.models.Memory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryServiceTest {

    MemoryService service;

    @BeforeEach
    void setup() {
        MemoryRepositoryDouble repository = new MemoryRepositoryDouble();
        service = new MemoryService(repository);
    }

    @Test
    void shouldFindTwoPublicMemories() throws DataAccessException {
        List<Memory> memories = service.findPrivateMemories();
        assertEquals(2, memories.size());
    }

    @Test
    void shouldFindOnePrivateMemory() throws DataAccessException {
        List<Memory> memories = service.findPrivateMemories();
        assertEquals(1, memories.size());
    }

    @Test
    void shouldNotAddNullFrom() throws DataAccessException {
        //Arrange
        Memory memory = new Memory();
        memory.setContent("That one time we...");
        String message;

        //Act
        MemoryResult result = service.add(memory);
        message = result.getErrorMessages().get(0).toString();

        //Assert
        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(message.contains("'from'"));
    }

    @Test
    void shouldNotAddEmptyContent() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Zonda Itscowics");
        String content;

        MemoryResult result = service.add(memory);
        content = result.getErrorMessages().get(0).toString();

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(content.contains("`content`"));
    }

    @Test
    void shouldNotAddPositiveId() throws DataAccessException {
        Memory memory = new Memory(12, "from", "content", true);
        String message;

        MemoryResult result = service.add(memory);
        message = result.getErrorMessages().get(0).toString();

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(message.contains("`id`"));
    }

    @Test
    void shouldAdd() throws DataAccessException {
        Memory memory = new Memory();
        memory.setFrom("Zonda Itscowics");
        memory.setContent("That one time we...");

        MemoryResult result = service.add(memory);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateEmptyContent() throws DataAccessException {
        Memory memory = service.findPublicMemories().get(0);
        memory.setContent("\t\n ");
        String update;

        MemoryResult result = service.update(memory);
        update = result.getErrorMessages().get(0).toString();

        assertFalse(result.isSuccess());
        assertEquals(1, result.getErrorMessages().size());
        assertTrue(update.contains("`content`"));
    }

    @Test
    void shouldUpdate() throws DataAccessException {
        Memory memory = service.findPublicMemories().get(0);
        memory.setContent("updated content");

        MemoryResult result = service.update(memory);

        assertTrue(result.isSuccess());
    }
}