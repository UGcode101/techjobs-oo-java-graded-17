package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class JobTest {

    // Test the Job constructor sets all fields correctly
    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(testJob.getName() instanceof String);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    // Test to ensure two Job objects with identical fields except for id are not considered equal
    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }

    // Test that toString starts and ends with a new line
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String output = job.toString();
        assertEquals('\n', output.charAt(0));
        assertEquals('\n', output.charAt(output.length() - 1));
    }

    // Test that toString contains correct labels and data
    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expected = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(expected, job.toString());
    }

    // Test that toString handles empty fields by providing a default message
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        String expected = "\n" +
                "ID: " + job.getId() + "\n" +
                "Name: Data not available" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Data not available" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Data not available" + "\n";
        assertEquals(expected, job.toString());
    }
}
