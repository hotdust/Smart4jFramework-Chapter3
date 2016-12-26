package org.smart4j.chapter3;

import org.smart4j.framework.helper.DatabaseHelper;
import org.smart4j.plugin.security.SmartSecurity;

import java.util.Set;

/**
 * Created by shijiapeng on 16/12/25.
 */
public class AppSecurity implements SmartSecurity {

    public String getPassword(String username) {
        String sql = "SELECT password FROM user WHERE username = ?";
        return DatabaseHelper.query(sql, username);
    }

    public Set<String> getRoleNameSet(String username) {
        String sql = "SELECT role_name FROM user u, role r, user_role ur WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
        return DatabaseHelper.querySet(sql, username);
    }
//    public Set<String> getRoleNameSet(String username) {
//        String sql = "SELECT role_name FROM user u, role r, user_role ur WHERE u.id = ur.user_id AND r.id = ur.role_id AND u.username = ?";
//        return DatabaseHelper.query(sql, username);
//    }

    public Set<String> getPermissionNameSet(String roleName) {
        String sql = "SELECT permission_name FROM permission p, role r, role_permission rp WHERE r.id = rp.role_id AND rp.permission_id = p.id AND r.role_name = ?";
        return DatabaseHelper.querySet(sql, roleName);
    }
}
