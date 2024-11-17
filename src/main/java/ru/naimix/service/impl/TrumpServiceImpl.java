package ru.naimix.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.naimix.domain.entity.Trump;
import ru.naimix.mapper.UserMapper;
import ru.naimix.model.TrumpResponse;
import ru.naimix.model.TrumpUserResponse;
import ru.naimix.model.TrumpsResponse;
import ru.naimix.repository.TrumpRepository;
import ru.naimix.service.TrumpService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrumpServiceImpl implements TrumpService {
    private final TrumpRepository trumpRepository;
    private final UserMapper userMapper;

    @Override
    public TrumpsResponse getAllTrumps() {
        List<Trump> trumpsFromRepository = trumpRepository.findAll();

        List<TrumpUserResponse> trumpUserResponses = trumpsFromRepository.stream().map(trump -> {
            TrumpUserResponse trumpUserResponse = new TrumpUserResponse();
            trumpUserResponse.setId(trump.getId());
            trumpUserResponse.setScore(trump.getScore());
            if (trump.getUserTo() != null && trump.getUserFrom() != null) {
                trumpUserResponse.setUsers(List.of(userMapper.toUserDto(trump.getUserTo()), userMapper.toUserDto(trump.getUserFrom())));
            } else {
                trumpUserResponse.setUsers(List.of(userMapper.toUserDto(trump.getUserTo())));
            }
            return trumpUserResponse;
        }).toList();

        TrumpsResponse trumpResponse = new TrumpsResponse();
        trumpResponse.setContent(trumpUserResponses);
        return trumpResponse;
    }
}
