package com.comes.hr.project.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="project")
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name="id", updatable = false, nullable = false)
    private BigInteger id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "type", nullable = false, length = 10)
    private String type;

    @Column(name = "perform_period", nullable = true)
    private String performPeriod;

    @Column(name = "description", nullable = true, length = 2000)
    private String description;

    @Column(name = "place", nullable = true, length = 1000)
    private String place;

    @Column(name = "staff_id", nullable = false)
    private BigInteger staffId;

    @Column(name = "client_company", nullable = false, length = 200)
    private String clientCompany;

    @Column(name="client_person_charge", nullable = false, length = 100)
    private String clientPersonCharge;

    @Column(name = "client_department_charge", nullable = false, length = 100)
    private String clientDepartmentCharge;

    @Column(name = "client_phone_number", nullable = true, length = 100)
    private String clientPhoneNumber;

    @Column(name = "client_email", nullable = true, length = 50)
    private String clientEmail;

    @Column(name = "start_date", nullable = true)
    private String startDate;

    @Column(name = "end_due_date", nullable = true)
    private String endDueDate;

    @Column(name = "state", columnDefinition = "varchar(10) default '진행'")
    private String state;

    @Column(name = "reason", nullable = true, length = 1000)
    private String reason;

    @Column(name = "delete_yn", nullable = true, length = 1)
    private String deleteYn;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinColumn(name="project_id")
    @Transient		//영속대상에서 제외
    private List<ProjectParticipation> projectParticipations;

    @Builder
    public Project(BigInteger id, String name, String type, String performPeriod, String description, String place, BigInteger staffId,
                   String clientPhoneNumber, String clientCompany, String clientDepartmentCharge, String clientEmail,
                   String startDate, String state, String reason,
                   String clientPersonCharge, String endDueDate,String deleteYn, String regId,String updId){
        this.id = id;
        this.name= name;
        this.type = type;
        this.performPeriod = performPeriod;
        this.description= description;
        this.place = place;
        this.staffId = staffId;
        this.clientCompany = clientCompany;
        this.clientPersonCharge = clientPersonCharge;
        this.clientDepartmentCharge = clientDepartmentCharge;
        this.clientEmail = clientEmail;
        this.clientPhoneNumber = clientPhoneNumber;
        this.state = state;
        this.reason = reason;
        this.startDate = startDate;
        this.endDueDate = endDueDate;
        this.deleteYn = deleteYn;
        this.setRegId(regId);
        this.setUpdId(updId);
    }
}
