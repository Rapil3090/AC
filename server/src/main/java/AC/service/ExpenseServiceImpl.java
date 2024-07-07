package AC.service;

import AC.domain.Expense;
import AC.domain.User;
import AC.dto.ExpenseDTO;
import AC.dto.create.CreateExpenseDTO;
import AC.dto.get.GetUserIdByYearAndMonth;
import AC.dto.update.UpdateExpenseDTO;
import AC.exception.ExpenseException;
import AC.exception.UserException;
import AC.repository.ExpenseRepository;
import AC.repository.UserRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    public Expense createExpense(CreateExpenseDTO.Request request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        String formattedMonth = String.format("%02d", Integer.parseInt(request.getMonth()));

        return expenseRepository.save(Expense.builder()
                .user(user)
                .year(request.getYear())
                .month(formattedMonth)
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

    public void deleteExpenseById(Long expenseId) {

        expenseRepository.findById(expenseId).orElseThrow(
                () -> new ExpenseException(ErrorCode.EXPENSE_NOT_FOUND));

        expenseRepository.deleteById(expenseId);
    }

    public List<ExpenseDTO> getUserIdByYearAndMonth(GetUserIdByYearAndMonth request) {

        List<Expense> expenseList = expenseRepository.findByUserIdAndYearAndMonth(request.getUserId(), request.getYear(), request.getMonth());

        return expenseList.stream()
                .map(ExpenseDTO::new)
                .collect(Collectors.toList());

    }
}
