package com.project.wallet.service;

import com.project.wallet.domain.Receipt;
import com.project.wallet.repository.ReceiptRepository;

import java.util.List;
import java.util.Optional;

public class ReceiptService {

    private ReceiptRepository receiptRepository;

    public ReceiptService(ReceiptRepository receiptRepository){
        this.receiptRepository = receiptRepository;
    }

    public Long join(Receipt receipt){
        receiptRepository.save(receipt);
        return receipt.getReceipt_id();
    }

    public List<Receipt> findReceipts(){
        return receiptRepository.findAll();
    }

    public Optional<Receipt> findReceiptByReceiptId(long receiptId){
        return receiptRepository.findByReceiptId(receiptId);
    }

    public Optional<Receipt> findReceiptByWalletId(long walletId){
        return receiptRepository.findByWalletId(walletId);
    }
}
