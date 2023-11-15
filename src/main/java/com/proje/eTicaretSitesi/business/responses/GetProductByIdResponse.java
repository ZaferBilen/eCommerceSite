package com.proje.eTicaretSitesi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetProductByIdResponse {

	private String categoryName;
	private long id;
	private String name;
 	private int price;
}
