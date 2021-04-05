package com.necessafy.rebook.dao;

import com.necessafy.rebook.model.market.Deal;
import com.necessafy.rebook.model.market.Dealer;
import com.necessafy.rebook.model.market.DealerDto;
import com.necessafy.rebook.model.market.OldBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DealDao extends JpaRepository<Deal,Long> {
    Optional<Deal> findByBuyerAndOldBook(Dealer buyer, OldBook oldBook);
}
