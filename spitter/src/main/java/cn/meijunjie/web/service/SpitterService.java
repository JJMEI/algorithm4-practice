package cn.meijunjie.web.service;

import cn.meijunjie.web.dao.Spitter;
import cn.meijunjie.web.dao.Spittle;

import java.util.List;

public interface SpitterService {

    Spitter findSpitter(String username);
    List<Spittle> getRecentSpittles(int spittlenum);
    List<Spittle> getSpittlesForSpitter(String username);
    boolean registerSpitter(Spitter spitter);
}
