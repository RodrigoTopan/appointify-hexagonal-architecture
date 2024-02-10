package domain.valueobject;

import java.util.Date;

public class ScheduleDate {
    private final Date start;
    private final Date end;

    public ScheduleDate(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public boolean overlaps(ScheduleDate other) {
        return this.start.before(other.end) && other.start.before(this.end);
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }
}
