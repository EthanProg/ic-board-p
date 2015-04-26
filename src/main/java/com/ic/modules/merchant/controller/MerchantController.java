package com.ic.modules.merchant.controller;

import com.ic.core.impl.CoreController;
import com.ic.core.model.Code;
import com.ic.modules.merchant.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xjw on 2015/4/26.
 */
@Controller()
@RequestMapping(value = "/merchant")
public class MerchantController extends CoreController
{

    @Autowired
    private IMerchantService merchantService;

    @RequestMapping(value = "/test")
    public void test()
    {
        System.out.println("测试一下，嘿嘿");
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("merchant_id", "111");
        data.put("merchant_name", "inspur");
        renderData("000", "成功", data);
    }

    @RequestMapping(value = "/queryMerchants")
    public void queryMerchants()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        List<Map<String,Object>> data_list = new ArrayList<Map<String, Object>>();
        try
        {
            data_list = merchantService.queryMerchantList(this.param_map);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        renderData(code, msg, data_list);
    }

    @RequestMapping(value = "/queryMerchant")
    public void queryMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        Map<String,Object> data_map = new HashMap<String, Object>();
        try
        {
            data_map = merchantService.queryMerchant(this.param_map);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        renderData(code, msg, data_map);
    }

    @RequestMapping(value = "/addMerchant")
    public void addMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.addMerchant(this.param_map);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        renderData(code, msg, new HashMap<String,Object>());
    }

    @RequestMapping(value = "/updateMerchant")
    public void updateMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.updateMerchant(this.param_map);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        renderData(code, msg, new HashMap<String,Object>());
    }

    @RequestMapping(value = "/deleteMerchant")
    public void deleteMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.deleteMerchant(this.param_map);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        renderData(code, msg, new HashMap<String,Object>());
    }
}