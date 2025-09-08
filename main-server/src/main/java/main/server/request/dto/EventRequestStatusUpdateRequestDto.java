package main.server.request.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import main.server.request.model.RequestStatus;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class EventRequestStatusUpdateRequestDto {
    List<Long> requestIds;
    RequestStatus status;
}

