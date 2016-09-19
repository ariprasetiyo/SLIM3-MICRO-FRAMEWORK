/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ari.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sys_user")
public class SysUser extends ModelEntity {

    private static final long serialVersionUID = 1L;
    
    @ManyToOne
    @JoinColumn(name = "id_user_groups", nullable = false)
    public SysUserGroups sysUserGroups;
    @Column(length = 100, nullable = false)
    public String name;

    public SysUserGroups getSysUserGroups() {
        return sysUserGroups;
    }

    public void setSysUserGroups(SysUserGroups sysUserGroups) {
        this.sysUserGroups = sysUserGroups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
