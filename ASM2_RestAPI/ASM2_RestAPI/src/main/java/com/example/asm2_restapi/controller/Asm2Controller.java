package com.example.asm2_restapi.controller;

import com.example.asm2_restapi.model.Oto;
import com.example.asm2_restapi.service.Asm2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Asm2")
public class Asm2Controller {
    @Autowired
    private Asm2Service Asm2Service;

    @GetMapping
    public List<Oto> getAll() {
        return Asm2Service.getAll();
    }

    @PostMapping
    public Oto add(@RequestBody Oto NewOto) {
        Asm2Service.add(NewOto);
        return NewOto;
    }

    @DeleteMapping("{bienSoxe}")
    public void DeleteBienSoXe(@RequestBody String bienSoXe) {
        Asm2Service.remove(bienSoXe);
    }

}
