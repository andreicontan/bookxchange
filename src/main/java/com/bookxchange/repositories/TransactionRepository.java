package com.bookxchange.repositories;

import com.bookxchange.model.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

     List<TransactionEntity> findAllByMemberIdFrom(String memberIdFrom);
     List<TransactionEntity> findByTransactionType(String transactionType);

     @Query(value= "SELECT * FROM transaction WHERE transaction.market_book_id =?1  AND transaction.member_id_to =?2", nativeQuery = true)
     List<TransactionEntity> getTransactionsByBookIdAndLeftBy(String marketBookId, String memberIdTo);

     @Query(value = "SELECT * FROM transaction WHERE transaction.member_id_from =?1 AND transaction.member_id_to =?2", nativeQuery = true)
     List<TransactionEntity> getTransactionByWhoSelleddAndWhoBuys(String memberIdFrom, String memberIdTo);

     List<TransactionEntity> findAllByTransactionDate(LocalDate transactionDate);
}
