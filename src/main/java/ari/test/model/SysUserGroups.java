/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author ari-prasetiyo
 */
@Entity
@Table(name = "sys_user_groups")
public class SysUserGroups extends ModelEntity {
    
    private static final long serialVersionUID = 1L;
    
    @Column(length = 15, nullable = false, name = "groups_name")
    public String groupsName;

    public String getGroupsName() {
        return groupsName;
    }

    public void setGroupsName(String groupsName) {
        this.groupsName = groupsName;
    }
    
}
