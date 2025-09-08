package main.server.compilation.pagination;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Validated
@Getter
@Setter
public class PaginationOffset {
    @PositiveOrZero
    private Integer from;

    @Positive
    private Integer size;
}
