package tutorial.domain.service.auth;

import javax.inject.Inject;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import tutorial.domain.model.Account;
import tutorial.domain.repository.auth.AccountRepository;

@Service
@Transactional
public class AccountUserServiceImpl implements AccountUserService {
    
    @Inject
    AccountRepository accountRepository;
    
    @Inject
    PasswordEncoder passwordEncoder;

    @Override
    public Account create(Account account) {
        String encodedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encodedPassword);
        try {
            accountRepository.create(account);
        } catch (DuplicateKeyException e) {
            ResultMessages messages = ResultMessages.error();
            messages.add(ResultMessage
                    .fromText("[E901] The requested Username is already registerd. (username="
                            + account.getUsername() + ")"));
            throw new BusinessException(messages, e);
        }
        
        return account;
    }

    @Override
    public Account update(Account account) {
        accountRepository.update(account);
        return account;
    }

}
