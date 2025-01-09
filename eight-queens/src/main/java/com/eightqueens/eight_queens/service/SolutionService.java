package com.eightqueens.eight_queens.service;

import com.eightqueens.eight_queens.model.Solution;
import com.eightqueens.eight_queens.util.SolutionGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolutionService {

    private final SolutionGenerator generator = new SolutionGenerator();
    private List<Solution> solutions;

    public SolutionService() {
        solutions = generator.getSolutions();
    }

    public Solution getSolutionByIndex(int index) {
        return solutions.get(index);
    }

    public Integer getSolutionCount() {
        return solutions.size();
    }
}
