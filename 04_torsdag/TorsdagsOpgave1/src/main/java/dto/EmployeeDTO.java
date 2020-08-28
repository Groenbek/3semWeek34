/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Employee;

/**
 *
 * @author groen
 */
public class EmployeeDTO {
    private int id;
    private String name;
    private String address;

    public EmployeeDTO(Employee emp) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    EmployeeDTO(int i, String christensen, String lolstreet_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }