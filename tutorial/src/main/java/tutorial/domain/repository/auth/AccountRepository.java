package tutorial.domain.repository.auth;

import tutorial.domain.model.Account;

public interface AccountRepository {
    
    Account findOneByUsername(String username);

}
