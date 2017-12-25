package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbEnterpriseMapper;
import com.aps.env.dao.HbNodeMapper;
import com.aps.env.entity.HbEnterprise;
import com.aps.env.entity.HbEnterpriseExample;
import com.aps.env.entity.HbNode;
import com.aps.env.entity.HbNodeExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbEnterpriseServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/25</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class HbEnterpriseServiceImpl implements HbEnterpriseService {
    @Resource
    private HbEnterpriseMapper hbEnterpriseMapper;
    @Resource
    private HbNodeMapper hbNodeMapper;

    @Override
    public void refEnterprise(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbEnterpriseExample hbEnterpriseExample = new HbEnterpriseExample();
        HbEnterpriseExample.Criteria criteria = hbEnterpriseExample.createCriteria();
        Integer enterpriseId = requestRefPar.getIntegerPar("enterpriseId");
        String enterpriseName = requestRefPar.getStringPar("enterpriseName");
        String enterpriseRegion = requestRefPar.getStringPar("enterpriseRegion");
        String selectByPerson = requestRefPar.getStringPar("byPerson");

        if (!StringUtil.isNullOrEmpty(selectByPerson) && "1".equals(selectByPerson)) {
            HbEnterprise hbEnterprise = new HbEnterprise();
            hbEnterprise.setIperson((int) httpSession.getAttribute(CommUtil.SESSION_PERSON_ID));
            responseData.setData(hbEnterpriseMapper.selectByPerson(hbEnterprise));
        } else {
            if (enterpriseId != null) {
                criteria.andEnterpriseIdEqualTo(enterpriseId);
            }
            if (!StringUtil.isNullOrEmpty(enterpriseName)) {
                criteria.andEnterpriseNameLike("%" + enterpriseName + "%");
            }
            if (!StringUtil.isNullOrEmpty(enterpriseRegion)) {
                criteria.andEnterpriseRegionEqualTo(enterpriseRegion);
            }

            criteria.andDeleteFlagEqualTo(CommUtil.AVAILABLE);
            hbEnterpriseExample.setOrderByClause("ENTERPRISE_REGION");
            responseData.setData(hbEnterpriseMapper.selectByExample(hbEnterpriseExample));
        }
    }

    @Override
    public void modifyEnterprise(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbEnterprise hbEnterprise;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbEnterprise = (HbEnterprise) JsonUtil.readValueAsObject(rowData, HbEnterprise.class);
            if (null != hbEnterprise) {
                String enterpriseRegionDesc;
                String[] regionTargets;

                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        enterpriseRegionDesc = hbEnterprise.getEnterpriseRegionDesc().replace("(", "#").replace(")", "#");
                        regionTargets = enterpriseRegionDesc.split("#");

                        hbEnterprise.setEnterpriseRegion(regionTargets[1]);
                        hbEnterprise.setDeleteFlag(CommUtil.AVAILABLE);
                        hbEnterprise.setItime(now);
                        hbEnterprise.setIperson(personId);
                        hbEnterprise.setUtime(now);
                        hbEnterprise.setUperson(personId);
                        hbEnterpriseMapper.insertSelective(hbEnterprise);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        enterpriseRegionDesc = hbEnterprise.getEnterpriseRegionDesc().replace("(", "#").replace(")", "#");
                        regionTargets = enterpriseRegionDesc.split("#");

                        hbEnterprise.setEnterpriseRegion(regionTargets[1]);
                        hbEnterprise.setUtime(now);
                        hbEnterprise.setUperson(personId);
                        hbEnterpriseMapper.updateByPrimaryKeySelective(hbEnterprise);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        HbNodeExample hbNodeExample = new HbNodeExample();
                        hbNodeExample.createCriteria().andEnterpriseIdEqualTo(hbEnterprise.getEnterpriseId());
                        List<HbNode> hbNodes = hbNodeMapper.selectByExample(hbNodeExample);
                        if (null != hbNodes && hbNodes.size() > 0) {
                            responseData.setCode(-108);
                            responseData.setMessage("删除失败，请先删除该企业下的站点...!!");
                            return;
                        }

                        hbEnterpriseMapper.deleteByPrimaryKey(hbEnterprise.getEnterpriseId());

                        break;
                    default:
                        break;
                }
            } else {
                jsonParseException = true;
                break;
            }
        }

        if (jsonParseException) {
            responseData.setCode(-108);
            responseData.setMessage("数据处理异常，请检查输入数据！");
        } else {
            responseData.setCode(0);
        }
    }
}
