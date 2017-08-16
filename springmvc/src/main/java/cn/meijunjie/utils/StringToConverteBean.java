package cn.meijunjie.utils;

import cn.meijunjie.dao.ConverterBean;
import org.springframework.core.convert.converter.Converter;

public class StringToConverteBean implements Converter<String,ConverterBean> {

    public ConverterBean convert(String source) {
        ConverterBean converterBean = new ConverterBean();


        if(source != null)
        {
            String[] items = source.split(":");
            converterBean.setName(items[0]);
            converterBean.setPassword(items[1]);
        }
        return converterBean;

    }
}
