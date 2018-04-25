package com.pshenmic.mapstruct;

import com.pshenmic.domain.Product;
import com.pshenmic.model.dto.ProductDTO;
import com.pshenmic.service.QRCodeService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = QRCodeService.class)
public abstract class ProductMapper {

    @Autowired
    private QRCodeService qrCodeService;

    //Overriding because mapstruct went real mad with service injection. Bugging as fuck
    public ProductDTO toDTO(Product product) {
        if (product == null) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setCurrency(product.getCurrency());
        productDTO.setPrice(product.getPrice());
        productDTO.setQrCodeBase64(qrCodeService.generateCodeFromProductId(product.getId()));

        return productDTO;
    }
}
