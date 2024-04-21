package com.comes.hr.project.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigInteger;

//@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
@ToString
@Entity
@Table(name="staff")
public class Staff2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private BigInteger id;

    @Column
    private String hangulName;

    private String residentRegistrationNumber;

    @Column
    private String technicalRating;

    private String recognitionCareer;


    public void update(Staff2 e){

        if(e.getHangulName() !=null) this.setHangulName(e.getHangulName());

        if(e.getResidentRegistrationNumber() !=null) this.setResidentRegistrationNumber(e.getResidentRegistrationNumber());

        if(e.getTechnicalRating() !=null) this.setTechnicalRating(e.getTechnicalRating());

        if(e.getRecognitionCareer() !=null) this.setRecognitionCareer(e.getRecognitionCareer());

    }
}
