package com.example.selfserviceportal.entities;

import com.example.selfserviceportal.entities.abstracts.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "benefits")
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Benefits extends AbstractEntity {
    private BenefitType benefitType;
    private String description;


}
