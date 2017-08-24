package cn.meijunjie.web.service;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.SpitterMapper;
import cn.meijunjie.web.dao.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpitterServiceImpl implements SpitterService {

    @Autowired
    private SpitterMapper spitterMapper;

    @Override
    public Spitter findSpitter(String username) {
        return spitterMapper.findSpitterByUserName(username);
    }

    @Override
    public List<Spittle> getRecentSpittles(int spittlenum) {
        return  spitterMapper.getRecentSpittle(spittlenum);
    }

    @Override
    public List<Spittle> getSpittlesForSpitter(String username) {
        return spitterMapper.getSpittlesForSpitter(spitterMapper.getSpitterByUsername(username));
    }

    @Override
    public boolean registerSpitter(Spitter spitter) {

        spitterMapper.addSpitter(spitter);
        if(spitterMapper.getSpitterByUsername(spitter.getUsername()) != null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
