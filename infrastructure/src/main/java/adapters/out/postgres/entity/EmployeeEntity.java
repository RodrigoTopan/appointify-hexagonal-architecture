package adapters.out.postgres.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employees")
@Entity
public class EmployeeEntity {
  @Id
  @Column(name = "id")
  @EqualsAndHashCode.Include
  private UUID id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private CompanyEntity company;

  @OneToMany(cascade = {CascadeType.REFRESH})
  @JoinColumn
  private List<ScheduleEntity> scheduleEntities = new ArrayList<>();

  @OneToMany(cascade = {CascadeType.REFRESH})
  @JoinColumn
  private List<EvaluationEntity> evaluations = new ArrayList<>();
}
