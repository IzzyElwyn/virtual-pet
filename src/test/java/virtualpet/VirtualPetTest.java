package virtualpet;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class VirtualPetTest {

	VirtualPet underTest = new VirtualPet();

	@Test
	public void assertThatHungerIsLessThan100AfterTick() throws InterruptedException {
		underTest.tick();
		int check = underTest.getHunger();
		assertTrue(check < 100);
	}

	//@Test
	public void assertThatHungerIs100AfterTickAnd1Feeding() throws InterruptedException {
		underTest.tick();
		underTest.feed();
		int check = underTest.getHunger();
		assertThat(check, is(100));
	}

	@Test
	public void assertThatCleanlinessIsLessThan100AfterTick() throws InterruptedException {
		underTest.tick();
		int check = underTest.getCleanliness();
		assertTrue(check < 100);
	}

	@Test
	public void assertThatCleanlinessIs100After1TickAndDustBath() throws InterruptedException {
		underTest.tick();
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
	public void assertThatBoredomIsLessThan100AfterTick() throws InterruptedException {
		underTest.tick();
		int check = underTest.getBoredom();
		assertTrue(check < 100);
	}

	@Test
	public void assertThatBoredomIs100AfterTickAnd1Song() throws InterruptedException {
		underTest.tick();
		underTest.singWithMogwai();
		int check = underTest.getBoredom();
		assertThat(check, is(100));
	}

	@Test
	public void assertThatTirednessIsLessThan100AfterTick() throws InterruptedException {
		underTest.tick();
		int check = underTest.getTiredness();
		assertTrue(check < 100);
	}

	@Test
	public void assertThatTirednessIs100AfterTickAndRest() throws InterruptedException {
		underTest.tick();
		underTest.rest();
		int check = underTest.getTiredness();
		assertThat(check, is(100));
	}

	public void assertThatHungerBelow80IsOkayMogwai() throws InterruptedException {
		do {
			underTest.tick();
		} while (underTest.getHunger() > 80);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Okay\n"));
	}

	//@Test
	public void assertThatBoredomBelow80IsOkayMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
		} while (underTest.getBoredom() > 80);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Okay\n"));
	}

	//@Test
	public void assertThatCleanlinessBelow80IsOkayMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
			underTest.singWithMogwai();
		} while (underTest.getCleanliness() > 80);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Okay\n"));
	}

	//@Test
	public void assertThatTirednessBelow80IsOkayMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
			underTest.singWithMogwai();
			underTest.dustBath();
		} while (underTest.getTiredness() > 80);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Okay\n"));
	}

	@Test
	public void assertThatHungerBelow40IsSadMogwai() throws InterruptedException {
		do {
			underTest.tick();
		} while (underTest.getHunger() > 40);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Sad\n"));
	}

	//@Test
	public void assertThatBoredomBelow40IsSadMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
		} while (underTest.getBoredom() > 40);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Sad\n"));
	}

	//@Test
	public void assertThatCleanlinessBelow40IsSadMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
			underTest.singWithMogwai();
		} while (underTest.getCleanliness() > 40);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Sad\n"));
	}

	//@Test
	public void assertThatTirednessBelow40IsSadMogwai() throws InterruptedException {
		do {
			underTest.tick();
			underTest.feed();
			underTest.singWithMogwai();
			underTest.dustBath();
		} while (underTest.getTiredness() > 40);
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Sad\n"));
	}

	@Test
	public void assertThatBoredomAbove80IsHappyMogwai() throws InterruptedException {
		underTest.tick();
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Happy\n"));
	}

	@Test
	public void assertThatHungerAbove80IsHappyMogwai() throws InterruptedException {
		underTest.tick();
		String check = underTest.getMood();
		assertThat(check, is("Gizmo is Happy\n"));
	}

	@Test
	public void assertThatOtherMogwaiCanBeGivenAway() {
		underTest.waterBath();
		underTest.giveAwayMogwai();
		int check = underTest.getNumMogwais();
		assertThat(check, is(3));
	}

	@Test
	public void assertThatYouCanSingWithMogwaiToRechargeBoredomBy25() throws InterruptedException {
		do {
			underTest.tick();
		} while (underTest.getBoredom() > 50);
		int beforeSong = underTest.getBoredom();
		underTest.singWithMogwai();
		int afterSong = underTest.getBoredom();
		int check = afterSong - beforeSong;
		assertThat(check, is(25));
	}

@Test
public void assertThatWalksRechargeBoredomBy50() throws InterruptedException {
	do {
		underTest.tick();
	} while (underTest.getBoredom() > 50);
	int beforeWalk = underTest.getBoredom();
	underTest.walkWithMogwai();
	int afterWalk = underTest.getBoredom();
	int check = afterWalk - beforeWalk;
	assertThat(check, is(50));
}

@Test
public void assertThatFeedingBetween0And6TransformsMogwai() throws InterruptedException {
	underTest.tick();
	underTest.feed();
	String check = underTest.getMood();
	assertThat(check, is("Gizmo is now a Gremlin.... Game Over"));
}
}