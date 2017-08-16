package cn.meijunjie.testng;

import org.springframework.stereotype.Service;

@Service
public class EmailGeneratorImpl implements EmailGenerator {
    @Override
    public String createEmail() {
        return "mmeijunjie@163.com";
    }
}
