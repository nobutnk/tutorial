package tutorial.domain.service.auth;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import tutorial.domain.model.Account;
import tutorial.domain.repository.auth.AccountRepository;

@Service
@Transactional
public class AccountSharedServiceImpl implements AccountSharedService {
    
    @Inject
    AccountRepository accountRepository;

    @Override
    public Account findOne(String username) {
        Account account = accountRepository.findOneByUsername(username);
        if (account == null) {
            throw new ResourceNotFoundException("The given account is not found! username="
                    + username);
        }
        return account;
    }

}
