package com.project.wallet.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Setter
@Getter
@Entity
public class Wallet {
    @Id
    @GeneratedValue
    private Long wallet_id;
    private Long user_id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Receipt> receipts;
}
