package com.cloud.reptile;

import com.alibaba.fastjson.JSONObject;
import com.cloud.ReptileApplication;
import com.cloud.reptile.dto.authentication.IdentifierDTO;
import com.cloud.reptile.dto.law.detail.LawFirmReptileDetailDTO;
import com.cloud.reptile.dto.legal.LegalAidAgencyDTO;
import com.cloud.reptile.dto.mediation.MediatorDTO;
import com.cloud.reptile.dto.mediation.organization.MediationOrganizationDTO;
import com.cloud.reptile.dto.mediation.organization.MediationOrganizationDetailDTO;
import com.cloud.reptile.dto.notary.NotaryDTO;
import com.cloud.reptile.feign.client.ReptileFeignClient;
import com.cloud.reptile.graaroot.legal.GrassRootLegalServiceDTO;
import com.cloud.reptile.graaroot.legal.GrassRootLegalServiceDetailDTO;
import com.cloud.reptile.graaroot.legal.worker.GrassRootLegalServiceWorkerDTO;
import com.cloud.reptile.graaroot.legal.worker.GrassRootLegalServiceWorkerDetailDTO;
import com.cloud.reptile.model.*;
import com.cloud.reptile.service.*;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 项目名称：merge-plus
 * 类 名 称：TestClass
 * 类 描 述：TODO
 * 创建时间：2020/10/20 5:40 下午
 * 创 建 人：chenyouhong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReptileApplication.class) // 指定spring-boot的启动类
public class ReptileDataTest {

//    @Autowired
//    private TestService testService;

    @Autowired
    private ReptileFeignClient reptileFeignClient;

    @Autowired
    private LawFirmService lawFirmService;

    @Autowired
    private LaywerService laywerService;

    @Autowired
    private LegalAidAgencyService legalAidAgencyService;

    @Autowired
    private NotaryOrganizationService notaryOrganizationService;

    @Autowired
    private NotaryService notaryService;

    @Autowired
    private AuthenticationOrganizationService authenticationOrganizationService;

    @Autowired
    private IdentifierService identifierService;

    @Autowired
    private MediationOrganizationService mediationOrganizationService;

    @Autowired
    private MediatorService mediatorService;

    @Autowired
    private GrassrootLegalServiceService grassrootLegalServiceService;

    @Autowired
    private GrassrootLegalServiceWorkerService grassrootLegalServiceWorkerService;

//    @Autowired
//    private RedisTemplate<Object, Object> redisTemplate;

//    @Autowired
//    private DistributedLocker distributedLocker;


    //律所
    @Test
    public void lawFirm() throws Exception {
        JSONObject reptileDTO = reptileFeignClient.getLawFirm();
        List<LawFirm> lawFirms = BeanCloneUtils.copyTo(reptileDTO.getJSONObject("result").getJSONArray("result"), LawFirm.class);
        for (int i=0; i<lawFirms.size(); i++) {
            LawFirm lawFirm1 = lawFirms.get(i);
            Map<Object, Object> params = new HashMap<>();
            params.put("lawfirmId", lawFirm1.getId());
            try {
                LawFirmReptileDetailDTO lawFirmDetail = reptileFeignClient.getLawFirmDetail(params);
                lawFirm1.setIntroduction(lawFirmDetail.getResult().getIntroduction());
                lawFirm1.setOrganizeNumber(lawFirmDetail.getResult().getOrganizeNumber());
            } catch (Exception e) {

            }

            try {
                JSONObject lawyerDetail = reptileFeignClient.getLawyerDetail(params);
                List<Laywer> laywers = BeanCloneUtils.copyTo(lawyerDetail.getJSONObject("result").getJSONArray("result"), Laywer.class);
                laywers.forEach(e -> {
                    e.setLawfirmId(lawFirm1.getId());
                    if ("e10d702b89d849e789039de65cd268cd".equals(e.getGender())) {
                        e.setGender("0");
                    } else {
                        e.setGender("1");
                    }
                });

                laywerService.saveBatch(laywers);

            } catch (Exception e) {

            }


            lawFirmService.insertObj(lawFirm1);
        }


    }


    //法援机构
    @Test
    public void legalAidAgency() throws Exception {
        LegalAidAgencyDTO legalAidAgency = reptileFeignClient.getLegalAidAgency();
        legalAidAgency.getResult().forEach(e -> {
            if (StringUtils.isNotBlank(e.getAxis())) {
                String[] split = e.getAxis().split(",");
                e.setLongitude(Double.valueOf(split[0]));
                e.setLatitude(Double.valueOf(split[1]));
            }
        });
        List<LegalAidAgency> legalAidAgencies = BeanCloneUtils.copyTo(legalAidAgency.getResult(), LegalAidAgency.class);
        legalAidAgencyService.saveBatch(legalAidAgencies);
    }

    //公证员
    @Test
    public void getNotary() throws Exception {
        JSONObject reptileDTO = reptileFeignClient.getNotaryOrgination();
        List<NotaryOrganization> notaryOrganizations = BeanCloneUtils.copyTo(reptileDTO.getJSONObject("result").getJSONArray("result"), NotaryOrganization.class);
        List<Notary> ns = Lists.newArrayList();
        for (int i=0; i<notaryOrganizations.size(); i++) {
            NotaryOrganization notaryOrganization = notaryOrganizations.get(i);
            Map<Object, Object> params = new HashMap<>();
            params.put("id", notaryOrganization.getId());
            try {
                NotaryDTO notary = reptileFeignClient.getNotary(params);

                List<Notary> notaries = BeanCloneUtils.copyTo(notary.getResult(), Notary.class);
                notaries.forEach(e -> {
                    if ("e10d702b89d849e789039de65cd268cd".equals(e.getGender())) {
                        e.setGender("0");
                    } else {
                        e.setGender("1");
                    }
                });
                ns.addAll(notaries);
            } catch (Exception e) {

            }
        }

        notaryOrganizationService.saveBatch(notaryOrganizations);
        notaryService.saveBatch(ns);
    }

    //鉴定机构
    @Test
    public void getAuthenticationOrganization() throws Exception {
        JSONObject reptileDTO = reptileFeignClient.getAuthenticationOrgination();
        List<AuthenticationOrganization> authenticationOrganizations = BeanCloneUtils.copyTo(reptileDTO.getJSONObject("result").getJSONArray("result"), AuthenticationOrganization.class);
        List<Identifier> is = Lists.newArrayList();
        for (int i=0; i<authenticationOrganizations.size(); i++) {
            AuthenticationOrganization authenticationOrganization = authenticationOrganizations.get(i);
            Map<Object, Object> params = new HashMap<>();
            params.put("id", authenticationOrganization.getId());
            try {
                IdentifierDTO authenticationIdentifier = reptileFeignClient.getAuthenticationIdentifier(params);

                List<Identifier> identifiers = BeanCloneUtils.copyTo(authenticationIdentifier.getResult(), Identifier.class);
                identifiers.forEach(e -> {
                    if ("e10d702b89d849e789039de65cd268cd".equals(e.getGender())) {
                        e.setGender("0");
                    } else {
                        e.setGender("1");
                    }
                });
                is.addAll(identifiers);
            } catch (Exception e) {

            }
        }

        authenticationOrganizationService.saveBatch(authenticationOrganizations);
        identifierService.saveBatch(is);
    }

    //调解机构
    @Test
    public void getMediationOrganization() throws Exception {
        MediationOrganizationDTO mediationOrganizationDto = reptileFeignClient.getMediationOrganization();
        List<MediationOrganization> mediationOrganizations = BeanCloneUtils.copyTo(mediationOrganizationDto.getResult().getResult(), MediationOrganization.class);
        List<MediationOrganization> mos = Lists.newArrayList();
        List<Mediator> mediators = Lists.newArrayList();

        for (int i=0; i<mediationOrganizations.size(); i++) {
            MediationOrganization mediationOrganization = mediationOrganizations.get(i);
            Map<Object, Object> params = new HashMap<>();
            params.put("id", mediationOrganization.getId());

            try {
                MediationOrganizationDetailDTO mediationOrganizationDetail = reptileFeignClient.getMediationOrganizationDetail(params);

                MediationOrganization mediationOrganization1 = BeanCloneUtils.copyTo(mediationOrganizationDetail.getResult(), MediationOrganization.class);
                if (StringUtils.isNotBlank(mediationOrganizationDetail.getResult().getAxis())) {
                    String[] split = mediationOrganizationDetail.getResult().getAxis().split(",");
                    mediationOrganization1.setLongitude(Double.valueOf(split[0]));
                    mediationOrganization1.setLatitude(Double.valueOf(split[1]));
                }
                mos.add(mediationOrganization1);
            } catch (Exception e) {

            }

            try {
                MediatorDTO mediator = reptileFeignClient.getMediator(params);

                List<Mediator> mediators1 = BeanCloneUtils.copyTo(mediator.getResult().getResult(), Mediator.class);
                if (mediators1.size() > 0) {

                    mediators1.forEach(e -> {
                        e.setOrgId(mediationOrganization.getId());
                        if (StringUtils.isBlank(e.getOrgName())) {
                            e.setOrgName(mediationOrganization.getName());
                        }
                        if ("e10d702b89d849e789039de65cd268cd".equals(e.getGender())) {
                            e.setGender("0");
                        } else {
                            e.setGender("1");
                        }
                    });
                    mediators.addAll(mediators1);
                }
            } catch (Exception e) {

            }
        }

        mediationOrganizationService.saveBatch(mos);
        mediatorService.saveBatch(mediators);
    }

    //基层法律服务
    @Test
    public void getGrassRootLegalService() throws Exception {
        GrassRootLegalServiceDTO grassRootLegalService = reptileFeignClient.getGrassRootLegalService();
        List<GrassrootLegalService> grassrootLegalServices = BeanCloneUtils.copyTo(grassRootLegalService.getResult().getResult(), GrassrootLegalService.class);

        List<GrassrootLegalService> gls = Lists.newArrayList();
        List<GrassrootLegalServiceWorker> glsr = Lists.newArrayList();

        for (int i=0; i<grassrootLegalServices.size(); i++) {
            GrassrootLegalService grassrootLegalService = grassrootLegalServices.get(i);
            Map<Object, Object> params = new HashMap<>();
            params.put("orgId", grassrootLegalService.getId());

            try {
                GrassRootLegalServiceDetailDTO grassRootLegalServiceDetail = reptileFeignClient.getGrassRootLegalServiceDetail(params);
                GrassrootLegalService grassrootLegalService1 = BeanCloneUtils.copyTo(grassRootLegalServiceDetail.getResult(), GrassrootLegalService.class);
                gls.add(grassrootLegalService1);
            } catch (Exception e) {

            }

            try {
                GrassRootLegalServiceWorkerDTO grassRootLegalServiceWorker = reptileFeignClient.getGrassRootLegalServiceWorker(params);

                List<GrassrootLegalServiceWorker> grassrootLegalServiceWorkers = BeanCloneUtils.copyTo(grassRootLegalServiceWorker.getResult().getResult(), GrassrootLegalServiceWorker.class);
                if (grassrootLegalServiceWorkers.size() > 0) {
                    for (int j=0; j<grassrootLegalServiceWorkers.size(); j++) {
                        GrassrootLegalServiceWorker grassrootLegalServiceWorker1 = grassrootLegalServiceWorkers.get(j);
                        Map<Object, Object> p = new HashMap<>();
                        p.put("staffId", grassrootLegalServiceWorker1.getId());

                        GrassRootLegalServiceWorkerDetailDTO grassRootLegalServiceWorkerDetail = reptileFeignClient.getGrassRootLegalServiceWorkerDetail(p);
                        GrassrootLegalServiceWorker grassrootLegalServiceWorker = BeanCloneUtils.copyTo(grassRootLegalServiceWorkerDetail.getResult(), GrassrootLegalServiceWorker.class);
                        if ("e10d702b89d849e789039de65cd268cd".equals(grassrootLegalServiceWorker.getGender())) {
                            grassrootLegalServiceWorker.setGender("0");
                        } else {
                            grassrootLegalServiceWorker.setGender("1");
                        }
                        glsr.add(grassrootLegalServiceWorker);
                    }
                }
            } catch (Exception e) {

            }
        }

        grassrootLegalServiceService.saveBatch(gls);
        grassrootLegalServiceWorkerService.saveBatch(glsr);
    }


}
