package com.amit3.Amit31.IPLcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amit3.Amit31.service.iplService;

import entity.IplTeam;


@RestController
public class controller {

    private final iplService iplService;

    public controller(iplService iplService) {
        this.iplService = iplService;
    }

    @PostMapping("/insert")
    public ResponseEntity<IplTeam> insertData(@RequestBody IplTeam iplTeam) {
        IplTeam savedData = iplService.insertData(iplTeam);
        return new ResponseEntity<>(savedData, HttpStatus.CREATED);
    }
}

