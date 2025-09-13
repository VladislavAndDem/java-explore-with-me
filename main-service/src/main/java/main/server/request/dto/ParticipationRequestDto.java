package main.server.request.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import main.server.request.model.RequestStatus;

import java.time.LocalDateTime;

import static stat.constant.Const.DATE_TIME_WITH_MILLIS_FORMAT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ParticipationRequestDto {
    Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_TIME_WITH_MILLIS_FORMAT)
    LocalDateTime created;

    @JsonProperty("event")
    Long eventId;

    @JsonProperty("requester")
    Long requesterId;

    RequestStatus status;
}
