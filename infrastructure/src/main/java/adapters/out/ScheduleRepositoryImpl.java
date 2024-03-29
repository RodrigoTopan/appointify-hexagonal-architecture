package adapters.out;

import adapters.out.postgres.jpa.ScheduleJpaRepository;
import adapters.out.postgres.mapper.ScheduleDataAccessMapper;
import entity.Schedule;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ports.output.repository.ScheduleRepository;

@Component
@RequiredArgsConstructor
public class ScheduleRepositoryImpl implements ScheduleRepository {
  private final ScheduleJpaRepository scheduleJpaRepository;

  @Override
  public Schedule save(Schedule schedule) {
    var entity = ScheduleDataAccessMapper.toEntity(schedule);
    var savedEntity = scheduleJpaRepository.save(entity);
    return ScheduleDataAccessMapper.toDomain(savedEntity);
  }

  @Override
  public List<Schedule> findAll() {
    return scheduleJpaRepository.findAll().stream()
        .map(ScheduleDataAccessMapper::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Schedule findById(UUID id) {
    var entity = scheduleJpaRepository.findById(id);
    return entity.map(ScheduleDataAccessMapper::toDomain).orElse(null);
  }

  @Override
  public List<Schedule> findByCustomerId(UUID id) {
    var entities = scheduleJpaRepository.findByCustomerId(id);
    return entities.stream().map(ScheduleDataAccessMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Schedule> findByEmployeeId(UUID id) {
    var entities = scheduleJpaRepository.findByEmployeeId(id);
    return entities.stream().map(ScheduleDataAccessMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public List<Schedule> findAllByAvailableStatusAndCompanyIdAndDate(
      UUID companyId, Date startDate, Date endDate) {
    var entities =
        scheduleJpaRepository.findAllByAvailableStatusAndCompanyId(
            companyId); // findAllByAvailableStatusAndCompanyId
    return entities.stream().map(ScheduleDataAccessMapper::toDomain).collect(Collectors.toList());
  }

  @Override
  public void deleteById(UUID id) {
    scheduleJpaRepository.deleteById(id);
  }
}
