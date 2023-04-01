package com.pb.controller;

import com.pb.model.PhoneBookEntry;
import com.pb.service.PhoneBookService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("controller")
@RequiredArgsConstructor
@Slf4j
public class PbController {

    private final PhoneBookService phoneBookService;

    @ApiOperation(value = "Get list of phone book entries")
    @GetMapping("/list")
    public ResponseEntity<List<PhoneBookEntry>> list() {
        return ResponseEntity.ok(phoneBookService.list());
    }

    @ApiOperation(value = "Add a phone book entry")
    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> add(@RequestBody PhoneBookEntry newEntry) {
        phoneBookService.add(newEntry);
        return ResponseEntity.ok("Entry added successfully");
    }

    @ApiOperation(value = "Delete a phone book entry by name")
    @DeleteMapping(value = "/deleteByName")
    public ResponseEntity<String> deleteByName(@RequestParam("name") String name) {
        phoneBookService.deleteByName(name);
        return ResponseEntity.ok("Entry deleted successfully");
    }

    @ApiOperation(value = "Delete a phone book entry by number")
    @DeleteMapping(value = "/deleteByNum")
    public ResponseEntity<String> deleteByNum(@RequestParam("phNum") String phNum) {
        phoneBookService.deleteByNumber(phNum);
        return ResponseEntity.ok("Entry deleted successfully");
    }
}
