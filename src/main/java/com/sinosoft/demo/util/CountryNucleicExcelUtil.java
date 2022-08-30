package com.sinosoft.demo.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.sinosoft.demo.pojo.CountryNucleic;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/8/14 12:22
 */
@Component
public class CountryNucleicExcelUtil {
    public void readExcel() {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("D:\\nucleic.xlsx"));
        List<CountryNucleic> result = reader.readAll(CountryNucleic.class);
        List<CountryNucleic> outputEntity = new ArrayList<>();
        for (CountryNucleic entity : result) {
            String xm = entity.getXm().trim();
            String zjhm = entity.getZjhm().trim();
            xm = xm.substring(1);
            zjhm = zjhm.substring(1);
            System.out.println("--" + xm + "--" + zjhm + "--");
            try {
                String url1 = "http://188.2.44.7:8080/openApi/demo/getCountryNucleic?name=" + xm + "&idCard=" + zjhm;
                String a = HttpUtil.createGet(url1).header("IIG-AUTH", "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw").execute().body();
                JSONObject jsonObject = JSONUtil.parseObj(a);
                String data = jsonObject.getStr("data");
                if (StrUtil.isNotBlank(data)) {
                    JSONObject jsonObject1 = JSONUtil.parseObj(data);
                    CountryNucleic temp = JSONUtil.toBean(jsonObject1, CountryNucleic.class);
                    outputEntity.add(temp);
                } else {
                    CountryNucleic temp = new CountryNucleic();
                    temp.setXm(xm);
                    temp.setZjhm(zjhm);
                    temp.setHsjcjg("对不起没有查询到相关信息");
                    outputEntity.add(temp);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ExcelWriter writer = ExcelUtil.getWriter(FileUtil.file("D:\\result.xlsx"));
        writer.addHeaderAlias("xm", "姓名");
        writer.addHeaderAlias("zjhm", "证件号码");
        writer.addHeaderAlias("hsjcjg", "检测结果");
        writer.addHeaderAlias("hsjcsj", "检测时间");
        writer.addHeaderAlias("hsjcjgmc", "检测机构");
        writer.write(outputEntity, true);
        writer.flush();
        writer.close();
    }
}
