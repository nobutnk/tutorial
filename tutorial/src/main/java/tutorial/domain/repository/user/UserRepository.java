package tutorial.domain.repository.user;

import tutorial.domain.model.User;

public interface UserRepository {
    User findOne(Integer id);

}
