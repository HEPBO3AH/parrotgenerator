package com.dusanv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class ConverterController {

    private ConverterService converterService;

    @Autowired
    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @RequestMapping(name = "/generate", method = RequestMethod.GET, produces = "application/text")
    public @ResponseBody String generate(@RequestParam("phrase") String phrase, @RequestParam("foreground") String foreground, @RequestParam("background") String background) throws IOException {
        return converterService.convertPhrase(phrase.toUpperCase(), foreground, background);
    }
}
