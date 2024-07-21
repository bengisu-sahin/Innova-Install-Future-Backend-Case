package com.installfuturecase.InstallFutureBackendCase.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="amount", nullable = false)
    private BigDecimal amount;

    @Column(name="description",length = 255)
    private String description;

    @Column(name = "transaction_type",length = 50)
    private String transaction_type;

    @Column(name="transaction_date", nullable = false)
    private LocalDate transaction_date;

    @Column(name = "created_at", updatable = false)
    private LocalDate created_at;

    @Column(name = "updated_at")
    private LocalDate updated_at;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;
}
