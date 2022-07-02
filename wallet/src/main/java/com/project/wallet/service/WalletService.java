package com.project.wallet.service;

import com.project.wallet.domain.Receipt;
import com.project.wallet.domain.Wallet;
import com.project.wallet.repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletService(WalletRepository walletRepository){
        this.walletRepository = walletRepository;
    }

    public Long join(Wallet wallet){
        walletRepository.save(wallet);
        return wallet.getWallet_id();
    }

    public List<Wallet> findWallets() {
        return walletRepository.findAll();
    }

    public Optional<Wallet> findWalletByWalletId(Long walletId){
        return walletRepository.findByWalletId(walletId);
    }

    public Optional<Wallet> findWalletByUserId(Long userId){
        return walletRepository.findByUserId(userId);
    }
}
