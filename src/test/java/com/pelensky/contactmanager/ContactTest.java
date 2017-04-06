package com.pelensky.contactmanager;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ContactTest {

  private Contact danPelensky;

  @Before
  public void setUp() {
    danPelensky =
        new Contact("Dan", "Pelensky", "1 Commercial Street", "London", "E16LT", "07000 000 000");
  }

  @Test
  public void contactContainsFirstName() {
    assertEquals("Dan", danPelensky.getFirstName());
  }

  @Test
  public void contactContainsLastName() {
    assertEquals("Pelensky", danPelensky.getLastName());
  }

  @Test
  public void contactContainsAddress() {
    assertEquals("1 Commercial Street", danPelensky.getAddress());
  }

  @Test
  public void contactContainsCity() {
    assertEquals("London", danPelensky.getCity());
  }

  @Test
  public void contactContainsPostCode() {
    assertEquals("E16LT", danPelensky.getPostCode());
  }

  @Test
  public void contactContainsPhoneNumber() {
    assertEquals("07000 000 000", danPelensky.getPhoneNumber());
  }
}
