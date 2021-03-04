package com.cloud.reptile.feign.client;

import com.alibaba.fastjson.JSONObject;
import com.cloud.reptile.dto.authentication.IdentifierDTO;
import com.cloud.reptile.dto.law.LawFirmReptileDTO;
import com.cloud.reptile.dto.law.detail.LawFirmReptileDetailDTO;
import com.cloud.reptile.dto.law.laywer.LaywerDTO;
import com.cloud.reptile.dto.legal.LegalAidAgencyDTO;
import com.cloud.reptile.dto.mediation.MediatorDTO;
import com.cloud.reptile.dto.mediation.organization.MediationOrganizationDTO;
import com.cloud.reptile.dto.mediation.organization.MediationOrganizationDetailDTO;
import com.cloud.reptile.dto.notary.NotaryDTO;
import com.cloud.reptile.graaroot.legal.GrassRootLegalServiceDTO;
import com.cloud.reptile.graaroot.legal.GrassRootLegalServiceDetailDTO;
import com.cloud.reptile.graaroot.legal.worker.GrassRootLegalServiceWorkerDTO;
import com.cloud.reptile.graaroot.legal.worker.GrassRootLegalServiceWorkerDetailDTO;
import com.common.response.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name = "lz-cloud-staticdata", url = "https://12348.guizhou.gov.cn/website/parse")
public interface ReptileFeignClient {

	//律所律师
	@PostMapping("/rest.q4w?area=520100&cfg=com.lawyee.jalaw.parse.dto.LawfirmDsoDTO@list&pageSize=1000")
	JSONObject getLawFirm() throws Exception;

	@PostMapping("/rest.q4w?area=520100&cfg=com.lawyee.jalaw.parse.dto.LawfirmDsoDTO@get")
	LawFirmReptileDetailDTO getLawFirmDetail(@RequestParam Map parameters) throws Exception;

	@PostMapping("/rest.q4w?area=520100&cfg=com.lawyee.jalaw.parse.dto.LawyerDsoDTO@list")
	JSONObject getLawyerDetail(@RequestParam Map parameters) throws Exception;

	//援助机构
	@PostMapping("/rest.q4w?area=520100&cfg=com.lawyee.jaaid.parse.dto.JaaidOrganizationDTO%23list&city=520100")
	LegalAidAgencyDTO getLegalAidAgency() throws Exception;

	//公证机构
	@PostMapping("/rest.q4w?city=520100&cfg=com.lawyee.janota.parse.dto.JanotaOrganizationDsoDTO@list&pageSize=100")
	JSONObject getNotaryOrgination() throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.janota.parse.dto.JanotaStaffDsoDTO@list")
	NotaryDTO getNotary(@RequestParam Map parameters) throws Exception;

	//鉴定机构
	@PostMapping("/rest.q4w?city=520100&cfg=com.lawyee.jaauth.parse.dto.JaauthOrganizationDsoDTO@list&pageSize=100")
	JSONObject getAuthenticationOrgination() throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jaauth.parse.dto.JaauthStaffDsoDTO@list")
	IdentifierDTO getAuthenticationIdentifier(@RequestParam Map parameters) throws Exception;

	//调解机构
	@PostMapping("/rest.q4w?city=520100&cfg=com.lawyee.jamed.parse.dto.JamedOrganizationDsoDTO@list&pageSize=2000")
	MediationOrganizationDTO getMediationOrganization() throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jamed.parse.dto.JamedOrganizationDsoDTO@getOrg")
	MediationOrganizationDetailDTO getMediationOrganizationDetail(@RequestParam Map parameters) throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jamed.parse.dto.JamedStaffDsoDTO@list")
	MediatorDTO getMediator(@RequestParam Map parameters) throws Exception;

	//基层法律法律服务所
	@PostMapping("/rest.q4w?area=520100&cfg=com.lawyee.jagls.parse.dto.JaglsOrganizationDsoDTO@list&pageSize=100")
	GrassRootLegalServiceDTO getGrassRootLegalService() throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jagls.parse.dto.JaglsOrganizationDsoDTO@get")
	GrassRootLegalServiceDetailDTO getGrassRootLegalServiceDetail(@RequestParam Map parameters) throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jagls.parse.dto.JaglsStaffDsoDTO@list")
	GrassRootLegalServiceWorkerDTO getGrassRootLegalServiceWorker(@RequestParam Map parameters) throws Exception;

	@PostMapping("/rest.q4w?cfg=com.lawyee.jagls.parse.dto.JaglsStaffDsoDTO@get")
	GrassRootLegalServiceWorkerDetailDTO getGrassRootLegalServiceWorkerDetail(@RequestParam Map parameters) throws Exception;


}
