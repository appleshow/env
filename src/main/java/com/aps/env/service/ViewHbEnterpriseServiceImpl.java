package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbEnterpriseMapper;
import com.aps.env.entity.HbEnterprise;
import com.aps.env.entity.HbEnterpriseExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
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
public class ViewHbEnterpriseServiceImpl implements ViewHbEnterpriseService {
    @Resource
    private HbEnterpriseMapper hbEnterpriseMapper;

    @Override
    public void refEnterprise(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbEnterpriseExample hbEnterpriseExample = new HbEnterpriseExample();
        HbEnterpriseExample.Criteria criteria = hbEnterpriseExample.createCriteria();
        Integer enterpriseId = requestRefPar.getIntegerPar("enterpriseId");
        String enterpriseName = requestRefPar.getStringPar("enterpriseName");
        String enterpriseRegion = requestRefPar.getStringPar("enterpriseRegion");

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
                String enterpriseRegionDesc = hbEnterprise.getEnterpriseRegionDesc().replace("(", "#").replace(")", "#");
                String[] regionTargets = enterpriseRegionDesc.split("#");

                hbEnterprise.setEnterpriseRegion(regionTargets[1]);
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbEnterprise.setDeleteFlag(CommUtil.AVAILABLE);
                        hbEnterprise.setItime(now);
                        hbEnterprise.setIperson(personId);
                        hbEnterprise.setUtime(now);
                        hbEnterprise.setUperson(personId);
                        hbEnterpriseMapper.insertSelective(hbEnterprise);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbEnterprise.setUtime(now);
                        hbEnterprise.setUperson(personId);
                        hbEnterpriseMapper.updateByPrimaryKeySelective(hbEnterprise);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        HbEnterpriseExample hbEnterpriseExample = new HbEnterpriseExample();
                        hbEnterpriseExample.createCriteria().andEnterpriseIdEqualTo(hbEnterprise.getEnterpriseId());
                        HbEnterprise hbEnterpriseDelete = new HbEnterprise();

                        hbEnterpriseDelete.setDeleteFlag(CommUtil.DELETE);
                        hbEnterpriseMapper.updateByExampleSelective(hbEnterpriseDelete, hbEnterpriseExample);

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
