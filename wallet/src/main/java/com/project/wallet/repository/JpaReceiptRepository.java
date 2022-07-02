package com.project.wallet.repository;

import com.project.wallet.domain.Receipt;
import com.project.wallet.domain.Wallet;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class JpaReceiptRepository implements ReceiptRepository{

    private final EntityManager em;

    public JpaReceiptRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Receipt save(Receipt receipt) {
        em.persist(receipt);
        return receipt;
    }

    @Override
    public Optional<Receipt> findByReceiptId(Long receipt_id) {
        Receipt receipt = em.find(Receipt.class, receipt_id);
        return Optional.ofNullable(receipt);
    }

    @Override
    public Optional<Receipt> findByDate(Date date) {
        Receipt receipt = em.find(Receipt.class, date);
        return Optional.ofNullable(receipt);
    }

    @Override
    public Optional<Receipt> findByAmount(String amount) {
        Receipt receipt = em.find(Receipt.class, amount);
        return Optional.ofNullable(receipt);
    }

    @Override
    public Optional<Receipt> findByType(String type) {
        Receipt receipt = em.find(Receipt.class, type);
        return Optional.ofNullable(receipt);
    }

    public List<Receipt> findByWalletId(Long walletId){
        List<Receipt> result = em.createQuery("select r from Receipt r where r.wallet_id = :walletId", Receipt.class)
                .getResultList();
        return result;
    }

    public List<Receipt> findByUserId(Long UserId){
        List<Receipt> result = em.createQuery("select r from Receipt r where r.wallet_id = :UserId", Receipt.class).getResultList();
        return result;
    }

    @Override
    public List<Receipt> findAll() {
        return em.createQuery("select r from Receipt r", Receipt.class)
                .getResultList();
    }
}
