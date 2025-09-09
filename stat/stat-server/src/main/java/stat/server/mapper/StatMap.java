package stat.server.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import stat.dto.EndpointHitDto;
import stat.server.model.EndpointHit;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StatMap {

    @Mapping(target = "id", ignore = true)
    EndpointHit toEndpointHit(EndpointHitDto endpointHitDto);

    @Mapping(source = "id", target = "id")
    EndpointHitDto toEndpointHitDto(EndpointHit endpointHit);
}