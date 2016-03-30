package tutorial.domain.service.oderitem;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tutorial.domain.model.Item;
import tutorial.domain.repository.orderitem.OrderItemRepository;

@Service
@Transactional
public class OrderItemServiceImpl implements OrderItemService {
    
    @Inject
    OrderItemRepository orderItemRepository;

    @Override
    @Transactional(readOnly = true)
    public Collection<Item> findAll() {
        return orderItemRepository.findAll();
    }

}
