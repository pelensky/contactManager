package com.pelensky.contactmanager;

import com.pelensky.contactmanager.DomainModels.Contact;
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

  @Test
  public void setterMethodFirstName() {
    danPelensky.setFirstName("Daniel");
    assertEquals("Daniel", danPelensky.getFirstName());
  }

  @Test
  public void setterMethodLastName() {
    danPelensky.setLastName("TheMan");
    assertEquals("TheMan", danPelensky.getLastName());
  }

  @Test
  public void setterMethodAddress() {
    danPelensky.setAddress("2 Commercial Street");
    assertEquals("2 Commercial Street", danPelensky.getAddress());
  }

  @Test
  public void setterMethodCity() {
    danPelensky.setCity("Melbourne");
    assertEquals("Melbourne", danPelensky.getCity());
  }

  @Test
  public void setterMethodPostCode() {
    danPelensky.setPostCode("E1100");
    assertEquals("E1100", danPelensky.getPostCode());
  }

  @Test
  public void setterMethodPhoneNumber() {
    danPelensky.setPhoneNumber("07111 111 111");
    assertEquals("07111 111 111", danPelensky.getPhoneNumber());
  }
}
