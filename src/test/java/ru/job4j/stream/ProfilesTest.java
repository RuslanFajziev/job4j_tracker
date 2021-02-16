package ru.job4j.stream;

import org.junit.Test;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ProfilesTest {
    @Test
    public void collectTect() {
        Address address1 = new Address("Moscow", "Birulevo", 1, 45);
        Address address2 = new Address("Bryansk", "Rabochay", 2, 4);

        Profile prf1 = new Profile(address1, 40, true);
        Profile prf2 = new Profile(address2, 60, false);
        Profile prf3 = new Profile(address1, 20, true);
        Profile prf4 = new Profile(address2, 30, true);

        List<Profile> lstProf = List.of(prf1, prf2, prf3, prf4);
        List<Address> lstAddr = Profiles.collect(lstProf);
        List<Address> lstAddrCheck = List.of(address2, address1);
        assertThat(lstAddrCheck, is(lstAddr));
    }
}