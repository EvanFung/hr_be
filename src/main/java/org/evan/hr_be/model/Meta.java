package org.evan.hr_be.model;

/**
 * @Author Evan Feng
 * @Date 17/8/2023
 * @Github https://github.com/EvanFung
 */
public class Meta {
    private Boolean keepAlive;

    private Boolean requireAuth;

    public Boolean getKeepAlive() {
        return keepAlive;
    }

    public Boolean getRequireAuth() {
        return requireAuth;
    }

    public void setKeepAlive(Boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public void setRequireAuth(Boolean requireAuth) {
        this.requireAuth = requireAuth;
    }
}
