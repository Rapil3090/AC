package AC.service;

import AC.domain.Expense;
import AC.dto.ExpenseDTO;
import AC.dto.create.CreateExpenseDTO;
import AC.dto.update.UpdateExpenseDTO;

public interface ExpenseService {


    Expense createExpense(CreateExpenseDTO.Request request);

    ExpenseDTO getExpenseById(Long expenseId);

    Expense updateExpenseById(UpdateExpenseDTO.Request request);
}
