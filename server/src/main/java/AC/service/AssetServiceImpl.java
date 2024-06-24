package AC.service;

import AC.domain.Asset;
import AC.domain.Expense;
import AC.domain.Income;
import AC.dto.AssetDTO;
import AC.exception.AssetException;
import AC.repository.AssetRepository;
import AC.repository.ExpenseRepository;
import AC.repository.IncomeRepository;
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


    public AssetDTO getAsset(Long expenseId, Long incomeId, Long assetId) {

        Asset asset = assetRepository.findById(assetId).orElseThrow(
                () -> new AssetException(ErrorCode.ASSET_NOT_FOUND));

        LocalDate today = LocalDate.now();
        String year = String.valueOf(today.getYear());
        String month = String.format("%02d", today.getMonthValue());


        List<Income> monthlyIncome = incomeRepository.findByIncomeIdAndYearAndMonth(incomeId, year, month);
        Long totalIncomeAmount = monthlyIncome.stream()
                .mapToLong(Income::getAmount)
                .sum();

        List<Expense> monthlyExpense = expenseRepository.findByExpenseIdAndYearAndMonth(expenseId, year, month);
        Long totalExpenseAmount = monthlyExpense.stream()
                .mapToLong(Expense::getAmount)
                .sum();




        return new AssetDTO(asset, (totalIncomeAmount-totalExpenseAmount));

    }
}
