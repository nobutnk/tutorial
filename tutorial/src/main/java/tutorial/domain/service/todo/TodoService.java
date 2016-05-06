package tutorial.domain.service.todo;

import java.util.Collection;

import org.joda.time.DateTime;

import tutorial.domain.model.Todo;

public interface TodoService {

    Collection<Todo> findAll();
    
    Todo findOne(String todoId);

    Todo create(Todo todo);

    Todo finish(String todoId, DateTime updatedAt);

    void delete(String todoId, DateTime updatedAt);
    
    Todo update(Todo todo);
}
