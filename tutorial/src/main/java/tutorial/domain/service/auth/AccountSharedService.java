package tutorial.domain.service.auth;

import tutorial.domain.model.Account;

public interface AccountSharedService {
    Account findOne(String username);
}
