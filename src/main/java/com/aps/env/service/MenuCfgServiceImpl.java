package com.aps.env.service;

import com.aps.env.comm.*;
import com.aps.env.dao.ComFormMapper;
import com.aps.env.dao.ComMenuMapper;
import com.aps.env.entity.ComFormExample;
import com.aps.env.entity.ComMenu;
import com.aps.env.entity.ComMenuExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <dl>
 * <dt>com.aps.env.service.ViewMenuCfgServiceImpl</dt>
 * <dd>Description:</dd>
 * <dd>Copyright:  Copyright (C) 2017</dd>
 * <dd>Company:    AppleShow Technology </dd>
 * <dd>CreateDate: 2017/11/10</dd>
 * </dl>
 *
 * @author appleshow
 */
@Service
public class MenuCfgServiceImpl implements MenuCfgService {
    @Resource
    private ComFormMapper comFormMapper;
    @Resource
    private ComMenuMapper comMenuMapper;

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referMenu(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comMenus;
        ComMenuExample comMenuExample = new ComMenuExample();
        ComMenuExample.Criteria criteria = comMenuExample.createCriteria();
        Integer farMenuId = requestRefPar.getIntegerPar("farMenuId");
        String menuName = requestRefPar.getStringPar("menuName");

        if (farMenuId != null) {
            criteria.andFarMenuIdEqualTo(farMenuId);
        }
        if (!StringUtil.isNullOrEmpty(menuName)) {
            criteria.andMenuNameLike("%" + menuName + "%");
        }
        comMenuExample.setOrderByClause("FAR_MENU_ID,MENU_SEQ");
        comMenus = comMenuMapper.selectByExample(comMenuExample);

        responseData.setData(comMenus);
    }

    /**
     * @param httpSession
     * @param requestMdyPar
     * @param responseData
     */
    @Override
    public void modifyMenu(HttpSession httpSession, RequestMdyPar requestMdyPar, ResponseData responseData) {
        int personId;
        boolean jsonParseException = false;
        String type;
        Date now = new Date();
        Map<String, String> rowData;
        ComMenu comMenu;

        for (int row = 0; row < requestMdyPar.getParCount(); row++) {
            rowData = requestMdyPar.getInPar().get(row);
            type = requestMdyPar.getType(rowData);
            comMenu = (ComMenu) JsonUtil.readValueAsObject(rowData, ComMenu.class);
            if (null != comMenu) {
                personId = requestMdyPar.getPersonId(httpSession, now, rowData);
                switch (type) {
                    case CommUtil.MODIFY_TYPE_INSERT:
                        comMenu.setItime(now);
                        comMenu.setIperson(personId);
                        comMenu.setUtime(now);
                        comMenu.setUperson(personId);
                        comMenuMapper.insertSelective(comMenu);
                        break;
                    case CommUtil.MODIFY_TYPE_UPDATE:
                        comMenu.setUtime(now);
                        comMenu.setUperson(personId);
                        comMenuMapper.updateByPrimaryKeySelective(comMenu);
                        break;
                    case CommUtil.MODIFY_TYPE_DELETE:
                        comMenuMapper.deleteByPrimaryKey(comMenu.getMenuId());
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

    /**
     * @param httpSession
     * @param requestRefPar
     * @param responseData
     */
    @Override
    public void referAllForms(HttpSession httpSession, RequestRefPar requestRefPar, ResponseData responseData) {
        List<?> comForms;
        ComFormExample comFormExample = new ComFormExample();

        comFormExample.setOrderByClause("prgroup,form_id");
        comForms = comFormMapper.selectByExample(comFormExample);

        responseData.setData(comForms);
    }
}
