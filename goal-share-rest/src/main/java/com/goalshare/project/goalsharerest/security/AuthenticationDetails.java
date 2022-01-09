package com.goalshare.project.goalsharerest.security;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Getter
@RequiredArgsConstructor
public class AuthenticationDetails {

    /**
     * The User id.
     */
    private final Long userId;
    /**
     * The Is admin.
     */
    private final boolean isAdmin;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AuthenticationDetails details = (AuthenticationDetails) o;

        if (isAdmin != details.isAdmin) {
            return false;
        }
        return Objects.equals(userId, details.userId);
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (isAdmin ? 1 : 0);
        return result;
    }
}
