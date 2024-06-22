package AC.service;

import AC.domain.Expense;
import AC.dto.ExpenseDTO;
import AC.dto.create.CreateExpenseDTO;
import AC.dto.update.UpdateExpenseDTO;
import AC.exception.ExpenseException;
import AC.repository.ExpenseRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;


    public Expense createExpense(CreateExpenseDTO.Request request) {

        return expenseRepository.save(Expense.builder()
                .year(request.getYear())
                .month(request.getMonth())
                .day(request.getDay())
                .amount(request.getAmount())
                .memo(request.getMemo())
                .type(request.getType())
                .category(request.getCategory())
                .build());
    }

    public ExpenseDTO getExpenseById(Long expenseId) {

        Expense expense = expenseRepository.findById(expenseId).orElseThrow(
                () -> new ExpenseException(ErrorCode.EXPENSE_NOT_FOUND));

        return new ExpenseDTO(expense);
    }

    public Expense updateExpenseById(UpdateExpenseDTO.Request request) {

        Expense expense = expenseRepository.findById(request.getId()).orElseThrow(
                () -> new ExpenseException(ErrorCode.EXPENSE_NOT_FOUND));

        expense.setYear(request.getYear());
        expense.setMonth(request.getMonth());
        expense.setDay(request.getDay());
        expense.setAmount(request.getAmount());
        expense.setType(request.getType());
        expense.setCategory(request.getCategory());
        expense.setMemo(request.getMemo());

        return expenseRepository.save(expense);
    }
}
