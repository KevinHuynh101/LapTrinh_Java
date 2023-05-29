package com.example.asm2_restapi.controller;

import com.example.asm2_restapi.model.Oto;
import com.example.asm2_restapi.service.Asm2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Asm2/Search")
public class SearchController {
    @Autowired
    private Asm2Service asm2Service;

    @GetMapping("/bienSoXe")
    public List<Oto> SearchBienSoXe(@RequestBody String bienSoXe) {
        return asm2Service.SeachBienSoXe(bienSoXe);
    }

    @GetMapping("/soChoNgoi")
    public List<Oto> SearchSoChoNgoi(@RequestBody int soChoNgoi) {
        return asm2Service.SeachSoChoNgoi(soChoNgoi);
    }

    @GetMapping("/NamSX")
    public List<Oto> SearchNamSX(@RequestBody String namSX) {
        return asm2Service.SeachTheoNamSX(namSX);
    }
}
