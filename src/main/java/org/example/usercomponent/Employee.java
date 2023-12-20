package org.example.usercomponent;

import java.util.UUID;

public class Employee extends User {

    // Add a new field for employee_id
    private UUID employee_id;
    private String role;
    private String full_name;
    private String department;
    private String status;
    private String dob;


    // Private constructor to be used by the builder
    private Employee(UUID employee_id, String email_addr, String contact_nr, String passwd, String role, String full_name, String department, String status, String dob) {
        super(email_addr, contact_nr, passwd);
        this.employee_id = employee_id;
        this.full_name = full_name;
        this.role = role;
        this.department = department;
        this.status = status;
        this.dob = dob;
        
    }

    // Builder class for Employee
    public static class EmployeeBuilder {
        private UUID employee_id;
        private String email_addr;
        private String contact_nr;
        private String passwd;
        private String full_name;
        private String role;
        private String department;
        private String status;
        private String dob;
        

        public EmployeeBuilder(String email_addr, String passwd) {
            this.employee_id = UUID.randomUUID();
            this.email_addr = email_addr;
            this.passwd = passwd;
        }

        public EmployeeBuilder fullName(String full_name) {
            this.full_name = full_name;
            return this;
        }

        public EmployeeBuilder contactNr(String contact_nr) {
            this.contact_nr = contact_nr;
            return this;
        }

        public EmployeeBuilder role(String role) {
            this.role = role;
            return this;
        }

        public EmployeeBuilder department(String department) {
            this.department = department;
            return this;
        }

        public EmployeeBuilder status(String status) {
            this.status = status;
            return this;
        }

        public EmployeeBuilder dob(String dob) {
            this.dob = dob;
            return this;
        }

        public Employee build() {
            // If contact_nr is not provided, set it to a default value or handle it accordingly
            if (contact_nr == null) {
                // Set a default value or handle the absence of contact_nr
            }
            return new Employee(employee_id, email_addr, contact_nr, passwd, role, full_name, department, status, dob);
        }

    }

    // Corrected method signature
    public UUID getEmployeeId() {
        return employee_id;
    }

    public String getFullName() {
        return full_name;
    }

    public String getRole() {
        return role;
    }

    public String getDepartment() {
        return department;
    }

    public String getStatus() {
        return status;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public UUID generate_uuid() {
        return UUID.randomUUID();
    }

}
