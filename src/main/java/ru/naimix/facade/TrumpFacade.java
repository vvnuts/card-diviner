package ru.naimix.facade;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.model.TrumpRequest;
import ru.naimix.model.TrumpResponse;
import ru.naimix.service.CompanyService;
import ru.naimix.service.UserService;
import ru.naimix.util.ScoreUtil;

@Service
@RequiredArgsConstructor
public class TrumpFacade {
    private final UserService userService;
    private final CompanyService companyService;
    private final ScoreUtil scoreUtil;

    public TrumpResponse create(TrumpRequest trumpRequest) {
        return trumpRequest.getIsCompany()
                ? processCreateTrumpWithCompany(trumpRequest)
                : processCreateTrumpWithoutCompany(trumpRequest);
    }

    private TrumpResponse processCreateTrumpWithCompany(TrumpRequest trumpRequest) {
        var userIdFromRequest = trumpRequest.getTargetToId();
        var userFromRepository = userService.getById(userIdFromRequest);
        return null;
    }

    private TrumpResponse processCreateTrumpWithoutCompany(TrumpRequest trumpRequest) {
        return null;
    }
}
