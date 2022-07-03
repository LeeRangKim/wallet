package com.project.wallet.repository;

import com.project.wallet.domain.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Repository
public class JpaWalletRepository implements WalletRepository{

    @Autowired
    private final EntityManager em;

    public JpaWalletRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Wallet save(Wallet wallet) {
        em.persist(wallet);
        return wallet;
    }

    @Override
    public Optional<Wallet> findByWalletId(Long wallet_id) {
        Wallet wallet = em.find(Wallet.class, wallet_id);
        return Optional.ofNullable(wallet);
    }

    @Override
    public Optional<Wallet> findByUserId(Long user_id) {
        Wallet wallet = em.find(Wallet.class, user_id);
        return Optional.ofNullable(wallet);
    }

    @Override
    public List<Wallet> findAll(){
        return em.createQuery("select w from Wallet w", Wallet.class)
                .getResultList();
    };
}
