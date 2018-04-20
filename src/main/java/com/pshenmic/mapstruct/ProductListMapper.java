package com.pshenmic.mapstruct;

import com.pshenmic.domain.Product;
import com.pshenmic.model.dto.ProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = ProductMapper.class)
public interface ProductListMapper {


    List<ProductDTO> toDTO(List<Product> products);
}
