package com.wellsfargo.counselor.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_id")
    private Long securityId;

    @ManyToOne
    @JoinColumn(name = "portfolio_id", nullable = false)
    private Portfolio portfolio;

    @Column(nullable = false)
    private String tickerSymbol;

    @Column(nullable = false)
    private String name;

    @Column
    private String category;

    @Column
    private LocalDate purchaseDate;

    @Column
    private Double purchasePrice;

    @Column
    private Integer quantity;

    // Full Constructor
    public Security(Long securityId, Portfolio portfolio, String tickerSymbol,
                    String name, String category, LocalDate purchaseDate,
                    Double purchasePrice, Integer quantity) {

        this.securityId = securityId;
        this.portfolio = portfolio;
        this.tickerSymbol = tickerSymbol;
        this.name = name;
        this.category = category;
        this.purchaseDate = purchaseDate;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    public Security() {}

    // Getters
    public Long getSecurityId() { return securityId; }
    public Portfolio getPortfolio() { return portfolio; }
    public String getTickerSymbol() { return tickerSymbol; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public LocalDate getPurchaseDate() { return purchaseDate; }
    public Double getPurchasePrice() { return purchasePrice; }
    public Integer getQuantity() { return quantity; }

    // Setters (No setter for ID)
    public void setPortfolio(Portfolio portfolio) { this.portfolio = portfolio; }
    public void setTickerSymbol(String tickerSymbol) { this.tickerSymbol = tickerSymbol; }
    public void setName(String name) { this.name = name; }
    public void setCategory(String category) { this.category = category; }
    public void setPurchaseDate(LocalDate purchaseDate) { this.purchaseDate = purchaseDate; }
    public void setPurchasePrice(Double purchasePrice) { this.purchasePrice = purchasePrice; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
