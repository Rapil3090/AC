package AC.service;

import AC.domain.Income;
import AC.dto.IncomeDTO;
import AC.dto.create.CreateIncome;
import AC.exception.IncomeException;
import AC.repository.IncomeRepository;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;


    public Income createIncome(CreateIncome.Request request) {

        return incomeRepository.save(
                Income.builder()
                        .year(request.getYear())
                        .month(request.getMonth())
                        .day(request.getDay())
                        .amount(request.getAmount())
                        .memo(request.getMemo())
                        .type(request.getType())
                        .category(request.getCategory())
                        .build());
    }

    public IncomeDTO getIncomeById(Long incomeId) {

        Income income = incomeRepository.findById(incomeId).orElseThrow(
                () -> new IncomeException(ErrorCode.INCOME_NOT_FOUND));

        return new IncomeDTO(income);
    }

}
