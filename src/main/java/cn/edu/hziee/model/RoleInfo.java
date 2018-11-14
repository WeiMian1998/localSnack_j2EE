package cn.edu.hziee.model;

import java.io.Serializable;

/**
 * role_info
 * @author 
 */
public class RoleInfo implements Serializable {
    private Integer roleId;

    private String roleAccount;

    private String roleName;

    private String rolePassword;

    private static final long serialVersionUID = 1L;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleAccount() {
        return roleAccount;
    }

    public void setRoleAccount(String roleAccount) {
        this.roleAccount = roleAccount;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRolePassword() {
        return rolePassword;
    }

    public void setRolePassword(String rolePassword) {
        this.rolePassword = rolePassword;
    }
}