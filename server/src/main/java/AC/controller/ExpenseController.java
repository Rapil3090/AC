package AC.controller;

import AC.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ExpenseController {

    private final ExpenseService expenseService;


}
