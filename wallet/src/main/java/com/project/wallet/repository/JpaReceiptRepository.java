package com.project.wallet.repository;

import com.project.wallet.domain.Receipt;
import com.project.wallet.domain.Wallet;

import javax.persistence.EntityManager;
import java.util.ArrayList;
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
        List<Wallet> wallets = em.createQuery("select w from Wallet w where w.user_id = :UserId", Wallet.class).getResultList();
        List<Receipt> result = new ArrayList<>();
        for (int i=0; i< wallets.size(); i++){
            Long WalletId = wallets.get(i).getWallet_id();
            List<Receipt> temp = em.createQuery("select r from Receipt r where r.wallet_id = :WalletId", Receipt.class).getResultList();
            result.addAll(temp);
        }
        return result;
    }

    @Override
    public List<Receipt> findAll() {
        return em.createQuery("select r from Receipt r", Receipt.class)
                .getResultList();
    }
}
