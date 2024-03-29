package adapters.out.postgres.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
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
@Table(name = "customers")
@Entity
public class CustomerEntity {
  @Id private UUID id;

  @OneToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @OneToMany(cascade = {CascadeType.REFRESH})
  @JoinColumn
  private List<ScheduleEntity> schedules = new ArrayList<>();

  @OneToMany(cascade = {CascadeType.REFRESH})
  @JoinColumn
  private List<EvaluationEntity> evaluations = new ArrayList<>();
}
