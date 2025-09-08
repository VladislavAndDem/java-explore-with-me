package main.server.compilation.model;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import main.server.events.model.EventModel;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compilations")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Compilation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull(message = "Pinned должен быть указан")
    private Boolean pinned;

    @Column
    @NotBlank(message = "Заголовок не должен быть пустым")
    @Size(max = 50, message = "Заголовок не должен превышать 255 символов")
    private String title;

    @ManyToMany
    @JoinTable(
            name = "compilation_event",
            joinColumns = @JoinColumn(name = "compilation_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    @Builder.Default
    @NotNull(message = "Список событий не должен быть null")
    @Valid
    private Set<EventModel> events = new HashSet<>();
}