package com.hd.supermarket.dto.options;

/**
 * @author 李金荣
 * @date 2018/11/2 14:15
 */
public class AdminAccountOptions extends PageableOptions {

    private String adminName;

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
