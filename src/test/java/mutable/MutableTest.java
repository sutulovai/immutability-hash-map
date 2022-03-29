package mutable;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class MutableTest {

    @Test
    public void cantFindExistingDataByUser() {
        // given
        final var map = new HashMap<User, String>();
        final var role = new Role("admin", new HashSet<>());
        final var key = new User("name", Set.of(role));
        map.put(key, "some data");

        // when
        final var data = map.get(key);
        // Here we modify role's permissions, it can happen somewhere far away where we don't remember that user is a key in HashMap
        role.getPermissions().add("new permission");
        final var dataAfterSomeTime = map.get(key);

        // then
        assertThat(data).isEqualTo("some data");
        assertThat(dataAfterSomeTime).isNull();
    }

}
