package org.launchcode.techjobs.oo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {

    Job job1, job2, job3;

    @Before
    public void createJobObjects() {
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job3 = new Job("Ice cream tester", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Tasting ability"));
    }

    @Test
    public void testSettingJobId() {
        Job job4 = new Job();
        Job job5 = new Job();
        assertNotEquals(job4.getId(), job5.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job1.getEmployer() instanceof Employer);
        assertTrue(job1.getLocation() instanceof Location);
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job1.getName());
        assertEquals("ACME", job1.getEmployer().getValue());
        assertEquals("Desert", job1.getLocation().getValue());
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertEquals("Persistence", job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job6.equals(job7));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        char firstChar = job1.toString().charAt(0);
        char lastChar = job1.toString().charAt(job1.toString().length() - 1);
        assertEquals('\n', firstChar);
        assertEquals('\n', lastChar);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String expected = "\n" +
                "ID: " + job1.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(expected, job1.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String expected = "\n" +
                "ID: " + job3.getId() + "\n" +
                "Name: Ice cream tester" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Home" + "\n" +
                "Position Type: UX" + "\n" +
                "Core Competency: Tasting ability" + "\n";
        assertEquals(expected, job3.toString());
    }
}
//test
