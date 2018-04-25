package com.pshenmic.mapstruct;

import com.pshenmic.domain.OperationPrice;
import com.pshenmic.model.dto.OperationPriceDTO;
import com.pshenmic.service.QRCodeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = QRCodeService.class)
public interface OperationPriceMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "btcPrice", target = "btcPrice"),
            @Mapping(source = "fiatRate", target = "fiatRate"),
            @Mapping(source = "currency", target = "currency")
    })
    OperationPriceDTO toDTO(OperationPrice operationPrice);
}
