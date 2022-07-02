package com.project.wallet.repository;

import com.project.wallet.domain.Wallet;

import java.util.List;
import java.util.Optional;

public interface WalletRepository {
    Wallet save(Wallet wallet);
    Optional<Wallet> findByWalletId(Long wallet_id);
    Optional<Wallet> findByUserId(Long user_id);
    List<Wallet> findAll();

}
