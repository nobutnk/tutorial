package tutorial.domain.service.auth;

import tutorial.domain.model.Account;

public interface AccountUserService {

    Account create(Account account);
    
    Account update(Account account);
}
