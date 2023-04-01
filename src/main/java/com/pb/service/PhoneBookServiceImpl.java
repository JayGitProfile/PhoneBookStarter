package com.pb.service;

import com.pb.PhoneBookApplication;
import com.pb.model.PhoneBookEntry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class PhoneBookServiceImpl implements PhoneBookService {

    @Override
    public void add(PhoneBookEntry phoneBookEntry) {
        try {
            if (PhoneBookApplication.phoneBookEntries.containsKey(phoneBookEntry.getName())) {
                throw new Exception("Entry already exists");
            }
            PhoneBookApplication.phoneBookEntries.put(phoneBookEntry.getName(), phoneBookEntry);
        } catch (Exception e) {
            log.error("Error occurred when adding entry: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(String name, String phNum) {
        add(new PhoneBookEntry(name, phNum));
    }

    @Override
    public void deleteByName(String name) {
        try {
            if (!PhoneBookApplication.phoneBookEntries.containsKey(name)) {
                throw new Exception("Entry doesn't exist");
            }
            PhoneBookApplication.phoneBookEntries.remove(name);
        } catch (Exception e) {
            log.error("Error occurred when deleting entry: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteByNumber(String phNum) {
        try {
            Iterator<Map.Entry<String, PhoneBookEntry>> iterator = PhoneBookApplication.phoneBookEntries.entrySet().iterator();
            while(iterator.hasNext()) {
                PhoneBookEntry phoneBookEntry = iterator.next().getValue();
                if(phoneBookEntry.getPhNum().equals(phNum)) {
                    PhoneBookApplication.phoneBookEntries.remove(phoneBookEntry.getName());
                    return true;
                }
            }
            throw new Exception("Entry doesn't exist");
        } catch (Exception e) {
            log.error("Error occurred when deleting entry: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<PhoneBookEntry> list() {
        try {
            return new ArrayList<>(PhoneBookApplication.phoneBookEntries.values());
        } catch (Exception e) {
            log.error("Error occurred when retrieving all entries: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
