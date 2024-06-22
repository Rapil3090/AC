package AC.controller;

import AC.dto.ExpenseDTO;
import AC.dto.create.CreateExpenseDTO;
import AC.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;


    @PostMapping("/expense")
    public ResponseEntity<CreateExpenseDTO.Response> createExpense(
            @Valid @RequestBody CreateExpenseDTO.Request request) {

        return ResponseEntity.ok(CreateExpenseDTO.Response.from(
                expenseService.createExpense(request)));
    }

    @GetMapping("/expense")
    public ResponseEntity<ExpenseDTO> getExpenseById(
            @RequestParam("expenseId") Long expenseId) {

        return ResponseEntity.ok(expenseService.getExpenseById(expenseId));
    }
}
