package AC.service;

import AC.domain.Asset;
import AC.domain.Expense;
import AC.domain.Income;
import AC.domain.User;
import AC.dto.AssetDTO;
import AC.exception.AssetException;
import AC.exception.UserException;
import AC.repository.AssetRepository;
import AC.repository.ExpenseRepository;
import AC.repository.IncomeRepository;
import AC.repository.UserRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    private final AssetRepository assetRepository;
    private final ExpenseRepository expenseRepository;
    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;


    public AssetDTO getAsset(Long userId) {

        userRepository.findById(userId).orElseThrow(
                ()-> new UserException(ErrorCode.USER_NOT_FOUND));

        LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        String month = String.format("%02d", today.getMonthValue());

        List<Income> monthlyIncome = incomeRepository.findByUserIdAndYearAndMonth(userId, year, month);
        Long totalIncomeAmount = monthlyIncome.stream()
                .mapToLong(Income::getAmount)
                .sum();

        List<Expense> monthlyExpense = expenseRepository.findByUserIdAndYearAndMonth(userId, year, month);
        Long totalExpenseAmount = monthlyExpense.stream()
                .mapToLong(Expense::getAmount)
                .sum();

        return new AssetDTO((totalIncomeAmount - totalExpenseAmount));
    }
}
