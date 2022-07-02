package com.project.wallet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Setter
@Getter
@Entity
public class Receipt {
    @Id
    private Long receipt_id;

    private Long wallet_id;

    private Date date;
    private Double amount;
    private String type;
}
