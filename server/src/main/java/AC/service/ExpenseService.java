package AC.service;

import AC.domain.Expense;
import AC.dto.ExpenseDTO;
import AC.dto.create.CreateExpenseDTO;

public interface ExpenseService {


    Expense createExpense(CreateExpenseDTO.Request request);

    ExpenseDTO getExpenseById(Long expenseId);
}
