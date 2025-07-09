package learn.memories.data;

import learn.memories.models.Memory;

import java.util.List;

//CRUD Class
public interface MemoryRepository {
    //READ
    //Finds all memories in the data source
    List<Memory> findAll() throws DataAccessException;

    //READ
    //Returns one memory based on its unique identifier.  If the identifier doesn't exist, the method returns null.
    Memory findById(int memoryId) throws DataAccessException;

    //READ
    //Returns memories based on their shareable property
    List<Memory> findShareable(boolean shareable) throws DataAccessException;

    //CREATE
    //Adds a new memory to the data source
    Memory add(Memory memory) throws DataAccessException;

    //UPDATE
    //Updates an existing memory using its unique identifier.  If the identifier doesn't exist, it returns false.  Otherwise it returns true.
    boolean update(Memory memory) throws DataAccessException;

    //DELETE
    //Deletes an existing memory using its unique identifier.
    //If the identifier doesn't exist, it returns false.  Otherwise, it returns true.
    boolean deleteById(int memoryId) throws DataAccessException;
}
