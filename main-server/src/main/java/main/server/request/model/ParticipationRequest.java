package main.server.request.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;
import main.server.events.model.EventModel;
import main.server.user.model.User;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "participation_request")
public class ParticipationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @CreatedDate
    @Column(name = "created", updatable = false)
    @NotNull(message = "Дата создания не может быть пустой")
    LocalDateTime created;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    @NotNull(message = "Event не может быть пустым")
    EventModel event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id")
    @NotNull(message = "Requester не может быть пустым")
    User requester;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    @NotNull(message = "Статус не может быть пустым")
    RequestStatus status;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParticipationRequest request = (ParticipationRequest) o;
        if (request.id != null && id != null) {
            return id.equals(request.id);
        }
        return Objects.equals(created, request.created) &&
                Objects.equals(event, request.event) &&
                Objects.equals(requester, request.requester) &&
                status == request.status;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : Objects.hash(created, event, requester, status);
    }
}