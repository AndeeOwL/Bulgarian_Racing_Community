package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.ArticleDto;
import com.andreanbuhchev.bulgarian_racing_community.model.view.ArticleView;
import com.andreanbuhchev.bulgarian_racing_community.service.ArticleService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/articles")
public class ArticleController {

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }


    @GetMapping()
    public String allArticles(Model model) {


        List<ArticleView> articles = articleService.findAllArticles();

        model.addAttribute("allArticles", articles);
        return "articles";
    }

    @GetMapping("/add")
    public String addArticle(Model model) {
        if (!model.containsAttribute("addArticleModel")) {
            model.addAttribute("addArticleModel", new ArticleDto());
        }

        return "add-article";
    }

    @PostMapping("/add")
    public String addArticle(@Valid ArticleDto addArticleModel,
                             @AuthenticationPrincipal UserDetails userDetails,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes
                           ) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addArticleModel", addArticleModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addArticleModel",
                    bindingResult);
            return "redirect:/articles/add";  //TODO ARTICLES THROWING ERROR WHEN ADDED WITH EMPTY FIELDS
        }

        articleService.addArticle(addArticleModel, userDetails);

        return "redirect:/articles";
    }


    @GetMapping("/delete/{id}")
    public String deleteArticle(@PathVariable("id") Long articleId){

        articleService.deleteArticle(articleId);

        return "redirect:/home";
    }

    //TODO EDIT FETCH FOR COMMENTS NOT WORKING
    //TODO BUTTON ARTICLES NOT DROPPING DOWN AT FIRST




}
