package com.vh1ne.strategies.nse.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BhavCopy {
    private Long id;
    private String series;
    private LocalDate date;
    private float prevClose;
    private float openPrice;
    private float highPrice;
    private float lowPrice;
    private float lastPrice;
    private float closePrice;
    private float avgPrice;
    private BigDecimal totalTradedQuantity;
    private BigDecimal turnoverInLacs;
    private BigDecimal noOfTrades;
    private BigDecimal deliveryQuantity;
    private float deliveryPercentage;
    private LocalDateTime lastUpdated;
    private String deleted;
    private LocalDateTime createdAt;
    private Object stock;
}