package com.example.jigumproject.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="apiKey")
public class Bike {


    @Id
    private Long id;

    private String key;


}
