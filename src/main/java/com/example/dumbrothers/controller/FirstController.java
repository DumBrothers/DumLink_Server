package com.example.dumbrothers.controller;

import com.example.dumbrothers.dto.DumForm;
import com.example.dumbrothers.entity.Dum;
import com.example.dumbrothers.repository.DumRepository;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FirstController {
    @Autowired
    private DumRepository dumRepository;
    @GetMapping("/hi")
    public String niceToMeetYou(Model model){
        model.addAttribute("username","jw");
        return "greetings"; //templates/greetings.mustache
    }

    @GetMapping("/bye")
    public String seeYouNext(Model model){
        model.addAttribute("nickname","jw");
        return "goodbye";
    }
    @GetMapping("/dum")
    public String dum(Model modle){
        return "dum.html";
    }

    @PostMapping("/dum/input")
    public String create(DumForm form){
        Dum dum=form.toEntity();
        Dum saved=dumRepository.save(dum);
        System.out.println(saved.toString());
        return "";
    }
}