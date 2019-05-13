package com.codingnomads.betty.data.batch.footballmatchjob;

import com.codingnomads.betty.data.batch.footballmatchjob.exceptions.EmptyItemException;
import com.codingnomads.betty.data.models.FootballMatchInfo;
import com.codingnomads.betty.logic.interfaces.FootballMatchesInfoJpaRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FootballMatchRdsWriter implements ItemWriter<List<FootballMatchInfo>> {

    private FootballMatchesInfoJpaRepository matchesInfoJpaRepository;

    @Autowired
    public FootballMatchRdsWriter(FootballMatchesInfoJpaRepository matchesInfoJpaRepository) {
        this.matchesInfoJpaRepository = matchesInfoJpaRepository;
    }

    @Override
    public void write(List<? extends List<FootballMatchInfo>> items) throws Exception {

        if(items == null){
            throw new EmptyItemException("There are no new football matches to write!");
        }

        for (List<FootballMatchInfo> matchList : items) {

            matchesInfoJpaRepository.saveAll(matchList);
        }
    }
}