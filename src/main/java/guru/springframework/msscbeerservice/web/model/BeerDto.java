package guru.springframework.msscbeerservice.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BeerDto {
    private UUID id;
    private Integer version, qtyOnHand;
    private OffsetDateTime createdDate, lastModifiedDate;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private Long upc;
    private BigDecimal price;
}
