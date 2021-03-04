package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.dto.CompanyAndDepartmentDTO;
import com.cloud.user.mapper.SysCompanyMapper;
import com.cloud.user.model.SysCompany;
import com.cloud.user.service.SysCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
* <p>
* Title: SysCompanyServiceImpl
* </p>
* <p>
* Description:
* </p>
* @author chenyouhong
* @since 2021-02-16
*/
@Service
@Slf4j
public class SysCompanyServiceImpl extends ServiceImpl<SysCompanyMapper, SysCompany> implements SysCompanyService {

   @Autowired
   private SysCompanyMapper sysCompanyMapper;


   /*
    * (non-Javadoc)
    *
    * @see com.cloud.user.service.SysCompanyService#insertObj(com.cloud.user.model.SysCompany)
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void insertObj(SysCompany sysCompany) {
      sysCompanyMapper.insert(sysCompany);
   }

   /*
    * (non-Javadoc)
    *
    * @see com.cloud.user.service.SysCompanyService#updateObj(com.cloud.user.model.SysCompany)
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void updateObj(SysCompany sysCompany) {
      sysCompanyMapper.updateById(sysCompany);

   }

   /*
    * (non-Javadoc)
    *
    * @see com.cloud.user.service.SysCompanyService#deleteObj(com.cloud.user.model.SysCompany)
    */
   @Override
   @Transactional(rollbackFor = Exception.class)
   public void deleteObj(SysCompany sysCompany) {
      sysCompanyMapper.updateById(sysCompany);
   }

   /*
    * (non-Javadoc)
    *
    * @see com.cloud.user.service.SysCompanyService#findByObj(com.cloud.user.model.SysCompany)
    */
   @Override
   public List<SysCompany> findByObj(SysCompany sysCompany) {
       return null;
   }

   @Override
   public List<SysCompany> findAll() {
      Wrapper<SysCompany> wrapper = new LambdaQueryWrapper<>();
      return sysCompanyMapper.selectList(wrapper);
   }

   /*
    * (non-Javadoc)
    *
    * @see com.cloud.user.service.SysCompanyService#getByObj(com.cloud.user.model.SysCompany)
    */
   @Override
   public SysCompany findOneByObj(SysCompany sysCompany) {
      return null;
   }

   @Override
   public List<CompanyAndDepartmentDTO> getAllCompanyAndDepartment() {
       return sysCompanyMapper.getAllCompanyAndDepartment();
   }
}
