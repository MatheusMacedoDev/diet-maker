package util;

import java.util.Objects;

public abstract class ValueObject {

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (object == null || getClass() != object.getClass())
            return false;

        return Objects.equals(this, object);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEqualityComponents());
    }

    protected abstract Object getEqualityComponents();
}
