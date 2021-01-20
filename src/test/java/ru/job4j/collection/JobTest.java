package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {

    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobSortNameUp().thenComparing(new JobSortPriorUp());
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Impl task", 0));
        jobs.add(new Job("Fix bug", 1));
        Collections.sort(jobs, cmpNamePriority);

        List<Job> jobs2 = new ArrayList<>();
        jobs2.add(new Job("Fix bug", 1));
        jobs2.add(new Job("Impl task", 0));

        assertThat(jobs, is(jobs2));
    }

    @Test
    public void whenCompatorByNameAndPrority2() {
        Comparator<Job> cmpNamePriority = new JobSortNameUp().thenComparing(new JobSortPriorUp());
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Impl task", 3));
        jobs.add(new Job("Impl task", 1));
        Collections.sort(jobs, cmpNamePriority);

        List<Job> jobs2 = new ArrayList<>();
        jobs2.add(new Job("Impl task", 1));
        jobs2.add(new Job("Impl task", 3));

        assertThat(jobs, is(jobs2));
    }

    @Test
    public void whenCompatorByNameAndPrority3() {
        Comparator<Job> cmpNamePriority = new JobSortNameDown().thenComparing(new JobSortPriorDown());
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Impl task", 0));
        jobs.add(new Job("Fix bug", 1));
        Collections.sort(jobs, cmpNamePriority);

        List<Job> jobs2 = new ArrayList<>();
        jobs2.add(new Job("Impl task", 0));
        jobs2.add(new Job("Fix bug", 1));

        assertThat(jobs, is(jobs2));
    }

    @Test
    public void whenCompatorByNameAndPrority4() {
        Comparator<Job> cmpNamePriority = new JobSortNameDown().thenComparing(new JobSortPriorDown());
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Impl task", 1));
        jobs.add(new Job("Impl task", 3));
        Collections.sort(jobs, cmpNamePriority);

        List<Job> jobs2 = new ArrayList<>();
        jobs2.add(new Job("Impl task", 3));
        jobs2.add(new Job("Impl task", 1));

        assertThat(jobs, is(jobs2));
    }

    @Test
    public void whenCompatorByNameAndPrority5() {
        Comparator<Job> cmpNamePriority = new JobSortNameUp().thenComparing(new JobSortPriorDown());
        List<Job> jobs = new ArrayList<>();
        jobs.add(new Job("Impl task", 1));
        jobs.add(new Job("Impl task", 3));
        Collections.sort(jobs, cmpNamePriority);

        List<Job> jobs2 = new ArrayList<>();
        jobs2.add(new Job("Impl task", 3));
        jobs2.add(new Job("Impl task", 1));

        assertThat(jobs, is(jobs2));
    }

    @Test
    public void whenCompatorByNameAndPrority6() {
        Comparator<Job> cmpNamePriority = new JobSortNameUp().thenComparing(new JobSortPriorDown());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}