package com.xebia.okr.okrmanageramitkumar.repository;

import com.xebia.okr.okrmanageramitkumar.domain.KeyResult;
import com.xebia.okr.okrmanageramitkumar.domain.KeyResultsStatus;
import com.xebia.okr.okrmanageramitkumar.domain.Objective;
import com.xebia.okr.okrmanageramitkumar.domain.Plan;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class KeyResultRepositoryTests {

    @Autowired
    private KeyResultRepository keyResultRepository;

    @Test
    public void test_to_create_records_in_key_results() {

        KeyResult keyResult = new KeyResult("certification", 95, 5, KeyResultsStatus.FINISHED,
                new Objective("make an objective", "running",
                        new Plan("okay it is a plan", new Date(), new Date())));
        KeyResult savedKeyResult = keyResultRepository.save(keyResult);
        Assert.assertEquals(savedKeyResult, keyResult);

    }

    @Test
    public void test_to_update_records_in_key_results() {

        KeyResult keyResult = new KeyResult("certification", 95, 5, KeyResultsStatus.FINISHED,
                new Objective("make an objective", "running",
                        new Plan("okay it is a plan", new Date(), new Date())));
        KeyResult savedKeyResult = keyResultRepository.save(keyResult);
        Assert.assertEquals(savedKeyResult, keyResult);
        savedKeyResult.setConfidenceScore(10);
        keyResultRepository.save(savedKeyResult);

        Optional<KeyResult> queriedUpdatedKeyResult = keyResultRepository.findById(savedKeyResult.getId());
        Assert.assertTrue(queriedUpdatedKeyResult.isPresent());
        Assert.assertEquals(queriedUpdatedKeyResult.get().getConfidenceScore(), 10);

    }

    @Test
    public void test_to_delete_records_in_key_results() {
        KeyResult keyResult = new KeyResult("certification", 95, 5, KeyResultsStatus.FINISHED,
                new Objective("make an objective", "running",
                        new Plan("okay it is a plan", new Date(), new Date())));
        KeyResult savedKeyResult = keyResultRepository.save(keyResult);
        Assert.assertEquals(savedKeyResult, keyResult);

        keyResultRepository.delete(savedKeyResult);
        Optional<KeyResult> queriedDeletedKeyResult = keyResultRepository.findById(savedKeyResult.getId());
        Assert.assertFalse(queriedDeletedKeyResult.isPresent());

    }

}
