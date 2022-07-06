package com.andreanbuhchev.bulgarian_racing_community.web;
import com.andreanbuhchev.bulgarian_racing_community.service.ArticleService;
import com.andreanbuhchev.bulgarian_racing_community.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/articles")
public class ArticleController {


    @GetMapping()
    public String articles(){
        return "articles";
    }




}
