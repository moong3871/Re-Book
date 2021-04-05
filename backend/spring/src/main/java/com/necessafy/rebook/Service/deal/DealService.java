package com.necessafy.rebook.Service.deal;

import com.necessafy.rebook.dao.DealDao;
import com.necessafy.rebook.dao.DealerDao;
import com.necessafy.rebook.dao.OldBookDao;
import com.necessafy.rebook.exception.NotExistsDealException;
import com.necessafy.rebook.model.market.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DealService {
    private final DealDao dealDao;
    private final DealerDao dealerDao;
    private final OldBookDao oldBookDao;
    private final DealerMapper dealerMapper;
    private final OldBookMapper oldBookMapper;
//    private final DealMapper dealMapper;

    public List<Dealer> findByUserEmail(String email) {
        return dealerDao.findByUserEmail(email);
    }

    public Optional<Deal> checkDuplicateDeal(Dealer buyer, OldBookDto oldBook) {
        System.out.println("구매자");
        System.out.println(buyer);
        System.out.println("중고책");
        System.out.println(oldBookDao.findById(oldBook.getId()).get());

        return dealDao.findByBuyerAndOldBook(buyer, oldBookDao.findById(oldBook.getId()).get());
    }

    // 실질적으로 거래를 생성하지만, buyer정보와 중고책 정보가 동시에 중복되는 거래 내역이 있는지 확인하고,
    // 중복이 된다면 피하도록 한다
    public Deal createDeal(DealerDto buyerDto, OldBookDto oldBookDto) {
//        Dealer curBuyer = dealerMapper.from(buyerDto);
//        checkDuplicateDeal(curBuyer, oldBookDto);
        // 소비자를 거래인 명부에 등록시킨다
        Dealer buyer = dealerDao.save(dealerMapper.from(buyerDto));
        System.out.println("isitokay??");
        // 거래 정보에 소비자와 중고책 정보(판매자 정보 포함)를
        Deal deal = dealDao.save(Deal.builder()
                .oldBook(oldBookMapper.from(oldBookDto))
                .buyer(buyer)
                .build()
        );
        System.out.println("2222222222");
        return deal;
    }


//    @Transactional(readOnly = true)
//    public List<DealDto> getDeals() {
//        List<Deal> allDeals = dealDao.findAll();
//
//        return allDeals.stream()
//                .map(dealMapper::to)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public long beginDeal(DealerDto buyerDto, OldBookDto oldBookDto) {
//        Dealer buyer = dealerDao.save(dealerMapper.from(buyerDto));
//
//        Deal deal = dealDao.save(Deal.builder()
//                .book(oldBookMapper.from(oldBookDto))
//                .buyer(buyer)
//                .build());
//
//        return deal.getId();
//    }
//
//    @Transactional
//    public List<DealDto> getMyDeals(DealerDto dealerDto) {
//        List<Deal> allDeals = dealDao.findAll();
//
//        /* TODO */
//        /* jpql or querydsl 로 개선 필요한 코드 */
//        Dealer dealer = dealerMapper.from(dealerDto);
//        return allDeals.stream()
//                .filter(d -> (d.getBuyer().getId() == dealer.getId()) || (d.getBook().getSeller().getId() == dealer.getId()))
//                .map(dealMapper::to)
//                .collect(Collectors.toList());
//    }
//
//    @Transactional
//    public void agreeSeller(long dealId) {
//        Deal deal = dealDao.findById(dealId).orElseThrow(NotExistsDealException::new);
//
//        deal.getBook().getSeller().agree();
//    }
//
//    @Transactional
//    public void agreeBuyer(long dealId) {
//        Deal deal = dealDao.findById(dealId).orElseThrow(NotExistsDealException::new);
//
//        deal.getBuyer().agree();
//    }
//
//    public boolean isAllAgree(long dealId) {
//        Deal deal = dealDao.findById(dealId).orElseThrow(NotExistsDealException::new);
//
//        return deal.getBuyer().isAgree() && deal.getBook().getSeller().isAgree();
//    }
//
//    @Transactional
//    public void completeDeal(long dealId) {
//        Deal deal = dealDao.findById(dealId).orElseThrow(NotExistsDealException::new);
//
//        deal.completeDeal();
//    }
}
