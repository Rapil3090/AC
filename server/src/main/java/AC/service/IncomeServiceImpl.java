package AC.service;

import AC.domain.Income;
import AC.dto.create.CreateIncome;
import AC.repository.IncomeRepository;
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
                        .type(request.getType())
                        .category(request.getCategory())
                        .build());
    }

}
