package main.server.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import main.server.request.dto.ParticipationRequestDto;
import main.server.request.service.RequestService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users/{userId}/requests")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class PrivateRequestController {
    RequestService requestService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ParticipationRequestDto> getRequests(@PathVariable("userId") @NotNull @Positive Long requesterId) {
        log.info("Получаем запросы");
        return requestService.getRequests(requesterId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParticipationRequestDto createRequest(@PathVariable("userId") @NotNull @Positive Long requesterId,
                                                 @RequestParam("eventId") @NotNull @Positive Long eventId) {
        log.info("Создаем запрос id={}", requesterId);
        return requestService.createRequest(requesterId, eventId);
    }

    @PatchMapping("/{requestId}/cancel")
    @ResponseStatus(HttpStatus.OK)
    public ParticipationRequestDto cancelRequest(@PathVariable("userId") @NotNull @Positive Long requesterId,
                                                 @PathVariable("requestId") @NotNull @Positive Long requestId) {
        log.info("Отменяем запрос");
        return requestService.cancelRequest(requesterId, requestId);
    }

}