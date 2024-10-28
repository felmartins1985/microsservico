package br.com.curso_udemy.product_api.modules.product.dto;

import br.com.curso_udemy.product_api.modules.category.dto.CategoryResponse;
import br.com.curso_udemy.product_api.modules.supplier.dto.SupplierResponse;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {
    private Integer supplierId;
    private String name;
    @JsonProperty("quantity_availabe")
    private Integer quantityAvailable;
    private Integer categoryId;
    public String getName() {
        return name;
    }




}
