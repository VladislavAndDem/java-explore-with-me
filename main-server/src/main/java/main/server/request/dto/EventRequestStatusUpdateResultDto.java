package main.server.request.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRequestStatusUpdateResultDto {
    @Builder.Default
    List<ParticipationRequestDto> confirmedRequests = new ArrayList<>();

    @Builder.Default
    List<ParticipationRequestDto> rejectedRequests = new ArrayList<>();
}