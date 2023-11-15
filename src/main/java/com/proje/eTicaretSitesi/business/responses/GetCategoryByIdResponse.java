package com.proje.eTicaretSitesi.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetCategoryByIdResponse {
	private long id;
	private String name;
}
