package com.example.spring_boot.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryPayRequest {
    @NotBlank
    private Long trading_code; //mã giao dịch

    private Double surplus;//số dư ví
    @NotBlank
    private String description;//nội dung giao dịch
    @NotBlank
    private LocalDate time;

    private Boolean status;

    private String title;//nạp tiền vào ví

    private Double amounts;

}