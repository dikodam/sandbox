package de.dikodam.sandbox.java8streams;

import de.dikodam.sandbox.java8streams.dataholders.*;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class DataprocessorTest {

    @Tested
    Dataprocessor tested;

    @Injectable
    Dataholder dataholder;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void testGetDtosProzessdaten() {
        class TestImpl1 implements ProzessDatenDto {
        }
        class TestImpl2 implements ProzessDatenDto {
        }

        TestImpl1 korrekteImpl1 = new TestImpl1();
        TestImpl1 korrekteImpl2 = new TestImpl1();
        TestImpl2 falscheImpl = new TestImpl2();

        List<ProzessDatenDto> prozessDaten = new ArrayList<>(Arrays.asList(korrekteImpl1, korrekteImpl2, falscheImpl));

        new Expectations() {
            {
                dataholder.getProzessDatenDtos();
                result = prozessDaten;
                times = 1;
            }
        };

        List<TestImpl1> result = tested.getDtos(TestImpl1.class);

        assertThat(result, containsInAnyOrder(korrekteImpl1, korrekteImpl2));
    }

    @Test
    public void testGetDtosPersonenDaten() {
        class TestImpl1 implements PersonenDatenDto {
        }
        class TestImpl2 implements PersonenDatenDto {
        }

        TestImpl1 korrekteImpl1 = new TestImpl1();
        TestImpl1 korrekteImpl2 = new TestImpl1();
        TestImpl2 falscheImpl = new TestImpl2();

        List<PersonenDatenDto> prozessDaten = new ArrayList<>(Arrays.asList(korrekteImpl1, korrekteImpl2, falscheImpl));

        new Expectations() {
            {
                dataholder.getPersonenDatenDtos();
                result = prozessDaten;
                times = 1;
            }
        };

        List<TestImpl1> result = tested.getDtos(TestImpl1.class);

        assertThat(result, containsInAnyOrder(korrekteImpl1, korrekteImpl2));
    }

    @Test
    public void testGetDtosFachlicheDaten() {
        class TestImpl1 implements FachlicheDatenDto {
        }
        class TestImpl2 implements FachlicheDatenDto {
        }

        TestImpl1 korrekteImpl1 = new TestImpl1();
        TestImpl1 korrekteImpl2 = new TestImpl1();
        TestImpl2 falscheImpl = new TestImpl2();

        List<FachlicheDatenDto> prozessDaten = new ArrayList<>(Arrays.asList(korrekteImpl1, korrekteImpl2, falscheImpl));

        new Expectations() {
            {
                dataholder.getFachlicheDatenDtos();
                result = prozessDaten;
                times = 1;
            }
        };

        List<TestImpl1> result = tested.getDtos(TestImpl1.class);

        assertThat(result, containsInAnyOrder(korrekteImpl1, korrekteImpl2));
    }

    @Test
    public void testGetDtosException() {
        class FalscheImpl implements DatenDto {
        }

        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Übergebener Typ kein Untertyp von ProzessDatenDto, PersonenDatenDto oder FachlicheDatenDto!");

        tested.getDtos(FalscheImpl.class);
    }


}