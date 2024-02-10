package adapters.out.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "offered_services")
@Entity
public class OfferedServiceEntity {
  @Id private UUID id;
  private String name;
  private String description;
  private BigDecimal price;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private CompanyEntity company;
}
