/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Role;

import java.util.Scanner;

/**
 *
 * @author DUONG NGOC AN
 */

public abstract class Role {
    protected String roleName;

    public Role(){

    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public abstract void showMenu(Scanner sc);

}