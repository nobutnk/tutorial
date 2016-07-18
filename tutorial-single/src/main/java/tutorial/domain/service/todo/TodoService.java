package tutorial.domain.service.todo;

import java.time.LocalDateTime;
import java.util.Collection;

import tutorial.domain.model.Todo;

public interface TodoService {

    Collection<Todo> findAll();
    
    Todo findOne(Integer todoId);

    Todo create(Todo todo);

    Todo finish(Integer todoId, LocalDateTime updatedAt);

    void delete(Integer todoId, LocalDateTime updatedAt);
    
    Todo update(Todo todo);
}
