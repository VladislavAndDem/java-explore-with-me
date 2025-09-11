package main.server.category.controller;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import main.server.category.dto.CategoryDto;
import main.server.category.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Slf4j
public class PublicCategoryController {

    CategoryService categoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getCategories(@PositiveOrZero
                                           @RequestParam(name = "from", defaultValue = "0")
                                           Integer from,

                                           @Positive
                                           @RequestParam(name = "size", defaultValue = "10")
                                           Integer size) {
        log.info("Получение списка категорий");
        log.debug("Поступил запрос на получение списка категорий, параметры запроса: {}, {}", from, size);
        return categoryService.getCategories(from, size);
    }

    @GetMapping("/{catId}")
    @ResponseStatus(HttpStatus.OK)
    public CategoryDto getCategory(@PathVariable Long catId) {
        log.info("Получение категории");
        log.debug("Поступил запрос на получение категории с id: {}", catId);
        return categoryService.getCategory(catId);
    }
}
