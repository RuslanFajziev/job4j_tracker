package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void SortIncrease() {
        Item itmF = new Item();
        itmF.setName("Fix bugs");
        itmF.setId(4);
        Item itmS = new Item();
        itmS.setName("Impl task");
        itmS.setId(2);
        Item itmT = new Item();
        itmT.setName("Reboot server");
        itmT.setId(1);
        List<Item> itemsFirst = Arrays.asList(itmT, itmF, itmS);
        List<Item> itemsSecond = Arrays.asList(itmF, itmS, itmT);
        Collections.sort(itemsFirst, new SortItems());
        assertThat(itemsFirst, is(itemsSecond));
    }

    @Test
    public void SortDecrease() {
        Item itmF = new Item();
        itmF.setName("Fix bugs");
        itmF.setId(4);
        Item itmS = new Item();
        itmS.setName("Impl task");
        itmS.setId(2);
        Item itmT = new Item();
        itmT.setName("Reboot server");
        itmT.setId(1);
        List<Item> itemsFirst = Arrays.asList(itmT, itmF, itmS);
        List<Item> itemsSecond = Arrays.asList(itmT, itmS, itmF);
        Collections.sort(itemsFirst, new SortItems().reversed());
        assertThat(itemsFirst, is(itemsSecond));
    }
}