package com.xebia.okr.okrmanageramitkumar.repository;



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
public class PlanRepositoryTests {

    @Autowired
    private PlanRepository planRepository;


    @Test
    public void test_to_see_whether_plan_records_are_created() {

        Plan plan = new Plan("Make a betting app", new Date(), new Date());
        Plan savedPlan = planRepository.save(plan);
        Assert.assertEquals(savedPlan,plan);
    }

    @Test
    public void test_to_see_plan_records_are_updated() {

        Plan plan = new Plan("Make a betting app", new Date(), new Date());
        Plan savedPlan = planRepository.save(plan);
        Assert.assertEquals(savedPlan,plan);

        savedPlan.setTitle("change plan to build a home");
        planRepository.save(savedPlan);
        Optional<Plan> queriedUpdatedPlan = planRepository.findById(savedPlan.getId());
        Assert.assertEquals( queriedUpdatedPlan.get().getTitle(),"change plan to build a home");
    }

    @Test
    public void test_to_see_plan_records_are_deleted() {

        Plan plan = new Plan("Make a betting app", new Date(), new Date());
        Plan savedPlan = planRepository.save(plan);
        Assert.assertEquals(savedPlan,plan);

        planRepository.deleteById(savedPlan.getId());
        Optional<Plan> queriedUpdatedPlan = planRepository.findById(savedPlan.getId());
        Assert.assertFalse(queriedUpdatedPlan.isPresent());


    }
}

