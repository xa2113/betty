package com.codingnomads.betty.data.batch.batchprocessors;

import com.codingnomads.betty.data.batch.batchreaders.StatusItemReader;
import com.codingnomads.betty.data.models.Tweet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import twitter4j.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatusProcessorTests {

    @Mock
    private StatusItemReader mockStatusItemReader;
    private StatusProcessor testStatusProcessor;

    @Before
    public void setUp() throws Exception {
        mockStatusItemReader = mock(StatusItemReader.class);
        testStatusProcessor = new StatusProcessor(mockStatusItemReader);
    }

    @Test
    public void whenProcessorIsCalledWithListOfStatus_returnsAListOfTweets() throws Exception {
        List<Status> mockListOfStatus = new ArrayList<>();
        List<Tweet> expectedTweetsList = new ArrayList<>();

        when(mockStatusItemReader.getKeyword()).thenReturn("testWord");
        assertThat(testStatusProcessor.process(mockListOfStatus)).isEqualTo(expectedTweetsList);
    }

    @Test
    public void whenProcessorIsCalledWithNullListOfStatus_returnsANullListOfTweets() throws Exception {
        List<Status> mockListOfStatus = new ArrayList<>();
        mockListOfStatus.add(null);

        List<Tweet> expectedTweetsList = Collections.emptyList();

        when(mockStatusItemReader.getKeyword()).thenReturn("testWord");
        assertThat(testStatusProcessor.process(mockListOfStatus)).isEqualTo(expectedTweetsList);

    }
}
