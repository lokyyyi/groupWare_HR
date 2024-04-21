package com.comes.hr.staff.entity;

import com.comes.hr.staff.dto.*;
import com.comes.hr.staff.mapper.*;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.comes.hr.common.util.DeptMap.*;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Slf4j
//@Builder(builderMethodName = "staffBuilder")
public class Staff extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;
    private String staffNumber;
    private String hangulName;
    private String englishName;
    private String staffAccount;
    private String password;
    private String role;
    private String residentRegistrationNumber;
    private String gender;
    private String localForeignerCode;
    private String nationality;
    private String zipcode;
    private String sido;
    private String address;
    private String mobilePhoneNumber;
    private String homePhoneNumber;
    private String email;
    private String joiningCompanySortation;
    private String joiningCompanyDate;
    private String resignationDate;
    private String servedState;
    private String contractForm;
    private String workforceSortation;
    private String position;
    private String chargeWork;
    private Integer year;
    private String careerSortation;
    private String technicalRating;
    private Integer totalCareer;
    private Integer recognitionCareer;
    private Integer projectManagementCareer;
    private String specialtyIssues;
    private String vacationDate;
    private String reinstatementDate;
    private String photoPath;
    private String deleteYn;
    private String deptName1;
    private String deptName2;
    private String deptName3;
    private Integer hangulNameNumber;


    public String getDNM1(){
        BigInteger did = new BigInteger("0");

        List<String> liDN = new ArrayList<>();
        String strDeptName = "";
        if(staffDepartments != null && staffDepartments.size()>0){
            StaffDepartment sd = staffDepartments.get(0);

            if(staffDepartments != null && staffDepartments.size()>0)  did = sd.getDepartmentId();
            //첫번째 값 셋
            liDN.add(DEPT_MAP.get(String.valueOf(did)));
            BigInteger pdid = PAR_MAP.get(did);
            if(pdid != null && DEP_MAP.get(pdid).getLevel()>1){
                liDN.add(DEPT_MAP.get(String.valueOf(pdid)));
                BigInteger ppdid = PAR_MAP.get(pdid);
                if(ppdid != null && DEP_MAP.get(ppdid).getLevel()>1){
                    liDN.add(DEPT_MAP.get(String.valueOf(ppdid)));
                }
            }
            Collections.reverse(liDN);
            log.info(liDN.toString());
            if(liDN.size()>0) strDeptName = liDN.get(0);
            if(liDN.size()>1) setDeptName2(liDN.get(1));
            if(liDN.size()>2) setDeptName3(liDN.get(2));
        }
        return strDeptName;
    }

    //0.부서
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="staff_id")
    private List<StaffDepartment> staffDepartments;
    public void addStaffDepartment(StaffDepartment staffDepartment) {this.staffDepartments.add(staffDepartment);}

    //1.학력
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="staff_id")
    private List<Education> educations;
    /*    학력 생성     */
    public void addEducation(Education education){
        this.educations.add(education);
    }
    //2. 자격/면허
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="staff_id")
    private List<CertificateLicense> certificateLicenses;

    public void addCertificateLicense(CertificateLicense certificateLicense) {this.certificateLicenses.add(certificateLicense);}

    //3. 경력
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="staff_id")
    private List<Career> careers;

    public void addCareer(Career career){this.careers.add(career);};

    //4. 프로젝트
    @ToString.Exclude
    @OneToMany(cascade = {CascadeType.PERSIST})
    @JoinColumn(name="staff_id")
    private List<ProjectHistory> projectHistories;

    public void addProjectHistory(ProjectHistory projectHistory){this.projectHistories.add(projectHistory);}

    public void update(StaffDto e){
        if(e.getStaffNumber() != null) this.setStaffNumber(e.getStaffNumber());
        if(e.getHangulName() !=null) this.setHangulName(e.getHangulName());
        if(e.getEnglishName() !=null) this.setEnglishName(e.getEnglishName());
        if(e.getStaffAccount() !=null) this.setStaffAccount(e.getStaffAccount());
        if(e.getPassword() != null) this.setPassword(e.getPassword());
        if(e.getRole() != null) this.setRole(e.getRole());
        if(e.getResidentRegistrationNumber() !=null) this.setResidentRegistrationNumber(e.getResidentRegistrationNumber());
        if(e.getGender() !=null) this.setGender(e.getGender());
        if(e.getLocalForeignerCode() !=null) this.setLocalForeignerCode(e.getLocalForeignerCode());
        if(e.getNationality() !=null) this.setNationality(e.getNationality());
        if(e.getZipcode() !=null) this.setZipcode(e.getZipcode());
        if(e.getSido() != null) this.setSido(e.getSido());
        if(e.getAddress() !=null) this.setAddress(e.getAddress());
        if(e.getMobilePhoneNumber() !=null) this.setMobilePhoneNumber(e.getMobilePhoneNumber());
        if(e.getHomePhoneNumber() !=null) this.setHomePhoneNumber(e.getHomePhoneNumber());
        if(e.getEmail() !=null) this.setEmail(e.getEmail());
        if(e.getJoiningCompanySortation() !=null) this.setJoiningCompanySortation(e.getJoiningCompanySortation());
        if(e.getJoiningCompanyDate() !=null) this.setJoiningCompanyDate(e.getJoiningCompanyDate());
        if(e.getResignationDate() !=null) this.setResignationDate(e.getResignationDate());
        if(e.getServedState() !=null) this.setServedState(e.getServedState());
        if(e.getContractForm() !=null) this.setContractForm(e.getContractForm());
        if(e.getWorkforceSortation() !=null) this.setWorkforceSortation(e.getWorkforceSortation());
        if(e.getPosition() !=null) this.setPosition(e.getPosition());
        if(e.getChargeWork()!=null) this.setChargeWork(e.getChargeWork());
        if(e.getCareerSortation() !=null) this.setCareerSortation(e.getCareerSortation());
        if(e.getTechnicalRating() !=null) this.setTechnicalRating(e.getTechnicalRating());
        if(e.getTotalCareer() !=null) this.setTotalCareer(e.getTotalCareer());
        if(e.getRecognitionCareer() !=null) this.setRecognitionCareer(e.getRecognitionCareer());
        if(e.getProjectManagementCareer() !=null) this.setProjectManagementCareer(e.getProjectManagementCareer());
        if(e.getSpecialtyIssues() !=null) this.setSpecialtyIssues(e.getSpecialtyIssues());
        if(e.getVacationDate() !=null) this.setVacationDate(e.getVacationDate());
        if(e.getReinstatementDate() !=null) this.setReinstatementDate(e.getReinstatementDate());
        if(e.getPhotoPath() !=null) this.setPhotoPath(e.getPhotoPath());
        if(e.getDeleteYn() !=null) this.setDeleteYn(e.getDeleteYn());
        if(e.getUpdId() != null) this.setUpdId(e.getUpdId());
        if(e.getDeptName1()!=null) this.setDeptName1(e.getDeptName1());
        if(e.getDeptName2()!= null) this.setDeptName2(e.getDeptName2());
        if(e.getDeptName3()!=null) this.setDeptName3(e.getDeptName3());

        //0. 부서
        if(e.getStaffDepartmentDtos() != null && e.getStaffDepartmentDtos().size()>0){
            for(StaffDepartmentDto staffDepartmentDto : e.getStaffDepartmentDtos()){
                //부서(겸직)이 추가된다면 id 없음
                if(staffDepartmentDto.getId() == null){
                    StaffDepartment staffDepartment = StaffDepartmentMapper.INSTANCE.dtoToEntity(staffDepartmentDto);
                    this.staffDepartments.add(staffDepartment);
                }else{
                    for(StaffDepartment staffDepartment : staffDepartments){
                        if(staffDepartment.getId().equals(staffDepartmentDto.getId())){
                            staffDepartment.update(staffDepartmentDto);
                        }
                    }
                }
            }
        }

        //1. 학력
        if(e.getEducationDtos() != null && e.getEducationDtos().size() > 0){
            for(EducationDto educationDto : e.getEducationDtos()){
                //학력이 추가됐다면 = id 없음
                if(educationDto.getId() == null) {
                    Education education = EducationMapper.INSTANCE.educationDtoToEntity(educationDto);
                    this.educations.add(education);
                }else{
                    for(Education education : educations){
                        if(education.getId().equals(educationDto.getId())) {
                            education.update(educationDto);
                        }
                    }
                }
            }
        }
        //2. 자격/면허
        if(e.getCertificateLicenseDtos() != null && e.getCertificateLicenseDtos().size() > 0){
            for(CertificateLicenseDto certificateLicenseDto : e.getCertificateLicenseDtos()){
                if(certificateLicenseDto.getId() == null){
                    CertificateLicense certificateLicense = CertificateLicenseMapper.INSTANCE.certificateLicenseDtoToEntity(certificateLicenseDto);
                    this.certificateLicenses.add(certificateLicense);
                }else{
                    for(CertificateLicense certificateLicense : certificateLicenses){
                        if(certificateLicense.getId().equals(certificateLicenseDto.getId())){
                            certificateLicense.update(certificateLicenseDto);
                        }
                    }
                }
            }
        }
        //3. 경력
        if(e.getCareerDtos() != null && e.getCareerDtos().size()>0){
            for(CareerDto careerDto : e.getCareerDtos()){
                if(careerDto.getId() == null){
                    Career career = CareerMapper.INSTANCE.careerDtoToEntity(careerDto);
                    this.careers.add(career);
                }else{
                    for(Career career : careers){
                        if(career.getId().equals(careerDto.getId())){
                            career.update(careerDto);
                        }
                    }
                }
            }
        }
        //4. 프로젝트
        if(e.getProjectHistoryDtos() != null && e.getProjectHistoryDtos().size()>0){
            for(ProjectHistoryDto projectHistoryDto : e.getProjectHistoryDtos()){
                if(projectHistoryDto.getId() == null){
                    ProjectHistory projectHistory = ProjectHistoryMapper.INSTANCE.projectHistoryDtoToEntity(projectHistoryDto);
                    this.projectHistories.add(projectHistory);
                }else{
                    for(ProjectHistory projectHistory : projectHistories){
                        if(projectHistory.getId().equals(projectHistoryDto.getId())){
                            projectHistory.update(projectHistoryDto);
                        }
                    }
                }
            }
        }

    }

}
