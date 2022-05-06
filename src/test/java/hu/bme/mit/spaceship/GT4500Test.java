package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore t1 = mock(TorpedoStore.class); 
  private TorpedoStore t2 = mock(TorpedoStore.class); 
  @BeforeEach
  public void init(){
    this.ship = new GT4500();

    this.ship.setprimaryTorpedo(t1);
    this.ship.setsecondaryTorpedo(t2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange

    // Act
    when(t1.fire(1)).thenReturn(true);
    //when(t2.fire(1)).thenReturn(true);
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    //verify(t1, times(1)).fire(1);
    verify(t1, times(1)).fire(1);
    assertEquals(true, result);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act

    when(t1.fire(1)).thenReturn(true);
    when(t2.fire(1)).thenReturn(true);
    when(t1.isEmpty()).thenReturn((false));
    when(t2.isEmpty()).thenReturn((false));

    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(t1, times(1)).fire(1);
    verify(t2, times(1)).fire(1);
    assertEquals(true, result);
  }

}
