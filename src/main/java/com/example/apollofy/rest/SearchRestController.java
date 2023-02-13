package com.example.apollofy.rest;

import com.example.apollofy.service.SearchService;
import com.example.apollofy.service.dto.SearchDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/search")

public class SearchRestController {

    private final SearchService searchService;

    public SearchRestController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping( "/{search}")
    public String searchDTO (@PathVariable String search){
        SearchDTO searchDTO;
        searchDTO = searchService.search(search);
        return searchDTO.toString();
    }

}
