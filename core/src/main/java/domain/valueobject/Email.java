package domain.valueobject;

import domain.common.exception.DomainException;
import domain.common.exception.DomainValidationException;
import static org.springframework.util.ObjectUtils.isEmpty;

public class Email {
    private String value;

    public Email(String value) {
        validate(value);
        this.value = value;
    }

    void validate(String value) {
        if (isEmpty(value)) {
            throw new DomainValidationException("invalid email");
        }
    }

    public String getValue() {
        return value;
    }
}
