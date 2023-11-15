package com.proje.eTicaretSitesi.business.requests;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequest {

    private long id;
	private long categoryId;
	private String name;
	@Min(value = 10)
	private int price;
}
