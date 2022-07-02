package com.project.wallet.service;

import com.project.wallet.domain.Receipt;
import com.project.wallet.repository.ReceiptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReceiptService {

    private ReceiptRepository receiptRepository;

    @Autowired
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

    public List<Receipt> findReceiptByWalletId(long walletId){
        return receiptRepository.findByWalletId(walletId);
    }

    public List<Receipt> findReceiptByUserId(long UserId){
        return receiptRepository.findByUserId(UserId);
    }
}
