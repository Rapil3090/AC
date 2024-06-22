package AC.service;

import AC.domain.Expense;
import AC.dto.create.CreateExpenseDTO;
import AC.repository.ExpenseRepository;
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


}
