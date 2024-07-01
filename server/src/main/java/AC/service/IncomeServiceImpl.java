package AC.service;

import AC.domain.Income;
import AC.domain.User;
import AC.dto.IncomeDTO;
import AC.dto.create.CreateIncomeDTO;
import AC.dto.delete.DeleteDTO;
import AC.dto.get.GetCategoryDTO;
import AC.dto.update.UpdateIncomeDTO;
import AC.exception.IncomeException;
import AC.exception.UserException;
import AC.repository.IncomeRepository;
import AC.repository.UserRepository;
import AC.type.Category;
import AC.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final IncomeRepository incomeRepository;
    private final UserRepository userRepository;

    public Income createIncome(CreateIncomeDTO.Request request) {

        User user = userRepository.findById(request.getUserId()).orElseThrow(
                () -> new UserException(ErrorCode.USER_NOT_FOUND));

        String formattedMonth = String.format("%02d", Integer.parseInt(request.getMonth()));

        return incomeRepository.save(
                Income.builder()
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

    public IncomeDTO getIncomeById(Long incomeId) {

        Income income = incomeRepository.findById(incomeId).orElseThrow(
                () -> new IncomeException(ErrorCode.INCOME_NOT_FOUND));

        return new IncomeDTO(income);
    }

    public Income UpdateIncomeById(UpdateIncomeDTO.Request request) {

        Income income = incomeRepository.findById(request.getId()).orElseThrow(
                () -> new IncomeException(ErrorCode.INCOME_NOT_FOUND));

        income.setYear(request.getYear());
        income.setMonth(request.getMonth());
        income.setDay(request.getDay());
        income.setType(request.getType());
        income.setCategory(request.getCategory());
        income.setMemo(request.getMemo());

        return incomeRepository.save(income);
    }

    public void deleteIncomeById(Long incomeId) {

        incomeRepository.findById(incomeId).orElseThrow(
                ()-> new IncomeException(ErrorCode.INCOME_NOT_FOUND));

        incomeRepository.deleteById(incomeId);
    }

    public List<IncomeDTO> getUserIdByCategory(GetCategoryDTO request) {

        List<Income> incomeList = incomeRepository.findByUserIdAndCategory(request.getUserId(), request.getCategory());

        return incomeList.stream()
                .map(IncomeDTO::new)
                .collect(Collectors.toList());
    }

}
