package com.example.asm2_restapi.model;

import lombok.Getter;

import java.time.LocalDate;

//@Getter

public record Oto(String bienSoXe, LocalDate ngaySanXuat, int soChoNgoi, boolean dangKyKinhDoanh) {

}
