package immutable;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class Role {

    private final String name;
    private final Set<String> permissions;

    public Role(Builder builder) {
        this.name = builder.name;
        this.permissions = builder.permissions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(name, role.name) && Objects.equals(permissions, role.permissions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, permissions);
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public static class Builder {

        private String name;
        private Set<String> permissions;

        public static Builder role() {
            return new Builder();
        }

        public Role build() {
            return new Role(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder permissions(Set<String> permissions) {
            this.permissions = Collections.unmodifiableSet(permissions);
            return this;
        }
    }

}
