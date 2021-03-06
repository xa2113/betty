package com.codingnomads.betty.data.rds;

import com.codingnomads.betty.data.models.Tweet;
import com.codingnomads.betty.logic.interfaces.TwitterJpaRepository;
import com.codingnomads.betty.data.repositories.TwitterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AmazonRdsRepository implements TwitterRepository {

    private TwitterJpaRepository twitterJpaRepository;

    @Autowired
    public AmazonRdsRepository(TwitterJpaRepository twitterJpaRepository) {
        this.twitterJpaRepository = twitterJpaRepository;
    }

    @Override
    public Boolean saveTweets(List<Tweet> listOfTweets) {
        return saveListToDatabaseAndFlush(listOfTweets);
    }

    private Boolean saveListToDatabaseAndFlush(List<Tweet> listOfTweets) {
        twitterJpaRepository.saveAll(listOfTweets);
        twitterJpaRepository.flush();
        return true;
    }


}
