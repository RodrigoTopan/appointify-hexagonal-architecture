package domain.valueobject;

import domain.common.exception.DomainException;
import domain.common.exception.DomainValidationException;
import static org.springframework.util.ObjectUtils.isEmpty;

public class Username {
    private final String value;

    public Username(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainValidationException("invalid username");
        }
    }

    public String getValue() {
        return value;
    }
}
