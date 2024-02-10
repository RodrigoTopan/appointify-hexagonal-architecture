package domain.entity.valueobject;

import domain.common.exception.DomainException;
import static org.springframework.util.ObjectUtils.isEmpty;

public class Password {
    private final String value;

    public Password(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainException("invalid password");
        }
    }

    public String getValue() {
        return value;
    }
}
