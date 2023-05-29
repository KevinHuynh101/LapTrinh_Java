package com.example.asm2_restapi.service;

import com.example.asm2_restapi.model.Oto;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Asm2Service {
    private List<Oto> OtoList = new ArrayList<>(Arrays.asList(
            new Oto("7132-12334", LocalDate.of(2022, 10, 1), 4, true),
            new Oto("7122-12345", LocalDate.of(2022,5 , 10), 5, true),
            new Oto("7112-54321", LocalDate.of(2022, 5, 10), 5, true)

            ));

    public List<Oto> getAll() {
        return OtoList;
    }

    public void add(Oto NewOto) {
        OtoList.add(NewOto);
    }

    public void remove(String bienSoXe) {
        OtoList.removeIf(t -> t.bienSoXe().toUpperCase().equals(bienSoXe));
    }

    public List<Oto> SeachBienSoXe(String bienSoXe) {
        return OtoList.stream().filter(t -> t.bienSoXe().toUpperCase().equals(bienSoXe)).toList();
    }


    public List<Oto> SeachSoChoNgoi(int soChoNgoi) {
        return OtoList.stream().filter(t -> t.soChoNgoi() == (soChoNgoi)).toList();
    }

    public List<Oto> SeachTheoNamSX(String namSX) {
        return OtoList.stream().filter(t -> t.ngaySanXuat().getYear() == Integer.parseInt(namSX)).toList();
    }
}
