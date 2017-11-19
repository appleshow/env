package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.HbTypeItemMapper;
import com.aps.env.dao.HbTypeMapper;
import com.aps.env.entity.HbType;
import com.aps.env.entity.HbTypeExample;
import com.aps.env.entity.HbTypeItem;
import com.aps.env.entity.HbTypeItemExample;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewHbTypeItemCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/19</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class ViewHbTypeItemCfgServiceImpl implements ViewHbTypeItemCfgService {
    @Resource
    HbTypeMapper hbTypeMapper;
    @Resource
    HbTypeItemMapper hbTypeItemMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referHbType(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> hbTypes;
        HbTypeExample hbTypeExample = new HbTypeExample();

        hbTypeExample.setOrderByClause("TYPE_ID");
        hbTypes = hbTypeMapper.selectByExample(hbTypeExample);
        responseData.setData(hbTypes);
    }

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referHbTypeItem(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        HbTypeItem hbTypeItem = new HbTypeItem();
        List<HbTypeItem> hbTypeItems;
        PageInfo<HbTypeItem> pageInfo;
        Integer typeId = requestRefPar.getIntegerPar("typeId");
        String itemId = requestRefPar.getStringPar("itemId");
        String itemName = requestRefPar.getStringPar("itemName");
        HbTypeItemExample hbTypeItemExample = new HbTypeItemExample();
        HbTypeItemExample.Criteria criteria = hbTypeItemExample.createCriteria();

        if (typeId != null) {
            criteria.andTypeIdEqualTo(typeId);
        }
        if (!StringUtil.isNullOrEmpty(itemId)) {
            criteria.andItemIdLike(StringUtil.likeValue(itemId));
        }
        if (!StringUtil.isNullOrEmpty(itemName)) {
            criteria.andItemNameLike(StringUtil.likeValue(itemName));
        }

        PageHelper.startPage(requestRefPar.getIntegerPar("pageNumber"), requestRefPar.getIntegerPar("pageSize"));
        hbTypeItems = hbTypeItemMapper.selectByExample(hbTypeItemExample);
        pageInfo = new PageInfo<>(hbTypeItems);

        responseData.setTotalCount(pageInfo.getTotal());
        responseData.setData(hbTypeItems);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyHbTypeItem(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        HbTypeItem hbTypeItem;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            hbTypeItem = (HbTypeItem) JsonUtil.readValueAsObject(rowData, HbTypeItem.class);
            if (null != hbTypeItem) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        hbTypeItem.setItime(now);
                        hbTypeItem.setIperson(personId);
                        hbTypeItem.setUtime(now);
                        hbTypeItem.setUperson(personId);
                        hbTypeItemMapper.insertSelective(hbTypeItem);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        hbTypeItem.setUtime(now);
                        hbTypeItem.setUperson(personId);
                        hbTypeItemMapper.updateByPrimaryKeySelective(hbTypeItem);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        hbTypeItemMapper.deleteByPrimaryKey(hbTypeItem);

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
            responseData.setMessage("数据处理异常[jsonParseException]，请检查输入数据！");
        } else {
            responseData.setCode(0);
        }
    }
}
