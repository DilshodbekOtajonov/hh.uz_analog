package com.example.project_blueprint.service.vacancy;

import com.example.project_blueprint.domains.vacancy.Vacancy;
import com.example.project_blueprint.dto.vacancy.VacancyCreateDTO;
import com.example.project_blueprint.dto.vacancy.VacancyDTO;
import com.example.project_blueprint.dto.vacancy.VacancyUpdateDTO;
import com.example.project_blueprint.enums.user.Experience;
import com.example.project_blueprint.exceptions.VacancyNotFoundException;
import com.example.project_blueprint.mappers.vacancy.VacancyMapper;
import com.example.project_blueprint.repository.vacancy.VacancyRepository;
import com.example.project_blueprint.service.country.CityService;
import com.example.project_blueprint.service.specialization.CategoryService;
import com.example.project_blueprint.service.specialization.SkillService;
import com.example.project_blueprint.service.specialization.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 * @author "Otajonov Dilshodbek
 * @since 10/21/22 5:45 PM (Friday)
 * hh.uz_analaog/IntelliJ IDEA
 */
@RequiredArgsConstructor
@Service
public class VacancyServiceImpl implements VacancyService {

    private final VacancyRepository vacancyRepository;
    private final SpecializationService specializationService;
    private final SkillService skillService;
    private final CityService cityService;
    private final ContactInfoService contactInfoService;
    private final CategoryService categoryService;
    private final VacancyMapper vacancyMapper;


    @Override
    public VacancyDTO create(VacancyCreateDTO dto) {
        dto.getSpecializations().forEach(specialization -> specializationService.getSpecializationById(specialization.getId()));
        dto.getCityList().forEach(city -> cityService.getCityById(city.getId()));
        Experience.findByExperience(dto.getExperience().name());
        dto.getSkillList().forEach(skill -> skillService.getSkillById(skill.getId()));
        contactInfoService.getContactInfoById(dto.getContactInfo().getId());
        Vacancy vacancy = vacancyMapper.toVacancy(dto);
        vacancy.setCreatedAt(LocalDateTime.now());
        vacancy.setCreatedBy(1L);
        Vacancy save = vacancyRepository.save(vacancy);
        return vacancyMapper.fromVacancy(save);
    }

    @Override
    public VacancyDTO update(VacancyUpdateDTO dto) {
        Vacancy vacancy = getVacancyById(dto.getId());
        vacancy.setUpdatedAt(LocalDateTime.now());
        vacancy.setUpdatedBy(1L);
        if (!Objects.isNull(dto.getCityList())) {
            vacancy.setCityList(dto.getCityList());
        }
        if (!Objects.isNull(dto.getContactInfo())) {
            vacancy.setContactInfo(dto.getContactInfo());
        }
        if (!Objects.isNull(dto.getDescription())) {
            vacancy.setDescription(dto.getDescription());
        }
        if (!Objects.isNull(dto.getExperience())) {
            vacancy.setExperience(dto.getExperience());
        }
        if (!Objects.isNull(dto.getSkillList())) {
            vacancy.setSkillList(dto.getSkillList());
        }
        if (!Objects.isNull(dto.getSpecializations())) {
            vacancy.setSpecializations(dto.getSpecializations());
        }
        if (!Objects.isNull(dto.getTitle())) {
            vacancy.setTitle(dto.getTitle());
        }
        return vacancyMapper.fromVacancy(vacancy);
    }

    @Override
    public void delete(Long id) {
        Vacancy vacancyById = getVacancyById(id);
        if (vacancyById.getDeleted().equals(Boolean.TRUE)) {
            throw new RuntimeException("Vacancy deleted");
        }
        vacancyById.setDeleted(Boolean.TRUE);
        vacancyRepository.save(vacancyById);
    }


    @Override
    public VacancyDTO getOne(Long id) {
        Vacancy vacancy = getVacancyById(id);
        VacancyDTO vacancyDTO = vacancyMapper.fromVacancy(vacancy);
        return vacancyDTO;
    }

    @Override
    public List<VacancyDTO> findAll() {
        List<Vacancy> vacancyList = vacancyRepository.findAll();
        List<VacancyDTO> vacancyDTOS = vacancyMapper.fromListVacancy(vacancyList);
        return vacancyDTOS;
    }

    @Override
    public Vacancy getVacancyById(Long id) {
        Vacancy vacancyNotFoundById = vacancyRepository.findById(id).orElseThrow(() -> {
            throw new VacancyNotFoundException("Vacancy Not Found By Id");
        });
        return vacancyNotFoundById;
    }
}
