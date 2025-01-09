package com.eightqueens.eight_queens.controller;

import com.eightqueens.eight_queens.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/solution")
public class SolutionController {

    private final SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping
    public String getSolution(@RequestParam(defaultValue = "0") int index, Model model) {
        if (index < 0 || index >= solutionService.getSolutionCount()) {
            return "redirect:/solution?index=0";
        }

        // TODO add solution to model

        return "index";
    }
}
