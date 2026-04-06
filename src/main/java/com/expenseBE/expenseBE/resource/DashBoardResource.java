package com.expenseBE.expenseBE.resource;

import com.expenseBE.expenseBE.Enitty.Activity;
import com.expenseBE.expenseBE.Enitty.Budget;
import com.expenseBE.expenseBE.Enitty.Category;
import com.expenseBE.expenseBE.Enitty.Income;
import com.expenseBE.expenseBE.repository.ActivityRepository;
import com.expenseBE.expenseBE.repository.BudgetRepository;
import com.expenseBE.expenseBE.repository.CategoryRepository;
import com.expenseBE.expenseBE.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class DashBoardResource {

    @Autowired
    private IncomeRepository incomeRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BudgetRepository budgetRepository;
    @Autowired
    private ActivityRepository activityRepository;

    @GetMapping("/income")
    public List<Income> getAll() {
        List<Income> list = incomeRepository.findAll();
        return list;
    }

    @GetMapping("/category")
    public List<Category> getAllCategory() {
        List<Category> list = categoryRepository.findAll();
        return list;
    }

    @GetMapping("/budget")
    public List<Budget> getAllBudget() {
        List<Budget> list = budgetRepository.findAll();
        return list;
    }

    @GetMapping("/activity")
    public List<Activity> getAllActivity() {
        List<Activity> list = activityRepository.findAll();
        return list;
    }
}
