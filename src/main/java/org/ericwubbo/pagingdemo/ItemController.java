package org.ericwubbo.pagingdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public Iterable<Item> getAll(Pageable pageable) {
        return itemRepository.findAll(PageRequest.of(
                pageable.getPageNumber(),
                Math.min(pageable.getPageSize(), 3),
                Sort.by(Sort.Order.desc("price"))));
    }
}
