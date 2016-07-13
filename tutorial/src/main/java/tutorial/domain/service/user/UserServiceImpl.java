package tutorial.domain.service.user;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import tutorial.domain.model.User;
import tutorial.domain.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    
    @Inject
    private UserRepository userRepository;

    @Override
    public User findOne(Integer id) {
        return userRepository.findOne(id);
    }

}
