package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysDepartmentMapper;
import com.cloud.user.model.SysDepartment;
import com.cloud.user.model.SysResource;
import com.cloud.user.service.SysDepartmentService;
import com.common.util.ListTransferTree;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * Title: SysDepartmentServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Service
@Slf4j
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {

	@Autowired
	private SysDepartmentMapper sysDepartmentMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#insertObj(com.cloud.user.model.
	 * SysDepartment)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "插入对象")
	public void insertObj(SysDepartment sysDepartment) {
		baseMapper.insert(sysDepartment);
		sysDepartment.setDepartCode("D" + sysDepartment.getId());
		baseMapper.updateById(sysDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#updateObj(com.cloud.user.model.
	 * SysDepartment)
	 */
	@Override
//	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(SysDepartment sysDepartment) {
		baseMapper.updateById(sysDepartment);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#deleteObj(com.cloud.user.model.
	 * SysDepartment)
	 */
	@Override
//	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(SysDepartment sysDepartment) {
		baseMapper.updateById(sysDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#findByObj(com.cloud.user.model.
	 * SysDepartment)
	 */
	@Override
//	@ServiceLog(description = "findByObj")
	public List<SysDepartment> findByObj(SysDepartment sysDepartment) {
		return null;
//		Map<String, Object> columnMap = BeanCloneUtilsExt.copyTohumpToLine(sysDepartment);
//		return baseMapper.selectByMap(columnMap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#getByObj(com.cloud.user.model.
	 * SysDepartment)
	 */
	@Override
//	@ServiceLog(description = "findOneByObj")
	public SysDepartment findOneByObj(SysDepartment sysDepartment) {
		return null;
//		return baseMapper.selectOne(sysDepartment);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#findRootLst()
	 */
	@Override
//	@ServiceLog(description = "findRootLst")
	public List<SysDepartment> findRootLst(String companyCode) {
		return null;
//		EntityWrapper<SysDepartment> ew = new EntityWrapper<SysDepartment>();
//		ew.eq("company_code", companyCode);
//		ew.eq("parent_depart_code", "0");
//		return baseMapper.selectList(ew);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysDepartmentService#findChildLst(java.lang.String)
	 */
	@Override
//	@ServiceLog(description = "findChildLst")
	public List<SysDepartment> findChildLst(String code) {
//		EntityWrapper<SysDepartment> ew = new EntityWrapper<SysDepartment>();
//		ew.eq("parent_depart_code", code);
//		return baseMapper.selectList(ew);
		return null;
	}

	@Override
//	@ServiceLog(description = "listWithName")
	public List<SysDepartment> findSysDepartmentByCompanyCode(String companycode) throws Exception {
		List<SysDepartment> sysDepartments = sysDepartmentMapper.findSysDepartmentByCompanyCode(companycode);
		SysDepartment sysDepartment = new SysDepartment();
		new ListTransferTree(sysDepartments, sysDepartment, SysDepartment::getDepartCode, SysDepartment::getParentDepartCode, SysDepartment::getChildren)
				.tree();
		return sysDepartment.getChildren();
	}

	@Override
//	@ServiceLog(description = "findTreeLst")
	public List<SysDepartment> findTreeLst(SysDepartment param) {
		return null;
//		List<SysDepartment> list = this.listWithName(param);
//		SysDepartment sysDepartment = new SysDepartment();
//		sysDepartment.setDepartCode("0");
//		new ObjectSetChildren<SysDepartment>().setChildren(sysDepartment, list, "parentDepartCode", "departCode",
//				"childs");
//		return sysDepartment.getChilds();
	}

	@Override
	public List<SysDepartment> findAllChildLst(String code) {
		return null;
//		SysDepartment param = new SysDepartment();
//		List<SysDepartment> list = this.listWithName(param);
//		HashMap<String, SysDepartment> map = Maps.newHashMap();
//		for (SysDepartment department : list) {
//			map.put(department.getDepartCode(), department);
//		}
//		List<SysDepartment> clilds = Lists.newArrayList();
//		clilds = getChilds(map, code, list);
//		return clilds;
	}

	private List<SysDepartment> getChilds(HashMap<String, SysDepartment> map, String departCode,
                                          List<SysDepartment> list) {
		List<SysDepartment> childs = Lists.newArrayList();
		for (SysDepartment depart : list) {
			List<String> parents = Lists.newArrayList();
			getAllParentsKey(map, depart.getDepartCode(), parents);
			if (parents.contains(departCode)) {
				childs.add(depart);
			}
		}
		return childs;

	}

	private void getAllParentsKey(HashMap<String, SysDepartment> map, String departCode, List<String> list) {
		SysDepartment department = map.get(departCode);
		if ("0".equals(department.getParentDepartCode())) {
			return;
		}
		else {
			list.add(department.getParentDepartCode());
			getAllParentsKey(map, department.getParentDepartCode(), list);
		}
	}

	@Override
	public SysDepartment findChildTreeLst(SysDepartment root) {
		SysDepartment param = new SysDepartment();
//		List<SysDepartment> list = this.listWithName(param);

//		new ObjectSetChildren<SysDepartment>().setChildren(root, list, "parentDepartCode", "departCode", "childs");
		return root;
	}
}
