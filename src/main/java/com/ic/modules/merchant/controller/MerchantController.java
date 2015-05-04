package com.ic.modules.merchant.controller;

import com.ic.core.base.CoreController;
import com.ic.core.model.Code;
import com.ic.modules.merchant.service.IMerchantService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

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
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        Map<String,Object> temp1 = new HashMap<String,Object>();
        Map<String,Object> temp2 = new HashMap<String,Object>();
        temp1.put("merchant_id", "111");
        temp1.put("merchant_name", "111");
        temp2.put("merchant_id", "222");
        temp2.put("merchant_name", "222");
        list.add(temp1);
        list.add(temp2);
        data.put("data", list);
        data.put("code", "000");
        data.put("msg", "成功");
        data.put("transtime" , DateFormatUtils.format(new Date(), "yyyyMMdd hh:mm:ss:SSS"));
        //this.renderString(data);
    }

    @RequestMapping(value = "/queryMerchants")
    public void queryMerchants()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        Map<String,Object> data = new HashMap<String, Object>();
        List<Map<String, Object>> data_list = new ArrayList<Map<String, Object>>();
        data.put("data", data_list);
        try
        {
            data_list = merchantService.queryMerchantList(this.paramMap);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        data.put("code", code);
        data.put("msg", msg);
        data.put("transtime" , DateFormatUtils.format(new Date(), "yyyyMMdd hh:mm:ss:SSS"));
        //renderString(data);
    }

    @RequestMapping(value = "/queryMerchant")
    public void queryMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        Map<String,Object> data_map = new HashMap<String, Object>();
        try
        {
            data_map = merchantService.queryMerchant(this.paramMap);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        //renderData(code, msg, data_map);
    }

    @RequestMapping(value = "/addMerchant")
    public void addMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.addMerchant(this.paramMap);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        //renderData(code, msg, new HashMap<String,Object>());
    }

    @RequestMapping(value = "/updateMerchant")
    public void updateMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.updateMerchant(this.paramMap);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        //renderData(code, msg, new HashMap<String,Object>());
    }

    @RequestMapping(value = "/deleteMerchant")
    public void deleteMerchant()
    {
        String code = Code.SUCCESS;
        String msg = Code.SUCCESS_MSG;
        try
        {
            Map<String,Object> ret_map = merchantService.deleteMerchant(this.paramMap);
            code = String.valueOf(ret_map.get("code"));
            msg = String.valueOf(ret_map.get("msg"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
            code = Code.FAIL;
            msg = e.getMessage();
        }
        //renderData(code, msg, new HashMap<String,Object>());
    }
}
