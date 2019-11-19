package com.mngr.adminapp.adminapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

class User {
    @Id
    private String id;
    private String name;
    private String email;
    }
