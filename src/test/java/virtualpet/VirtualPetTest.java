package virtualpet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class VirtualPetTest {
	
VirtualPet underTest = new VirtualPet();

@Test
public void assertThatHungerIs98After2Ticks() {
	underTest.tick(2);
	int check = underTest.getHunger();
	assertThat(check, is(98));
}

@Test
public void assertThatHungerIs95After10TicksAnd1Feeding() {
	underTest.tick(10);
	underTest.feed();
	int check = underTest.getHunger();
	assertThat(check, is(95));
}

@Test
public void assertThatCleanlinessIs85After15Ticks() {
	underTest.tick(15);
	int check = underTest.getCleanliness();
	assertThat(check, is(85));
}

@Test
public void assertThatCleanlinessIs100After15TicksAndDustBath() {
	underTest.tick(15);
	underTest.dustBath();
	int check = underTest.getCleanliness();
	assertThat(check, is(100));
}

@Test
public void assertThatWaterBathCreates3MoreMogwaiForTotalOf4() {
	underTest.waterBath();
	int check = underTest.getNumMogwais();
	assertThat(check, is(4));
}

@Test
public void assertThat2WaterBathCreates6MoreMogwaiForTotalOf7() {
	underTest.waterBath();
	underTest.waterBath();
	int check = underTest.getNumMogwais();
	assertThat(check, is(7));
}

@Test
public void assertThatBoredomIs75After25Ticks() {
	underTest.tick(25);
	int check = underTest.getBoredom();
	assertThat(check, is(75));
}

@Test
public void assertThatBoredomIs75After50TicksAnd1Song() {
	underTest.tick(50);
	underTest.Sing();
	int check = underTest.getBoredom();
	assertThat(check, is(75));
}

@Test
public void assertThatTirednessIs50After50Ticks() {
	underTest.tick(50);
	int check = underTest.getTiredness();
	assertThat(check, is(50));
}

@Test
public void assertThatTirednessIs100After50TicksAnd50TicksOfRest() {
	underTest.tick(50);
	underTest.rest(50);
	int check = underTest.getTiredness();
	assertThat(check, is(100));
}

@Test
public void assertThatHungerBelow80IsOkayMogwai() {
	underTest.tick(20);
	String check = underTest.getMood();
	assertThat(check, is("Gizmo is Okay"));
}

@Test
public void assertThatHungerBelow40IsSadMogwai() {
	underTest.tick(60);
	String check = underTest.getMood();
	assertThat(check, is("Gizmo is Sad"));
}

@Test
public void assertThatHungerAbove80IsHappyMogwai() {
	underTest.tick(10);
	String check = underTest.getMood();
	assertThat(check, is("Gizmo is Happy"));
}
}