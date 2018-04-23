package com.pshenmic.mapstruct;

import com.pshenmic.domain.Product;
import com.pshenmic.model.dto.ProductDTO;
import com.pshenmic.service.QRCodeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = QRCodeService.class)
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "price", target = "price"),
            @Mapping(target = "qrCodeBase64", expression = "java(qRCodeService.generateCodeFromProductId(product.getId()))"),
            @Mapping(source = "currency", target = "currency")
    })
    ProductDTO toDTO(Product product);
}
