package com.pb.service;

import com.pb.model.PhoneBookEntry;

import java.util.List;

public interface PhoneBookService {

    void add(PhoneBookEntry phoneBookEntry);

    void add(String name, String phNum);

    void deleteByName(String name);

    boolean deleteByNumber(String phNum);

    List<PhoneBookEntry> list();

}
