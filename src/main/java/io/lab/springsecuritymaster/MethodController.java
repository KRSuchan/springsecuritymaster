package io.lab.springsecuritymaster;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class MethodController {

    private static final Logger log = LoggerFactory.getLogger(MethodController.class);
    private final DataService dataService;

    @PostMapping("/writeList")
    public List<Account> writeList(@RequestBody List<Account> data) {
        return dataService.writeList(data);
    }

    @PostMapping("/writeMap")
    public Map<String, Account> writeMap(@RequestBody List<Account> data) {
        Map<String, Account> dataMap = data.stream()
                .collect(Collectors.toMap(Account::getOwner, account -> account));
        return dataService.writeMap(dataMap);
    }

    @GetMapping("/readList")
    public List<Account> readList() {
        return dataService.readList();
    }

    @GetMapping("/readMap")
    public Map<String, Account> readMap() {
        return dataService.readMap();
    }
}
