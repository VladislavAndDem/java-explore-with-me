package main.server.request.service;

import main.server.request.dto.EventRequestStatusUpdateRequestDto;
import main.server.request.dto.EventRequestStatusUpdateResultDto;
import main.server.request.dto.ParticipationRequestDto;

import java.util.List;

public interface RequestService {
    ParticipationRequestDto createRequest(Long requesterId, Long eventId);

    ParticipationRequestDto cancelRequest(Long requesterId, Long requestId);

    List<ParticipationRequestDto> getRequests(Long requesterId);

    List<ParticipationRequestDto> getCurrentUserEventRequests(Long initiatorId, Long eventId);

    EventRequestStatusUpdateResultDto updateParticipationRequestsStatus(Long initiatorId, Long eventId,
                                                                        EventRequestStatusUpdateRequestDto eventRequestStatusUpdateRequestDto);
}
