package AC.service;

import AC.domain.Expense;
import AC.dto.create.CreateExpenseDTO;

public interface ExpenseService {


    Expense createExpense(CreateExpenseDTO.Request request);

}
