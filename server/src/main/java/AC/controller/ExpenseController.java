package AC.controller;

import AC.dto.create.CreateExpenseDTO;
import AC.service.ExpenseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
