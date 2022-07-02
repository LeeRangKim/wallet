package com.project.wallet.repository;

import com.project.wallet.domain.Receipt;
import com.project.wallet.domain.Wallet;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ReceiptRepository {
    Receipt save(Receipt receipt);
    Optional<Receipt> findByReceiptId(Long receipt_id);
    Optional<Receipt> findByDate(Date date);
    Optional<Receipt> findByAmount(String amount);
    Optional<Receipt> findByType(String type);

    List<Receipt> findByWalletId(Long WalletId);

    List<Receipt> findByUserId(Long UserId);

    List<Receipt> findAll();
}
