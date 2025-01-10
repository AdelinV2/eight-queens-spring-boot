package com.eightqueens.eight_queens.controller;

import com.eightqueens.eight_queens.service.SolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SolutionController {

    private final SolutionService solutionService;

    @Autowired
    public SolutionController(SolutionService solutionService) {
        this.solutionService = solutionService;
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/solution?index=0";
    }

    @GetMapping("/solution")
    public String solution(@RequestParam int index, Model model) {

        if (index < 0 || index >= solutionService.getSolutionCount()) {
            index = 0;
        }

        model.addAttribute("solution", solutionService.getSolutionByIndex(index));
        model.addAttribute("currentSolution", index);
        model.addAttribute("solutionCount", solutionService.getSolutionCount());

        return "index";
    }
}
