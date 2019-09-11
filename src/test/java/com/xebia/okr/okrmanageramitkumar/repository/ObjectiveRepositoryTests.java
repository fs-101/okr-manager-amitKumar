package com.xebia.okr.okrmanageramitkumar.repository;


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
public class ObjectiveRepositoryTests {

    @Autowired
    private ObjectiveRepository objectiveRepository;

    @Test
    public void test_to_create_objective() {

        Objective objective = new Objective("make an objective", "running",
                new Plan("okay it is a plan", new Date(), new Date()));
        Objective savedObjective = objectiveRepository.save(objective);
        Assert.assertEquals( savedObjective,objective);
    }

    @Test
    public void test_to_update_objective_records() {

        Objective objective = new Objective("make an objective", "running",
                new Plan("okay it is a plan", new Date(), new Date()));
        Objective savedObjective = objectiveRepository.save(objective);
        Assert.assertEquals( savedObjective,objective);

        savedObjective.setLabels("completed");
        objectiveRepository.save(savedObjective);
        Optional<Objective> queriedUpdatedObjective = objectiveRepository.findById(savedObjective.getId());
        Assert.assertEquals( queriedUpdatedObjective.get().getLabels(),"completed");
    }

    @Test
    public void test_to_delete_objective_records() {
        Objective objective = new Objective("make an objective", "running",
                new Plan("okay it is a plan", new Date(), new Date()));
        Objective savedObjective = objectiveRepository.save(objective);
        Assert.assertEquals( savedObjective,objective);

        objectiveRepository.delete(objective);
        Optional<Objective> queriedDeletedObjective = objectiveRepository.findById(savedObjective.getId());
        Assert.assertFalse(queriedDeletedObjective.isPresent());
    }
}
