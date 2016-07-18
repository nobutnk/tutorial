package tutorial.domain.repository.auth;

import tutorial.domain.model.Account;

public interface AccountRepository {
    
    Account findOneByUsername(String username);
    
    void create(Account account);
    
    int update(Account account);
    
    int createUserId();

}
