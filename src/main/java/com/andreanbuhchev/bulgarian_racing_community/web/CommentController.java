package com.andreanbuhchev.bulgarian_racing_community.web;

import com.andreanbuhchev.bulgarian_racing_community.model.dto.CommentDto;
import com.andreanbuhchev.bulgarian_racing_community.service.CommentService;
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

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/add")
    public String addComment(Model model) {
        if (!model.containsAttribute("addCommentModel")) {
            model.addAttribute("addCommentModel", new CommentDto());
        }

        return "add-comment";
    }

    @PostMapping("/{id}/add")
    public String addComment(@Valid CommentDto addCommentModel,
                             @PathVariable Long id,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             @AuthenticationPrincipal UserDetails userDetails) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addCommentModel", addCommentModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addCommentModel",
                    bindingResult);
            return "redirect:/add-comment";
        }

        commentService.addComment(addCommentModel, userDetails,id);

        return "redirect:/articles";
    }

    @PostMapping("/{id}/delete")
    public void deleteComment(@PathVariable Long id,UserDetails userDetails){
        commentService.deleteComment(id,userDetails);
    }

}
