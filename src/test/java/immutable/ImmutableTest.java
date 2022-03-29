package immutable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static immutable.Role.Builder.role;
import static immutable.User.Builder.user;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ImmutableTest {

    @Test
    public void alwaysCanFindExistingDataByUser() {
        // given
        final var map = new HashMap<User, String>();
        final var role = role().name("admin").permissions(new HashSet<>()).build();
        final var key = user().userName("name").roles(Set.of(role)).build();
        map.put(key, "some data");

        // when
        final var data = map.get(key);
        // Never can we modify an immutable field
        assertThatThrownBy(() -> role.getPermissions().add("new permission")).isInstanceOf(UnsupportedOperationException.class);
        final var dataAfterSomeTime = map.get(key);

        // then
        assertThat(data).isEqualTo("some data");
        assertThat(dataAfterSomeTime).isEqualTo("some data");
    }

}