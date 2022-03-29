package immutable;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

public class User {

    private final String userName;
    private final Set<Role> roles;

    public User(Builder builder) {
        this.userName = builder.userName;
        this.roles = builder.roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userName, user.userName) && Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, roles);
    }

    public static class Builder {

        private String userName;
        private Set<Role> roles;

        public static Builder user() {
            return new Builder();
        }

        public User build() {
            return new User(this);
        }

        public Builder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public Builder roles(Set<Role> roles) {
            this.roles = Collections.unmodifiableSet(roles);
            return this;
        }
    }

}
